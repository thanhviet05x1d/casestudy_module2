package controller;

import service.implement_ser.FacilityService;
import service.interface_ser.IFacilityService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FacilityController {
    private static Scanner scanner = new Scanner(System.in);
    private static IFacilityService facilityService = new FacilityService();
    public static void displayFacilityManagementMenu() {
        int choice;
        do {
            try {
                System.out.println("\nFACILITY MANAGEMENT MENU");
                System.out.println("1. Display list of facilities");
                System.out.println("2. Add new facility");
                System.out.println("3. Display facilities that need maintenance");
                System.out.println("4. Delete facility");
                System.out.println("5. Back to main menu");
                System.out.print("Your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
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
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.nextLine(); // Clear the invalid input
                choice = 0; // Set the choice to an invalid value to re-enter the loop
            }
        } while (choice != 5);
    }

    // Hiển thị menu để thêm mới Facility
    private static void displayAddFacilityMenu() {
        System.out.println("\nADD NEW FACILITY MENU");
        System.out.println("1. Add New Villa");
        System.out.println("2. Add New House");
        System.out.println("3. Add New Room");
        System.out.println("4. Back to menu");
        System.out.print("Your choice: ");
        int choice =Integer.parseInt(scanner.nextLine());
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
                return; // <-- Back
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
