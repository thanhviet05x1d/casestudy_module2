package data;

import model.Customer;
import utils.DateUtility;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ReadWirteCustomerData {
    static DateUtility dateUtility =new DateUtility();
    private static final String CSV_FILE_PATH = "D:\\R_CODE_GYM_MY_STUDY\\c0523g1_nguyen_thanh_viet_module2\\FuramaResort\\src\\data\\customer.csv";
    private static final String CSV_SEPARATOR = ",";

    public static void writeDataCustomerToFile(List<Customer> customerList, boolean append) {
        String path = CSV_FILE_PATH;
        try {
            File file = new File(path);
            FileOutputStream fileOutputStream = new FileOutputStream(file, append);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            // Write the header line if the file is empty
            if (!file.exists() || file.length() == 0) {
                bufferedWriter.write("ID,Name,EmployeeCode,IDCardNumber,PhoneNumber,DateOfBirth");
                bufferedWriter.newLine();
            }

            for (Customer customer : customerList) {
                String line = customer.getIdCardNumber()
                        + "," + customer.getName()
                        + "," + customer.getCustomerID()
                        + "," + dateUtility.formatDate(customer.getDateOfBirth())
                        + "," + customer.getGender()
                        + "," + customer.getPhoneNumber()
                        + "," + customer.getEmail()
                        + "," + customer.getType()
                        + "," + customer.getAddress();

                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> readDataCustomerFromFile() {
        String path = CSV_FILE_PATH;
        DateUtility dateUtility = new DateUtility();
        List<Customer> customerList  = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            // Skip the header line
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(CSV_SEPARATOR);
                Customer customer = dateUtility.parseCustomerData(data);
                customerList.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}

