package model;

import utils.PersonInvalidInputException;

public abstract class Person {
    private String idCardNumber;
    private String name;

    public Person(String idCardNumber, String name) {
        this.idCardNumber = idCardNumber;
        this.name = name;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + idCardNumber + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void validateInput() throws PersonInvalidInputException {
        // Validate idCardNumber to have 9 or 12 digits
        if (!idCardNumber.matches("\\d{9}|\\d{12}")) {
            throw new PersonInvalidInputException("Invalid ID card number. It should have 9 or 12 digits.");
        }
        // Validate name format to have first letter of each word capitalized
        if (!name.matches("(\\p{Lu}\\p{Ll}+\\s?)+")) {
            throw new PersonInvalidInputException("Invalid name format. Each word should start with a capital letter.");
        }

    }

}