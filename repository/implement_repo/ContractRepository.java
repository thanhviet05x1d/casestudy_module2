package repository.implement_repo;

import model.booking.Contract;
import repository.interface_repo.IContractRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class ContractRepository implements IContractRepository {
    BookingRepository bookingRepository = new BookingRepository();
    private static final Set<Contract> contractSet = new HashSet<>();


    static {
        LocalDate startDate1 = LocalDate.parse("2023-07-26");
        LocalDate endDate1 = LocalDate.parse("2023-07-28");
        LocalDate startDate2 = LocalDate.parse("2023-07-22");
        LocalDate endDate2 = LocalDate.parse("2023-07-29");
        contractSet.add(new Contract("CC001", "BK001", "KH-0001", "SVVL-0001", startDate1, endDate1));
        contractSet.add(new Contract("CC002", "BK002", "KH-0002", "SVVL-0002", startDate2, endDate2));
    }

    @Override
    public void addContract(Contract contract) {
        contractSet.add(contract); // Add new contract
        bookingRepository.deleteBooking(contract.getBookingId()); // Delete booking
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

    @Override
    public List<Contract> getContractsByYear(String yearString) {
        List<Contract> contractListByYear = new Stack<>();
        int yearSearch = Integer.parseInt(yearString);
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

        for (Contract contract : contractSet) {
            // Lấy năm từ startDate và endDate
            int startYear = contract.getStartDate().getYear();
            int endYear = contract.getEndDate().getYear();

            // Nếu năm của startDate hoặc endDate bằng với năm nhập vào, thêm Contract vào danh sách kết quả
            if (startYear == yearSearch || endYear == yearSearch) {
                contractListByYear.add(contract);
            }
        }
        return contractListByYear;
    }
}
