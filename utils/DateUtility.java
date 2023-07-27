package utils;

import model.person.Customer;
import model.person.Employee;

import java.time.LocalDate;

public class DateUtility {
    public Employee parseEmployeeData(String[] data) {
        String idCardNumber = data[0];
        String name = data[1];
        String employeeID = data[2];
        LocalDate dateOfBirth = LocalDate.parse(data[3]);
        String gender = data[4];
        String phoneNumber = data[5];
        String email = data[6];
        String degree = data[7];
        String position = data[8];
        double salary = Double.parseDouble(data[9]);
        return new Employee(idCardNumber, name, employeeID, dateOfBirth, gender, phoneNumber, email, degree, position, salary);
    }

    public Customer parseCustomerData(String[] data) {
        String idCardNumber = data[0];
        String name = data[1];
        String customerID = data[2];
        LocalDate dateOfBirth = LocalDate.parse(data[3]);
        String gender = data[4];
        String phoneNumber = data[5];
        String email = data[6];
        String type = data[7];
        String address = data[8];

        return new Customer(idCardNumber, name, customerID, dateOfBirth, gender, phoneNumber, email, type, address);
    }



}

