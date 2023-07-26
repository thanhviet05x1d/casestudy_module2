package repository.interface_repo;

import model.person.Customer;
import model.promotion.Promotion;

import java.util.List;
import java.util.Set;

public interface IPromotionRepository {
    void addPromotion(Promotion promotion);

    Set<Promotion> getAllPromotions();

    List<Customer> displayCustomerByYear(String yearString);
}
