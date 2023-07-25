package utils;

import model.Customer;
import model.Employee;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
    public Employee parseEmployeeData(String[] data) {
        String idCardNumber = data[0];
        String name = data[1];
        String employeeID = data[2];
        Date dateOfBirth = parseDate(data[3]);
        String gender = data[4];
        String phoneNumber = data[5];
        String email = data[6];
        String degree = data[7];
        String position = data[8];
        double salary = Double.parseDouble(data[9]);
        return new model.Employee(idCardNumber, name, employeeID, dateOfBirth, gender, phoneNumber, email, degree, position, salary);
    }

    public Customer parseCustomerData(String[] data) {
        String idCardNumber = data[0];
        String name = data[1];
        String customerID = data[2];
        Date dateOfBirth = parseDate(data[3]);
        String gender = data[4];
        String phoneNumber = data[5];
        String email = data[6];
        String type = data[7];
        String address = data[8];

        return new model.Customer(idCardNumber, name, customerID, dateOfBirth, gender, phoneNumber, email, type, address);
    }

    public Date parseDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateString);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public String[] convertEmployeeToData(Employee employee) {
        String[] data = new String[10];
        data[0] = employee.getIdCardNumber();
        data[1] = employee.getName();
        data[2] = employee.getEmployeeID();
        data[3] = formatDate(employee.getDateOfBirth());
        data[4] = employee.getGender();
        data[5] = employee.getPhoneNumber();
        data[6] = employee.getEmail();
        data[7] = employee.getDegree();
        data[8] = employee.getPosition();
        data[9] = String.valueOf(employee.getSalary());
        return data;
    }
}

