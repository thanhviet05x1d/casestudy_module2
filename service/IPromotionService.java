package service;

import model.Promotion;

import java.util.Set;

public interface IPromotionService {
    void getAllPromotions();
    void displayCustomerByYear(int year);
    void giveVoucherPromotion(int voucher10Percent, int voucher20Percent, int voucher50Percent);
}
