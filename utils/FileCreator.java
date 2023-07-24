package utils;

import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {
    public static void main(String[] args) {
        createEmployeeCSV();
    }

    public static void createEmployeeCSV() {
        // Dữ liệu mẫu để ghi vào file CSV
        String[] headers = {"ID", "Name", "EmployeeCode", "IDCardNumber", "PhoneNumber", "Salary", "DateOfBirth"};
        String[] employee1 = {"1", "John Doe", "NV-2021", "123456789", "0123456789", "5000", "1990-01-01"};
        String[] employee2 = {"2", "Jane Smith", "NV-2022", "987654321", "0987654321", "6000", "1995-05-10"};

        // Đường dẫn tới thư mục data và tên file employee.csv
        String dataDirectory = "D:\\R_CODE_GYM_MY_STUDY\\c0523g1_nguyen_thanh_viet_module2\\FuramaResort\\src\\data\\";
        String fileName = "employee.csv";

        // Tạo đối tượng FileWriter để ghi dữ liệu vào file CSV
        try (FileWriter fileWriter = new FileWriter(dataDirectory + fileName)) {
            // Ghi header vào file
            for (int i = 0; i < headers.length; i++) {
                fileWriter.append(headers[i]);
                if (i < headers.length - 1) {
                    fileWriter.append(",");
                } else {
                    fileWriter.append("\n");
                }
            }

            // Ghi dữ liệu của employee1 vào file
            for (int i = 0; i < employee1.length; i++) {
                fileWriter.append(employee1[i]);
                if (i < employee1.length - 1) {
                    fileWriter.append(",");
                } else {
                    fileWriter.append("\n");
                }
            }

            // Ghi dữ liệu của employee2 vào file
            for (int i = 0; i < employee2.length; i++) {
                fileWriter.append(employee2[i]);
                if (i < employee2.length - 1) {
                    fileWriter.append(",");
                } else {
                    fileWriter.append("\n");
                }
            }

            System.out.println("File employee.csv created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error occurred while creating the file.");
        }
    }
}
