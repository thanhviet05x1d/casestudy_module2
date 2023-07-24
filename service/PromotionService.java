package service;

import model.Promotion;
import repository.IPromotionRepository;
import repository.PromotionRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PromotionService implements IPromotionService {
    IPromotionRepository promotionRepository = new PromotionRepository();

    @Override
    public void getAllPromotions() {
        Set<Promotion> promotionSet = promotionRepository.getAllPromotions();
        for (Promotion promotion: promotionSet) {
            System.out.println(promotion);
        }
    }

    @Override
    public void displayCustomerByYear(int year) {

    }

    @Override
    public void giveVoucherPromotion(int voucher10Percent, int voucher20Percent, int voucher50Percent) {

    }
}
