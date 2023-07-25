package repository;

import model.Contract;

import java.util.List;
import java.util.Set;

public interface IContractRepository {
    void addContract(Contract contract);

    Set<Contract> displayContracts();

    void editContract(String contractId, Contract newContract);

    List<Contract> getContractsByYear(String yearString);
}
