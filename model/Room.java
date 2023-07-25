package model;

public class Room extends Facility {
    private String roomFreeService;

    public Room(String facilityCode, String facilityName, double area, double rentalCost, int maxCapacity, String rentalType, String roomFreeService) {
        super(facilityCode, facilityName, area, rentalCost, maxCapacity, rentalType);
        this.roomFreeService = roomFreeService;
    }

    public String roomFreeService() {
        return roomFreeService;
    }

    public void roomFreeService(String roomType) {
        this.roomFreeService = roomFreeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                super.toString() +
                ", Free Service='" + roomFreeService;
    }
}