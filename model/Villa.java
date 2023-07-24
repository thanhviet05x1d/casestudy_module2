package model;

import utils.*;

public class Villa extends Facility {
    String roomStandard;
    private double poolArea;
    private int numberOfFloors;

    public Villa(String facilityCode, String facilityName, double area, double rentalCost, int maxCapacity, String rentalType, String roomStandard, double poolArea, int numberOfFloors) {
        super(facilityCode, facilityName, area, rentalCost, maxCapacity, rentalType);
        this.roomStandard =roomStandard;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }


    @Override
    public String toString() {
        return "Villa{" + super.toString() +
                ", roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", numberOfFloors=" + numberOfFloors ;
    }

    @Override
    public void validateInput() throws FacilityInvalidInputException {
        super.validateInput(); // Gọi phương thức validateInput() của lớp Facility trước

        // Kiểm tra điều kiện đặc biệt cho Villa
        if (poolArea <= 30) {
            throw new FacilityInvalidInputException("Pool area must be greater than 30m2");
        }

        if (numberOfFloors <= 0) {
            throw new FacilityInvalidInputException("Number of floors must be greater than 0");
        }
    }
}
