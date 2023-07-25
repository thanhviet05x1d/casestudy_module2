package repository;

import model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> getAllEmployees();

    void addEmployee(Employee employee);

    void editEmployee(String id, String idNew);

    void deleteEmployee(String idCardNumber);

    List<Employee> searchEmployeesByName(String searchName);
}
