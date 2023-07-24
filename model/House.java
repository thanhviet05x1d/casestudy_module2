package model;

import utils.FacilityInvalidInputException;

public class House extends Facility {
    String roomStandard;
    private int numberOfFloors;

    public House(String facilityCode, String facilityName, double area, double rentalCost, int maxCapacity, String rentalType, String roomStandard, int numberOfFloors) {
        super(facilityCode, facilityName, area, rentalCost, maxCapacity, rentalType);
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                super.toString() +
                ", numberOfFloors=" + numberOfFloors +
                ", roomStandard=" + roomStandard;
    }

    @Override
    public void validateInput() throws FacilityInvalidInputException {
        super.validateInput(); // Gọi phương thức validateInput() của lớp Facility trước

        if (numberOfFloors <= 0) {
            throw new FacilityInvalidInputException("Number of floors must be greater than 0");
        }
    }
}
