package controller;

import service.implement_ser.EmployeeService;
import service.interface_ser.IEmployeeService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeController {
    private static Scanner scanner = new Scanner(System.in);
    private static IEmployeeService employeeService = new EmployeeService();
    public static void displayEmployeeManagementMenu() {

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
                choice = Integer.parseInt(scanner.nextLine());
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
}
