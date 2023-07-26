package service.interface_ser;

import model.person.Customer;

public interface ICustomerService {
    void getAllCustomers();

    Customer getCustomerById(String customerId);

    void addCustomer();

    void editCustomer();

    void deleteCustomer();

    void searchCustomerByName();

    void bookingsGetVoucher();

    void getBookingsCurrentMonth();
}

