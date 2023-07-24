package repository;

import model.Facility;
import model.House;
import model.Room;
import model.Villa;
import utils.FacilityInvalidInputException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FacilityRepository implements IFacilityRepository {
    private static final Map<Facility, Integer> facilityMap = new LinkedHashMap<>();

    static {
        // Thêm dữ liệu ban đầu vào facilityMap nếu cần
        Facility villa1 = new Villa("SVVL-0001", "Luxury Villa 1", 300, 5000000, 6, "DAY", "Deluxe", 80, 2);
        Facility villa2 = new Villa("SVVL-0002", "Beach Villa 2", 250, 4000000, 6, "DAY", "Superior", 60, 2);
        Facility house1 = new House("SVHO-0001", "City House 1", 90, 2000000, 4, "DAY", "Standard", 2);
        Facility house2 = new House("SVHO-0002", "Country House 2", 80, 2000000, 4, "DAY", "Deluxe", 2);
        Facility room1 = new Room("SVRO-0001", "Double Room 1", 80, 2000000, 3, "DAY", "Massage");
        Facility room2 = new Room("SVRO-0002", "Single Room 2", 40, 500000, 1, "DAY", "Massage");

        facilityMap.put(villa1, 1);
        facilityMap.put(villa2, 3);
        facilityMap.put(house1, 10);
        facilityMap.put(house2, 6);
        facilityMap.put(room1, 2);
        facilityMap.put(room2, 6);
    }

    @Override
    public void addFacility(Facility facility) {
        try {
            facility.validateInput();
            facilityMap.put(facility, 0); // Value mặc định là 0
        } catch (FacilityInvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }


    @Override
    public Map<Facility, Integer> getFacilities() {
        return facilityMap;
    }

    @Override
    public Map<Facility, Integer> displayFacilitiesNeedMaintenance() {
        Map<Facility, Integer> facilityMaintenaceMap = new LinkedHashMap<>();
        for (Facility key : facilityMap.keySet()) {
            int numBookings = facilityMap.get(key);
            if (numBookings >= 5) {
                facilityMaintenaceMap.put(key, numBookings);
            }
        }
        return facilityMaintenaceMap;
    }

    @Override
    public void deleteFacility(String facilityID) {
        for (Facility key : facilityMap.keySet()) {
            if (key.getFacilityID().equals(facilityID)) {
                facilityMap.remove(key);
                break;
            }
        }
    }
}
