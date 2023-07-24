package controller;

import service.*;


import java.util.InputMismatchException;
import java.util.Scanner;

public class FuramaController {
    private static IEmployeeService employeeService = new EmployeeService();
    private ICustomerService customerService = new CustomerService();
    private static IFacilityService facilityService = new FacilityService();
    private static IBookingService bookingService = new BookingService();
    private static IContractService contractService = new ContractService();

    private IPromotionService promotionService = new PromotionService();

    private static Scanner scanner = new Scanner(System.in);

    public void displayMainMenu() {
        int choice;
        do {
            try {
                System.out.println("------ FURAMA MANAGEMENT SYSTEM ------");
                System.out.println("1. Employee Management");
                System.out.println("2. Customer Management");
                System.out.println("3. Facility Management");
                System.out.println("4. Booking Management");
                System.out.println("5. Promotion Management");
                System.out.println("6. Exit");
                System.out.print("Enter your choice (1-6): ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        displayEmployeeManagementMenu();
                        break;
                    case 2:
                        displayCustomerManagementMenu();
                        break;
                    case 3:
                        displayFacilityManagementMenu();
                        break;
                    case 4:
                        displayBookingManagementMenu();
                        break;
                    case 5:
                        displayPromotionManagementMenu();
                        break;
                    case 6:
                        System.out.println("Exiting the program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose a number between 1 and 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                scanner.nextLine(); // Clear the invalid input
                choice = 0; // Set the choice to an invalid value to re-enter the loop
            }
        } while (choice != 6);
    }

    private void displayEmployeeManagementMenu() {
        int choice;
        do {
            try {
                System.out.println("------ Employee Management ------");
                System.out.println("1. Display list employees");
                System.out.println("2. Add new employee");
                System.out.println("3. Edit employee");
                System.out.println("4. Delete employee");
                System.out.println("5. Search by name employee");
                System.out.println("6. Return main menu");
                System.out.print("Enter your choice (1-6): ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        employeeService.getAllEmployees();
                        break;
                    case 2:
                        employeeService.addEmployee();
                        break;
                    case 3:
                        employeeService.editEmployee();

                        break;
                    case 4:
                        employeeService.deleteEmployee();

                        break;
                    case 5:
                        employeeService.searchEmployeesByName();
                        break;
                    case 6:
                        return; // Return to the main menu
                    default:
                        System.out.println("Invalid choice. Please choose a number between 1 and 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                scanner.nextLine(); // Clear the invalid input
                choice = 0; // Set the choice to an invalid value to re-enter the loop
            }
        } while (choice != 6);
    }


    private void displayCustomerManagementMenu() {
        int choice;
        do {
            try {
                System.out.println("------ Customer Management ------");
                System.out.println("1. Display list customers");
                System.out.println("2. Add new customer");
                System.out.println("3. Edit customer");
                System.out.println("4. Delete customer");
                System.out.println("5. Search by name customer");
                System.out.println("6. Return main menu");
                System.out.print("Enter your choice (1-6): ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

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
                        return; // Return to the main menu
                    default:
                        System.out.println("Invalid choice. Please choose a number between 1 and 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                scanner.nextLine(); // Clear the invalid input
                choice = 0; // Set the choice to an invalid value to re-enter the loop
            }
        } while (choice != 6);
    }

    private void displayFacilityManagementMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nFACILITY MANAGEMENT MENU");
            System.out.println("1. Display list of facilities");
            System.out.println("2. Add new facility");
            System.out.println("3. Display facilities that need maintenance");
            System.out.println("4. Delete facility");
            System.out.println("5. Back to main menu");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    facilityService.displayFacilities();
                    break;
                case 2:
                    displayAddFacilityMenu();
                    break;
                case 3:
                    facilityService.displayFacilitiesNeedMaintenance();
                    break;
                case 4:
                    facilityService.deleteFacility();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Hiển thị menu để thêm mới Facility
    private void displayAddFacilityMenu() {
        System.out.println("\nADD NEW FACILITY MENU");
        System.out.println("1. Add New Villa");
        System.out.println("2. Add New House");
        System.out.println("3. Add New Room");
        System.out.println("4. Back to menu");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                facilityService.addNewVilla();
                break;
            case 2:
                facilityService.addNewHouse();
                break;
            case 3:
                facilityService.addNewRoom();
                break;
            case 4:
                break; // <-- Back
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }


    private void displayBookingManagementMenu() {
        boolean exitMenu = false;
        while (!exitMenu) {
            System.out.println("\nBOOKING MANAGEMENT MENU");
            System.out.println("1. Add New Booking");
            System.out.println("2. Display All Bookings");
            System.out.println("3. Create New Contracts");
            System.out.println("4. Display List of Contracts");
            System.out.println("5. Edit Contracts");
            System.out.println("6. Return to Main Menu");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Read the newline character after reading the number

            switch (choice) {
                case 1:
                    bookingService.addNewBooking();
                    break;
                case 2:
                    bookingService.displayAllBookings();
                    break;
                case 3:
                    contractService.createNewContract();
                    break;
                case 4:
                    contractService.displayContracts();

                    break;
                case 5:
                   contractService.editContract();
                    break;
                case 6:
                    exitMenu = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayPromotionManagementMenu() {
        boolean exitMenu = false;
        while (!exitMenu) {
            System.out.println("\nPROMOTION MANAGEMENT MENU");
            System.out.println("1. Display List of Customers Using Services");
            System.out.println("2. Display List of Customers Getting Vouchers");
            System.out.println("3. Return to Main Menu");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Read the newline character after reading the number

            switch (choice) {
                case 1:
//                    promotionService.getAllPromotions();
                    break;
                case 2:
                    promotionService.getAllPromotions();
                    break;
                case 3:
                    exitMenu = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
