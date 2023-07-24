package service;

import model.Employee;

import java.util.List;

public interface IEmployeeService {
    void getAllEmployees();
    void addEmployee();
    void editEmployee();
    void deleteEmployee();
    void searchEmployeesByName();
}
