package repository;

import model.Facility;

import java.util.Map;

public interface IFacilityRepository {
    void addFacility(Facility facility);

    void deleteFacility(String facilityID);

    Map<Facility, Integer> getFacilities();

    Map<Facility, Integer> displayFacilitiesNeedMaintenance();

}
