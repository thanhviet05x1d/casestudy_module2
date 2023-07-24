package model;

import java.util.Comparator;

public class Promotion implements Comparable<Promotion> {
    private String customerId;
    private String customerName;
    private String promotionType;


    public Promotion(String customerId, String customerName, String promotionType) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.promotionType = promotionType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", promotionType='" + promotionType + '\'' +
                '}';
    }


    @Override
    public int compareTo(Promotion o) {
        return this.customerId.compareTo(o.customerId);
    }
}
