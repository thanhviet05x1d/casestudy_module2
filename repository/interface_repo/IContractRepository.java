package repository.interface_repo;

import model.booking.Contract;

import java.util.List;
import java.util.Set;

public interface IContractRepository {
    void addContract(Contract contract);

    Set<Contract> displayContracts();

    void editContract(String contractId, Contract newContract);

    List<Contract> getContractsByYear(String yearString);
}
