package service.implement_ser;

import model.person.Customer;
import model.promotion.Promotion;
import repository.implement_repo.PromotionRepository;
import repository.interface_repo.IPromotionRepository;
import service.interface_ser.IPromotionService;

import java.util.*;

public class PromotionService implements IPromotionService {
    IPromotionRepository promotionRepository = new PromotionRepository();

    Scanner scanner = new Scanner(System.in);

    @Override
    public void addPromotion() {
        System.out.println("Enter type of promotion:");
        String promotionType = scanner.nextLine();
        System.out.println("Enter value of Type: ");
        int value = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter number of Type: ");
        int number = Integer.parseInt(scanner.nextLine());
        Promotion promotion = new Promotion(promotionType, value, number);
        promotionRepository.addPromotion(promotion);
    }

    @Override
    public void getAllPromotions() {
        Set<Promotion> promotionSet = promotionRepository.getAllPromotions();
        for (Promotion promotion : promotionSet) {
            System.out.println(promotion);
        }
    }

    @Override
    public void displayCustomerByYear() {
        System.out.println("Enter a year to display customers: ");
        String yearString = scanner.nextLine();
        List<Customer> customerListByYear = promotionRepository.displayCustomerByYear(yearString);
        for (Customer customer : customerListByYear) {
            System.out.println(customer);
        }
    }

}
