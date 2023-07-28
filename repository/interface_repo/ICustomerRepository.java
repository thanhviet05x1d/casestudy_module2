package repository.interface_repo;

import model.booking.Booking;
import model.person.Customer;
import model.person.Employee;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAllCustomers();

    void addCustomer(Customer customer);

    void editCustomer(String id, Customer customer);

    void deleteCustomer(String idCardNumber);

    List<Customer> searchCustomersByName(String searchName);

    List<Booking> getBookingsCurrentMonth();

    void bookingsGetVoucher();

}
