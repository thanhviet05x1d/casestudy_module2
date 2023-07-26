package service.implement_ser;

import model.person.Employee;
import repository.implement_repo.EmployeeRepository;
import repository.interface_repo.IEmployeeRepository;
import service.interface_ser.IEmployeeService;
import utils.PersonInvalidInputException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepository employeeRepository = new EmployeeRepository();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void getAllEmployees() {
        List<Employee> employeeList;
        employeeList = employeeRepository.getAllEmployees();
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Override
    public void addEmployee() {
        System.out.println("------ Add New Employee ------");
        System.out.print("Enter ID card number: ");
        String idCardNumber = scanner.nextLine();

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee code (NV-YYYY): ");
        String employeeID = scanner.nextLine();


        System.out.print("Enter employee date of birth (yyyy-MM-dd): ");
        String dobString = scanner.nextLine();
        Date dateOfBirth = null;
        try {
            dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(dobString);
        } catch (ParseException e) {
            System.out.println("Error: Invalid date format. Please enter the date in yyyy-MM-dd format.");
        }

        System.out.print("Enter gender of employee(male/female): ");
        String gender = scanner.nextLine();


        System.out.print("Enter employee phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter email of employee: ");
        String email = scanner.nextLine();

        System.out.print("Enter degree of employee: ");
        String degree = scanner.nextLine();

        System.out.print("Enter position in company: ");
        String position = scanner.nextLine();

        System.out.print("Enter employee salary: ");
        double salary = Double.parseDouble(scanner.nextLine());

        try {
            Employee employee = new Employee(idCardNumber, name, employeeID, dateOfBirth, gender, phoneNumber, email, degree, position, salary);
            employee.validateInput(); // Kiểm tra dữ liệu đầu vào

            employeeRepository.addEmployee(employee);
            System.out.println("Employee added successfully.");

        } catch (PersonInvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void editEmployee() {
        System.out.println("Enter ID employee to Edit:");
        String id = scanner.nextLine();
        System.out.println("Nhập ID mới:");
        String idNew = scanner.nextLine();
        employeeRepository.editEmployee(id, idNew);

    }

    @Override
    public void deleteEmployee() {
        System.out.println("Enter ID employee to delete:");
        String idCardNumber = scanner.nextLine();
        employeeRepository.deleteEmployee(idCardNumber);
    }

    @Override
    public void searchEmployeesByName() {
        System.out.println("Nhập tên của nhân viên cần tìm:");
        String searchName = scanner.nextLine();
        List<Employee> employeeSearchList = employeeRepository.searchEmployeesByName(searchName);
        for (Employee e : employeeSearchList) {
            System.out.println(e);
        }
    }
}
