package repository;

import model.Promotion;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PromotionRepository implements IPromotionRepository {
    private static final Set<Promotion> promotionSet = new TreeSet<>();

    static {
        // Khởi tạo dữ liệu ban đầu nếu cần
        Promotion promotion1 = new Promotion("KH001", "Viet Nguyen", "Discount 10%");
        Promotion promotion2 = new Promotion("KH002", "Nam Le", "Discount 20%");
        Promotion promotion3 = new Promotion("KH003", "Tuan Tran", "Discount 50%");
        promotionSet.add(promotion1);
        promotionSet.add(promotion2);
        promotionSet.add(promotion3);
    }

    @Override
    public void addPromotion(Promotion promotion) {
        promotionSet.add(promotion);
    }

    @Override
    public Set<Promotion> getAllPromotions() {
        return promotionSet;
    }
}
