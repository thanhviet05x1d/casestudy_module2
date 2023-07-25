package service;

import model.Customer;

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

