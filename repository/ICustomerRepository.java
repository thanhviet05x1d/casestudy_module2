package repository;

import model.Booking;
import model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAllCustomers();

    void addCustomer(Customer customer);

    void editCustomer(String id, String idNew);

    void deleteCustomer(String idCardNumber);

    List<Customer> searchCustomersByName(String searchName);

    List<Booking> getBookingsCurrentMonth();

    void bookingsGetVoucher();

}
