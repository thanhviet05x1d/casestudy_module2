package service.implement_ser;

import model.facility.Facility;
import model.facility.House;
import model.facility.Room;
import model.facility.Villa;
import repository.implement_repo.FacilityRepository;
import service.interface_ser.IFacilityService;
import utils.FacilityInvalidInputException;

import java.util.Map;
import java.util.Scanner;

public class FacilityService implements IFacilityService {
    Scanner scanner = new Scanner(System.in);
    FacilityRepository facilityRepository = new FacilityRepository();

    @Override
    public void displayFacilities() {
        Map<Facility, Integer> facilityMap = facilityRepository.getFacilities();
        for (Facility key : facilityMap.keySet()) {
            System.out.println(key + " - Number of bookings: " + facilityMap.get(key));
        }
    }

    @Override
    public void addNewVilla() {
        System.out.println("Enter Villa Code(SVVL-yyyy): ");
        String facilityCode = scanner.nextLine();
        System.out.println("Enter Villa Name: ");
        String facilityName = scanner.nextLine();
        System.out.println("Enter Area of Villa: ");
        double area = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter rental cost: ");
        double rentalCost = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter max of capacity: ");
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter type of rental(HOUR/DAY/MONTH/YEAR): ");
        String rentalType = scanner.nextLine();
        System.out.println("Enter Room Standard: ");
        String roomStandard = scanner.nextLine();
        System.out.println("Pool area: ");
        double poolArea = Double.parseDouble(scanner.nextLine());
        System.out.println("Number of floor: ");
        int numberOfFloors = Integer.parseInt(scanner.nextLine());

        Facility vilaNew = new Villa(facilityCode, facilityName, area, rentalCost, maxCapacity, rentalType, roomStandard, poolArea, numberOfFloors);

        try {
            vilaNew.validateInput(); // Kiểm tra dữ liệu hợp lệ
            facilityRepository.addFacility(vilaNew);
            System.out.println("Successful!");
        } catch (FacilityInvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    @Override
    public void addNewHouse() {
        System.out.println("Enter House Code(SVHO-yyyy): ");
        String facilityCode = scanner.nextLine();
        System.out.println("Enter House Name: ");
        String facilityName = scanner.nextLine();
        System.out.println("Enter Area of House: ");
        double area = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter rental cost: ");
        double rentalCost = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter max of capacity: ");
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter type of rental(HOUR/DAY/MONTH/YEAR): ");
        String rentalType = scanner.nextLine();
        System.out.println("Enter Room Standard: ");
        String roomStandard = scanner.nextLine();
        System.out.println("Number of floor: ");
        int numberOfFloors = scanner.nextInt();

        Facility houseNew = new House(facilityCode, facilityName, area, rentalCost, maxCapacity, rentalType, roomStandard, numberOfFloors);

        try {
            houseNew.validateInput(); // Kiểm tra dữ liệu hợp lệ
            facilityRepository.addFacility(houseNew);
            System.out.println("Successful!");
        } catch (FacilityInvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    @Override
    public void addNewRoom() {
        System.out.println("Enter Room Code(SVRO-yyyy): ");
        String facilityID = scanner.nextLine();
        System.out.println("Enter Room Name: ");
        String facilityName = scanner.nextLine();
        System.out.println("Enter Area of Room: ");
        double area = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter rental cost: ");
        double rentalCost = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter max of capacity: ");
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter type of rental (HOUR/DAY/MONTH/YEAR): ");
        String rentalType = scanner.nextLine();
        System.out.println("Enter room free included service: ");
        String roomFreeService = scanner.nextLine();

        Facility roomNew = new Room(facilityID, facilityName, area, rentalCost, maxCapacity, rentalType, roomFreeService);

        try {
            roomNew.validateInput(); // Kiểm tra dữ liệu hợp lệ
            facilityRepository.addFacility(roomNew);
            System.out.println("Successful!");
        } catch (FacilityInvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void displayFacilitiesNeedMaintenance() {
        Map<Facility, Integer> facilityMaintenaceMap = facilityRepository.displayFacilitiesNeedMaintenance();
        for (Facility key : facilityMaintenaceMap.keySet()) {
            System.out.println(key + " - Number of bookings: " + facilityMaintenaceMap.get(key));
        }
    }

    @Override
    public void deleteFacility() {
        System.out.println("Enter FacilityID to delete: ");
        String facilityID = scanner.nextLine();
        facilityRepository.deleteFacility(facilityID);
    }
}


