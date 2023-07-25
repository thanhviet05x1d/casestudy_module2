package service;

import model.Booking;
import model.Customer;
import repository.CustomerRepository;
import repository.ICustomerRepository;
import utils.PersonInvalidInputException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    ICustomerRepository customerRepository = new CustomerRepository();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void getAllCustomers() {
        List<Customer> customerList = customerRepository.getAllCustomers();
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    @Override
    public Customer getCustomerById(String customerId) {
        return null;
    }

    @Override
    public void addCustomer() {
        System.out.println("------ Add New Customer ------");

        System.out.print("Enter Customer ID: ");
        String idCardNumber = scanner.nextLine();

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter customer code (KH-YYYY): ");
        String customerID = scanner.nextLine();


        System.out.print("Enter customer date of birth (yyyy-MM-dd): ");
        String dobString = scanner.nextLine();

        Date dateOfBirth = null;
        try {
            dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(dobString);
        } catch (ParseException e) {
            System.out.println("Error: Invalid date format. Please enter the date in yyyy-MM-dd format.");
        }

        System.out.print("Enter gender of customer(male/female): ");
        String gender = scanner.nextLine();


        System.out.print("Enter customer phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter email of customer: ");
        String email = scanner.nextLine();

        System.out.print("Enter type of customer: ");
        String type = scanner.nextLine();

        System.out.print("Enter address of customer: ");
        String address = scanner.nextLine();


        try {
            Customer customer = new Customer(idCardNumber, name, customerID, dateOfBirth, gender, phoneNumber, email, type, address);
            customer.validateInput();
            customerRepository.addCustomer(customer);
            System.out.println("Customer added successfully.");
        } catch (PersonInvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void editCustomer() {
        System.out.println("Enter ID customer to Edit:");
        String id = scanner.nextLine();
        System.out.println("Nhập ID mới:");
        String idNew = scanner.nextLine();
        customerRepository.editCustomer(id, idNew);
    }

    @Override
    public void deleteCustomer() {
        System.out.println("Enter ID employee to delete:");
        String idCardNumber = scanner.nextLine();
        customerRepository.deleteCustomer(idCardNumber);
    }

    @Override
    public void searchCustomerByName() {
        System.out.println("Enter name of customer to search:");
        String searchName = scanner.nextLine();
        List<Customer> customerSearchList = customerRepository.searchCustomersByName(searchName);
        for (Customer c : customerSearchList) {
            System.out.println(c);
        }
    }

    @Override
    public void getBookingsCurrentMonth() {
        List<Booking> bookingCurrentMonthList = customerRepository.getBookingsCurrentMonth();
        for (Booking b : bookingCurrentMonthList) {
            System.out.println(b);
        }
    }

    @Override
    public void bookingsGetVoucher() {
        customerRepository.bookingsGetVoucher();
    }
}
