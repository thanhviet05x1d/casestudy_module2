package service.implement_ser;

import model.booking.Booking;
import model.person.Customer;
import model.facility.Facility;
import repository.implement_repo.BookingRepository;
import repository.implement_repo.CustomerRepository;
import repository.implement_repo.FacilityRepository;
import repository.interface_repo.IBookingRepository;
import repository.interface_repo.ICustomerRepository;
import repository.interface_repo.IFacilityRepository;
import service.interface_ser.IBookingService;

import java.time.LocalDate;
import java.util.*;

public class BookingService implements IBookingService {
    IBookingRepository bookingRepository = new BookingRepository();
    ICustomerRepository customerRepository = new CustomerRepository();
    IFacilityRepository facilityRepository = new FacilityRepository();

    Scanner scanner = new Scanner(System.in);

    @Override
    public void displayAllBookings() {
        Set<Booking> bookingSet = bookingRepository.displayAllBookings();
        System.out.println("--- List of bookings ---");
        for (Booking booking : bookingSet) {
            System.out.println(booking);
        }
    }

    @Override
    public void addNewBooking() {
        System.out.println("--- Add New Booking ---");
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
        LocalDate startDate = LocalDate.parse(startDateString);

        System.out.print("Enter end date (yyyy-MM-dd): ");
        String endDateString = scanner.nextLine();
        LocalDate endDate = LocalDate.parse(endDateString);

        Booking booking = new Booking(bookingId, customerId, facilityId, startDate, endDate);
        bookingRepository.addBooking(booking);

        // Cập nhật số lần sử dụng của facility sau khi booking thành công
        for (Facility facility : facilityList.keySet()) {
            if (facility.getFacilityID().equals(facilityId)) {
                facilityList.put(facility, facilityList.get(facility) + 1);
                break;
            }
        }
        System.out.println("Booking added successfully!");

    }

    @Override
    public void deleteNewBooking() {
        System.out.println("Enter booking ID to delete:");
        String bookingId = scanner.nextLine();
        bookingRepository.deleteBooking(bookingId);
    }
}
