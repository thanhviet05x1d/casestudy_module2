package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FuramaController {
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
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        EmployeeController.displayEmployeeManagementMenu();
                        break;
                    case 2:
                        CustomerController.displayCustomerManagementMenu();
                        break;
                    case 3:
                        FacilityController.displayFacilityManagementMenu();
                        break;
                    case 4:
                        BookingController.displayBookingManagementMenu();
                        break;
                    case 5:
                        PromotionController.displayPromotionManagementMenu();
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
}
