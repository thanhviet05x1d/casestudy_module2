package repository;

import model.Customer;
import model.Promotion;

import java.util.List;
import java.util.Set;

public interface IPromotionRepository {
    void addPromotion(Promotion promotion);

    Set<Promotion> getAllPromotions();

    List<Customer> displayCustomerByYear(String yearString);
}
