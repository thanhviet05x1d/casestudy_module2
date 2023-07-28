package service.implement_ser;

import model.booking.Booking;
import model.person.Customer;
import model.person.Employee;
import repository.implement_repo.CustomerRepository;
import repository.interface_repo.ICustomerRepository;
import service.interface_ser.ICustomerService;
import utils.PersonInvalidInputException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    ICustomerRepository customerRepository = new CustomerRepository();
    Scanner scanner = new Scanner(System.in);

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

        LocalDate dateOfBirth = LocalDate.parse(dobString);

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

        List<Customer> customerList = customerRepository.getAllCustomers();
        boolean found = false;
        for (Customer customer : customerList) {
            if (customer.getIdCardNumber().equals(id)) {
                found = true;
                break;
            }
        }
        if (found == false) {
            System.out.println("Id can not found!");
            return;
        }

        System.out.print("Enter Customer ID: ");
        String idCardNumber = scanner.nextLine();

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter customer code (KH-YYYY): ");
        String customerID = scanner.nextLine();


        System.out.print("Enter customer date of birth (yyyy-MM-dd): ");
        String dobString = scanner.nextLine();

        LocalDate dateOfBirth = LocalDate.parse(dobString);

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
            customerRepository.editCustomer(id,customer);
            System.out.println("Customer added successfully.");
        } catch (PersonInvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }

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
