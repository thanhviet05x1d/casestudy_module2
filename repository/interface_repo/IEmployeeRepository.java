package repository.interface_repo;

import model.person.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> getAllEmployees();

    void addEmployee(Employee employee);

    void editEmployee(String id, Employee employee);

    void deleteEmployee(String idCardNumber);

    List<Employee> searchEmployeesByName(String searchName);
}
