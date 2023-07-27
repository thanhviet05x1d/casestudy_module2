package controller;

import service.implement_ser.ContractService;
import service.implement_ser.CustomerService;
import service.implement_ser.PromotionService;
import service.interface_ser.IContractService;
import service.interface_ser.ICustomerService;
import service.interface_ser.IPromotionService;

import java.util.Scanner;

public class PromotionController {
    private static Scanner scanner = new Scanner(System.in);
    private static IPromotionService promotionService = new PromotionService();
    private static ICustomerService customerService = new CustomerService();
    private static IContractService contractService = new ContractService();

    public static void displayPromotionManagementMenu(){
        boolean exitMenu = false; // Thử 1 cách viết khác
        while (!exitMenu) {
            System.out.println("\nPROMOTION MANAGEMENT MENU");
            System.out.println("1. Add New Promotion");
            System.out.println("2. Display all promotions");
            System.out.println("3. Display all Contracts by Year");
            System.out.println("4. Display all Customers using services by year");
            System.out.println("5. Display List of Booking in current Month");
            System.out.println("6. Display List of Booking get Voucher in current Month");
            System.out.println("7. Return to Main Menu");
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    promotionService.addPromotion();
                    break;
                case 2:
                    promotionService.getAllPromotions();
                    break;
                case 3:
                    contractService.getContractsByYear();
                    break;
                case 4:
                    promotionService.displayCustomerByYear();
                    break;
                case 5:
                    customerService.getBookingsCurrentMonth();

                    break;
                case 6:
                    customerService.bookingsGetVoucher();
                    break;
                case 7:
                    exitMenu = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
