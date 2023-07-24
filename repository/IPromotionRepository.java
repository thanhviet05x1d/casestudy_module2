package repository;

import model.Promotion;

import java.util.Set;

public interface IPromotionRepository {
    void addPromotion(Promotion promotion);
    Set<Promotion> getAllPromotions();
}
