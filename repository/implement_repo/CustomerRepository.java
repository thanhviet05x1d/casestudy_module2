package repository.implement_repo;

import data.ReadWriteCustomerData;
import model.booking.Booking;
import model.person.Customer;
import model.promotion.Promotion;
import repository.interface_repo.IBookingRepository;
import repository.interface_repo.ICustomerRepository;
import repository.interface_repo.IPromotionRepository;

import java.time.LocalDate;
import java.util.*;

public class CustomerRepository implements ICustomerRepository {

    List<Customer> customerList = new ArrayList<>();
    IBookingRepository bookingRepository = new BookingRepository();
    private static final String CSV_FILE_PATH = "D:\\R_CODE_GYM_MY_STUDY\\c0523g1_nguyen_thanh_viet_module2\\FuramaResort\\src\\data\\employee.csv";
    private static final String CSV_SEPARATOR = ",";
    private static final String HEADER = "idCardNumber,name,customerID,dateOfBirth,gender,phoneNumber,email,type,address";

    @Override
    public List<Customer> getAllCustomers() {
        customerList = ReadWriteCustomerData.readDataCustomerFromFile();
        return customerList;
    }


    @Override
    public void addCustomer(Customer customer) {
        customerList = ReadWriteCustomerData.readDataCustomerFromFile();
        customerList.add(customer);
        ReadWriteCustomerData.writeDataCustomerToFile(customerList, false);
    }

    @Override
    public void editCustomer(String id, Customer customer) {
        customerList = ReadWriteCustomerData.readDataCustomerFromFile();
        for (Customer c : customerList) {
            if (c.getIdCardNumber().equals(id)) {
                c.setIdCardNumber(customer.getIdCardNumber());
                c.setName(customer.getName());
                c.setCustomerID(customer.getCustomerID());
                c.setDateOfBirth(customer.getDateOfBirth());
                c.setGender(customer.getGender());
                c.setPhoneNumber(customer.getPhoneNumber());
                c.setEmail(customer.getEmail());
                c.setType(customer.getType());
                c.setAddress(customer.getAddress());
                ReadWriteCustomerData.writeDataCustomerToFile(customerList, false);
            }
            break;
        }
    }

    @Override
    public void deleteCustomer(String idCardNumber) {
        customerList = ReadWriteCustomerData.readDataCustomerFromFile();
        for (Customer c : customerList) {
            if (c.getIdCardNumber().equals(idCardNumber)) {
                customerList.remove(c);
                ReadWriteCustomerData.writeDataCustomerToFile(customerList, false);
                break;
            }
        }
    }

    @Override
    public List<Customer> searchCustomersByName(String searchName) {
        customerList = ReadWriteCustomerData.readDataCustomerFromFile();
        List<Customer> searchCustomerList = new ArrayList<>();
        for (Customer c : customerList) {
            if (c.getName().contains(searchName)) {
                searchCustomerList.add(c);
            }
        }
        return searchCustomerList;
    }



    @Override
    public Stack<Booking> getBookingsCurrentMonth() {

        //1. Lấy tháng hiện tại từ ngày hiện tại

        int currentMonth = LocalDate.now().getMonthValue();

        //2. Lấy ra danh sách booking trong tháng hiện tại
        Stack<Booking> bookingsInCurrentMonth = new Stack<>();
        Set<Booking> bookingSet = bookingRepository.displayAllBookings();
        for (Booking booking : bookingSet) {
            // Lấy tháng từ startDate
            int startMonth = booking.getStartDate().getMonthValue();

            // Nếu tháng bằng với tháng hiện tại, thêm Booking vào danh sách kết quả
            if (startMonth == currentMonth) {
                bookingsInCurrentMonth.add(booking);
            }
        }
        return bookingsInCurrentMonth;
    }

    @Override
    public void bookingsGetVoucher() {

        // 1. Lấy Stack từ method getBookingsCurrentMonth()
        Stack<Booking> bookingsInCurrentMonth = getBookingsCurrentMonth();

        // 2. Tặng Voucher cho khách hàng booking sớm trong tháng.
        IPromotionRepository promotionRepository = new PromotionRepository();
        Set<Promotion> promotionSet = promotionRepository.getAllPromotions();

        while (!bookingsInCurrentMonth.isEmpty()) {
            Booking booking = bookingsInCurrentMonth.pop();
            for (Promotion p : promotionSet) {
                if (p.getNumber() > 0) {
                    System.out.println(booking + " - " + p.getPromotionType());
                    p.setNumber(p.getNumber() - 1);
                    break;
                }
            }
        }
    }
}
