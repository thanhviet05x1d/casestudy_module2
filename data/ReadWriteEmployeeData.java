package data;

import model.person.Employee;
import utils.DateUtility;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteEmployeeData {
    private static final String CSV_FILE_PATH = "D:\\R_CODE_GYM_MY_STUDY\\c0523g1_nguyen_thanh_viet_module2\\FuramaResort\\src\\data\\employee.csv";
    private static final String CSV_SEPARATOR = ",";

    public static void writeDataEmployeeToFile(List<Employee> employeeList, boolean append) {
        String path = CSV_FILE_PATH;
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write the header line if the file is empty
            if (!file.exists() || file.length() == 0) {
                bufferedWriter.write("idCardNumber,name,employeeID,dateOfBirth,gender,phoneNumber,email,degree,position,salary");
                bufferedWriter.newLine();
            }

            for (Employee employee : employeeList) {
                String line = employee.getIdCardNumber()
                        + "," + employee.getName()
                        + "," + employee.getEmployeeID()
                        + "," + (employee.getDateOfBirth()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                        + "," + employee.getGender()
                        + "," + employee.getPhoneNumber()
                        + "," + employee.getEmail()
                        + "," + employee.getDegree()
                        + "," + employee.getPosition()
                        + "," + employee.getSalary();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> readDataEmployeeFromFile() {
        String path = CSV_FILE_PATH;
        DateUtility dateUtility = new DateUtility();
        List<Employee> employeeList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            // Skip the header line
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(CSV_SEPARATOR);
                Employee employee = dateUtility.parseEmployeeData(data);
                employeeList.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}

