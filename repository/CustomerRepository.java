package repository;

import data.ReadWirteCustomerData;
import data.ReadWirteEmployeeData;
import model.Customer;
import model.Employee;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {

    List<Customer> customerList = new ArrayList<>();
    private static final String CSV_FILE_PATH = "D:\\R_CODE_GYM_MY_STUDY\\c0523g1_nguyen_thanh_viet_module2\\FuramaResort\\src\\data\\employee.csv";
    private static final String CSV_SEPARATOR = ",";
    private static final String HEADER = "idCardNumber,name,customerID,dateOfBirth,gender,phoneNumber,email,type,address";

    @Override
    public List<Customer> getAllCustomers() {
        customerList = ReadWirteCustomerData.readDataCustomerFromFile();
        return customerList;
    }


    @Override
    public void addCustomer(Customer customer) {
        customerList = ReadWirteCustomerData.readDataCustomerFromFile();
        customerList.add(customer);
        ReadWirteCustomerData.writeDataCustomerToFile(customerList, false);
    }

    @Override
    public void editCustomer(String id, String idNew) {
        customerList = ReadWirteCustomerData.readDataCustomerFromFile();
        for (Customer c : customerList) {
            if (c.getIdCardNumber().equals(id)) {
                c.setIdCardNumber(idNew);
                ReadWirteCustomerData.writeDataCustomerToFile(customerList, false);
            }
        }
    }

    @Override
    public void deleteCustomer(String idCardNumber) {
        customerList = ReadWirteCustomerData.readDataCustomerFromFile();
        for (Customer c : customerList) {
            if (c.getIdCardNumber().equals(idCardNumber)) {
                customerList.remove(c);
                ReadWirteCustomerData.writeDataCustomerToFile(customerList, false);
                break;
            }
        }
    }

    @Override
    public List<Customer> searchCustomersByName(String searchName) {
        customerList = ReadWirteCustomerData.readDataCustomerFromFile();
        List<Customer> searchCustomerList = new ArrayList<>();
        for (Customer c : customerList) {
            if (c.getName().contains(searchName)) {
                searchCustomerList.add(c);
            }
        }
        return searchCustomerList;
    }

}
