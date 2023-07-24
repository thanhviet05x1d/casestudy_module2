package service;

import model.Booking;
import model.Customer;
import model.Facility;
import repository.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookingService implements IBookingService {
    IBookingRepository bookingRepository = new BookingRepository();
    ICustomerRepository customerRepository = new CustomerRepository();
    IFacilityRepository facilityRepository = new FacilityRepository();

    Scanner scanner = new Scanner(System.in);

    @Override
    public void displayAllBookings() {
        Set<Booking> bookingSet = bookingRepository.displayAllBookings();
        for (Booking booking : bookingSet) {
            System.out.println(booking);

        }
    }
    @Override
    public void addNewBooking() {
        System.out.println("------ Add New Booking ------");
        System.out.print("Enter booking ID: ");
        String bookingId = scanner.nextLine();

        // Hiển thị danh sách khách hàng để nhập mã
        List<Customer> customerList = customerRepository.getAllCustomers();
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();

        // Hiển thị danh sách Facility để nhập mã
        Map<Facility, Integer> facilityList = facilityRepository.getFacilities();
        for (Facility key : facilityList.keySet()) {
            System.out.println(key + " : " + facilityList.get(key));
        }

        System.out.print("Enter facility ID: ");
        String facilityId = scanner.nextLine();

        System.out.print("Enter start date (yyyy-MM-dd): ");
        String startDateString = scanner.nextLine();

        System.out.print("Enter end date (yyyy-MM-dd): ");
        String endDateString = scanner.nextLine();

        try {
            Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateString);
            Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateString);

            Booking booking = new Booking(bookingId, customerId, facilityId, startDate, endDate);
            bookingRepository.addBooking(booking);

            // Cập nhật số lần sử dụng của facility sau khi booking thành công
            for (Facility facility : facilityList.keySet()) {
                if (facility.getFacilityID().equals(facilityId)) {
                    facilityList.put(facility, facilityList.get(facility) + 1);
                    break;
                }
            }

            System.out.println("Booking added successfully.");

        } catch (ParseException e) {
            System.out.println("Error: Invalid date format. Please enter the date in yyyy-MM-dd format.");
        }
    }


}
