package model.person;


import utils.PersonInvalidInputException;

import java.util.Date;

public class Employee extends Person {
    private String employeeID;
    private Date dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String email;
    private String degree;
    private String position;
    private double salary;


    public Employee(String idCardNumber, String name, String employeeID, Date dateOfBirth, String gender, String phoneNumber, String email, String degree, String position, double salary) {
        super(idCardNumber, name);
        this.employeeID = employeeID;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.degree = degree;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + super.toString() +
                "employeeID='" + employeeID + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + email + '\'' +
                ", degree='" + degree + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                "} ";
    }

    public void validateInput() throws PersonInvalidInputException {
        super.validateInput(); // Gọi phương thức validateInput() của lớp Person trước

        // Validate employeeID format using regular expression
        if (!employeeID.matches("NV-\\d{4}")) {
            throw new PersonInvalidInputException("Invalid employee ID format. It should be in NV-YYYY format.");
        }

        // Validate age to be at least 18 years old
        Date currentDate = new Date();
        if (currentDate.getYear() - dateOfBirth.getYear() < 18) {
            throw new PersonInvalidInputException("Employee must be at least 18 years old.");
        }

        // Validate phoneNumber to start with 0 and have 10 digits
        if (!phoneNumber.matches("0\\d{9}")) {
            throw new PersonInvalidInputException("Invalid phone number. It should start with 0 and have 10 digits.");
        }

        // Validate salary to be greater than 0
        if (salary <= 0) {
            throw new PersonInvalidInputException("Invalid salary. Salary should be greater than 0.");
        }
    }
}
