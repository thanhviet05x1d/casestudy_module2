package model.facility;
import utils.*;
public abstract class Facility {
    private String facilityID;
    private String facilityName;
    private double area;
    private double rentalCost;
    private int maxCapacity;
    private String rentalType;


    public Facility(String facilityCode, String facilityName, double area, double rentalCost, int maxCapacity, String rentalType) {
        this.facilityID = facilityCode;
        this.facilityName = facilityName;
        this.area = area;
        this.rentalCost = rentalCost;
        this.maxCapacity = maxCapacity;
        this.rentalType = rentalType;
    }

    public String getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(String facilityID) {
        this.facilityID = facilityID;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }


    @Override
    public String toString() {
        return "Facility{" +
                "facilityCode='" + facilityID + '\'' +
                ", facilityName='" + facilityName + '\'' +
                ", area=" + area +
                ", rentalCost=" + rentalCost +
                ", maxCapacity=" + maxCapacity +
                ", rentalType='" + rentalType + '\'';
    }

    // Phương thức kiểm tra dữ liệu đầu vào cho Facility
    public void validateInput() throws FacilityInvalidInputException {
        // Kiểm tra mã dịch vụ phải đúng định dạng: SVXX-YYYY
        if (!facilityID.matches("SV(RO|VL|HO)-\\d{4}")) {
            throw new FacilityInvalidInputException("Invalid facility ID. Facility ID must be in the format SVXX-YYYY.");

        }

        // Kiểm tra tên dịch vụ phải viết hoa ký tự đầu
        if (!facilityName.matches("^[A-Z][a-zA-Z0-9 ]*")) {
            throw new FacilityInvalidInputException("Invalid facility name. Facility name must start with an uppercase letter and contain only letters, numbers, and spaces.");
        }

        // Kiểm tra diện tích sử dụng phải lớn hơn 30m2
        if (area <= 30) {
            throw new FacilityInvalidInputException("Area must be greater than 30m2.");
        }

        // Kiểm tra chi phí thuê phải là số dương
        if (rentalCost <= 0) {
            throw new FacilityInvalidInputException("Rental cost must be a positive number.");
        }

        // Kiểm tra số lượng người tối đa phải > 0 và nhỏ hơn < 20
        if (maxCapacity <= 0 || maxCapacity >= 20) {
            throw new FacilityInvalidInputException("Max capacity must be greater than 0 and less than 20.");
        }

        // Kiểm tra kiểu thuê và tiêu chuẩn phòng phải chuẩn hóa giống tên dịch vụ
//        if (!rentalType.equalsIgnoreCase("VL") && !rentalType.equalsIgnoreCase("HO") && !rentalType.equalsIgnoreCase("RO")) {
//            throw new FacilityInvalidInputException("Invalid rental type. Rental type must be VL, HO, or RO.");
//        }

    }
}

