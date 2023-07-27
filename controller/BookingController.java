package controller;

import service.implement_ser.BookingService;
import service.implement_ser.ContractService;
import service.interface_ser.IBookingService;
import service.interface_ser.IContractService;

import java.util.Scanner;

public class BookingController {
    private static Scanner scanner = new Scanner(System.in);
    private static IBookingService bookingService = new BookingService();
    private static IContractService contractService = new ContractService();

    public static void displayBookingManagementMenu(){
        boolean exitMenu = false; // Thử một cách viết khác
        while (!exitMenu) {
            System.out.println("\nBOOKING MANAGEMENT MENU");
            System.out.println("1. Add New Booking");
            System.out.println("2. Display All Bookings");
            System.out.println("3. Create New Contracts");
            System.out.println("4. Display List of Contracts");
            System.out.println("5. Edit Contracts");
            System.out.println("6. Return to Main Menu");
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

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
}
