package model.promotion;

public class Promotion implements Comparable<Promotion> {
    private String promotionType;
    private int value;
    private int number;


    public Promotion(String promotionType, int value,int numberOfVoucher) {
        this.promotionType = promotionType;
        this.value=value;
        this.number = numberOfVoucher;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
                "promotionType='" + promotionType + '\'' +
                ", value=" + value +
                ", number=" + number +
                '}';
    }

    @Override
    public int compareTo(Promotion o) {
        return this.value - o.value;
    }
}
