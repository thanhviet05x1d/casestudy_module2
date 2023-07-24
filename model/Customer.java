package model;


import utils.PersonInvalidInputException;


import java.util.Date;

public class Customer extends Person {
    private String customerID;
    private Date dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String email;
    private String type;
    private String address;


    public Customer(String idCardNumber, String name, String customerID, Date dateOfBirth, String gender, String phoneNumber, String email, String type, String address) {
        super(idCardNumber, name);
        this.customerID = customerID;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.type = type;
        this.address = address;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Customer{" + super.toString() +
                "customerID='" + customerID + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                "} ";
    }

    public void validateInput() throws PersonInvalidInputException {
        super.validateInput(); // Gọi phương thức validateInput() của lớp Person trước

        // Validate customerCode format using regular expression
        if (!customerID.matches("KH-\\d{4}")) {
            throw new PersonInvalidInputException("Invalid customer code format. It should be in KH-YYYY format.");
        }

        // Validate name format to have first letter of each word capitalized
        if (!getName().matches("(\\p{Lu}\\p{Ll}+\\s?)+")) {
            throw new PersonInvalidInputException("Invalid name format. Each word should start with a capital letter.");
        }

        // Validate age to be at least 18 years old
        Date currentDate = new Date();
        if (currentDate.getYear() - dateOfBirth.getYear() < 18) {
            throw new PersonInvalidInputException("Customer must be at least 18 years old.");
        }

        // Validate phoneNumber to start with 0 and have 10 digits
        if (!phoneNumber.matches("0\\d{9}")) {
            throw new PersonInvalidInputException("Invalid phone number. It should start with 0 and have 10 digits.");
        }
    }
}
