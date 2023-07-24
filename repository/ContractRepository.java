package repository;

import model.Booking;
import model.Contract;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ContractRepository implements IContractRepository {
    private static final Set<Contract> contractSet = new HashSet<>();

    static {
        Date startDate1 = null;
        Date endDate1 = null;
        Date startDate2 = null;
        Date endDate2 = null;

        try {
            startDate1 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-07-26");
            endDate1 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-07-28");
            startDate2 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-07-22");
            endDate2 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-07-29");

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        contractSet.add(new Contract("CC001", "BK001", "KH-0001", "SVVL-0001", startDate1, endDate1));
        contractSet.add(new Contract("CC002", "BK002", "KH-0002", "SVVL-0002", startDate2, endDate2));
    }

    @Override
    public void addContract(Contract contract) {
        contractSet.add(contract);
    }


    @Override
    public Set<Contract> displayContracts() {
        return contractSet;
    }

    @Override
    public void editContract(String contractId, Contract newContract) {
        for (Contract c : contractSet) {
            if (c.getContractId().equals(contractId)) {
                c.setContractId(newContract.getContractId());
                c.setBookingId(newContract.getBookingId());
                c.setCustomerId(newContract.getCustomerId());
                c.setFacilityId(newContract.getFacilityId());
                c.setStartDate(newContract.getStartDate());
                c.setEndDate(newContract.getEndDate());
                break;
            }
        }
    }


}
