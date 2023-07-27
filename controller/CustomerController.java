package controller;

import service.implement_ser.CustomerService;
import service.interface_ser.ICustomerService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerController {
    private static Scanner scanner = new Scanner(System.in);
    private static ICustomerService customerService = new CustomerService();

    public static void displayCustomerManagementMenu() {
        int choice;
        do {
            try {
                System.out.println("------ Customer Management ------");
                System.out.println("1. Display list customers");
                System.out.println("2. Add new customer");
                System.out.println("3. Edit customer");
                System.out.println("4. Delete customer");
                System.out.println("5. Search by name customer");
                System.out.println("6. Get Customers in current month");
                System.out.println("7. Return main menu");
                System.out.print("Enter your choice (1-7): ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        customerService.getAllCustomers();
                        break;
                    case 2:
                        customerService.addCustomer();
                        break;
                    case 3:
                        customerService.editCustomer();
                        break;
                    case 4:
                        customerService.deleteCustomer();
                        break;
                    case 5:
                        customerService.searchCustomerByName();
                        break;
                    case 6:
                        customerService.bookingsGetVoucher();
                        break;
                    case 7:
                        return; // Return to the main menu
                    default:
                        System.out.println("Invalid choice. Please choose a number between 1 and 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                scanner.nextLine(); // Clear the invalid input
                choice = 0; // Set the choice to an invalid value to re-enter the loop
            }
        } while (choice != 7);
    }
}
