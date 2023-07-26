package repository.implement_repo;

import data.ReadWirteEmployeeData;
import model.person.Employee;
import repository.interface_repo.IEmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    List<Employee> employeeList = new ArrayList<>();
    private static final String CSV_FILE_PATH = "D:\\R_CODE_GYM_MY_STUDY\\c0523g1_nguyen_thanh_viet_module2\\FuramaResort\\src\\data\\employee.csv";
    private static final String CSV_SEPARATOR = ",";
    private static final String HEADER = "idCardNumber,name,employeeID,dateOfBirth,gender,phoneNumber,email,degree,position,salary";

    @Override
    public List<Employee> getAllEmployees() {
        employeeList = ReadWirteEmployeeData.readDataEmployeeFromFile();
        return employeeList;
    }

     @Override
    public void addEmployee(Employee employee) {
        employeeList = ReadWirteEmployeeData.readDataEmployeeFromFile();
        employeeList.add(employee);
        ReadWirteEmployeeData.writeDataEmployeeToFile(employeeList, false);
    }

    @Override
    public void editEmployee(String id, String idNew) {
        employeeList = ReadWirteEmployeeData.readDataEmployeeFromFile();
        for (Employee e : employeeList) {
            if (e.getIdCardNumber().equals(id)) {
                e.setIdCardNumber(idNew);
                ReadWirteEmployeeData.writeDataEmployeeToFile(employeeList, false);
            }
        }
    }

    @Override
    public void deleteEmployee(String idCardNumber) {
        employeeList = ReadWirteEmployeeData.readDataEmployeeFromFile();
        for (Employee e : employeeList) {
            if (e.getIdCardNumber().equals(idCardNumber)) {
                employeeList.remove(e);
                ReadWirteEmployeeData.writeDataEmployeeToFile(employeeList, false);
                break;
            }
        }
    }

    @Override
    public List<Employee> searchEmployeesByName(String searchName) {
        employeeList = ReadWirteEmployeeData.readDataEmployeeFromFile();
        List<Employee> searchEmployeeList = new ArrayList<>();
        for (Employee e : employeeList) {
            if (e.getName().contains(searchName)) {
                searchEmployeeList.add(e);
            }
        }
        return searchEmployeeList;
    }
}
