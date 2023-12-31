package service.implement_ser;

import model.booking.Booking;
import model.booking.Contract;
import repository.implement_repo.BookingRepository;
import repository.implement_repo.ContractRepository;
import repository.interface_repo.IBookingRepository;
import repository.interface_repo.IContractRepository;
import service.interface_ser.IContractService;
import utils.BookingStartDateComparator;

import java.time.LocalDate;
import java.util.*;

public class ContractService implements IContractService {
    IContractRepository contractRepository = new ContractRepository();
    IBookingRepository bookingRepository = new BookingRepository();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void createNewContract() {

        System.out.println("--- Create New Contract ---");
        // Chuyển danh sách booking từ Set sang PriorityQueue
        Queue<Booking> bookingQueue = new PriorityQueue<>(new BookingStartDateComparator());
        bookingQueue.addAll(bookingRepository.displayAllBookings());

        // Lấy booking đầu tiên từ hàng đợi
        Booking booking = bookingQueue.poll();

        System.out.println("Booking Information:");
        System.out.println(booking);

        System.out.print("Enter contract ID: ");
        String contractId = scanner.nextLine();

        String customerId = booking.getCustomerId();
        System.out.print("customer ID: " + customerId + "\n");

        String facilityId = booking.getFacilityId();
        System.out.print("facilityId ID: " + facilityId + "\n");

        System.out.print("Enter start date (yyyy-MM-dd): ");
        String startDateString = scanner.nextLine();
        LocalDate startDate = LocalDate.parse(startDateString);


        System.out.print("Enter end date (yyyy-MM-dd): ");
        String endDateString = scanner.nextLine();
        LocalDate endDate = LocalDate.parse(endDateString);

        Contract contract = new Contract(contractId, booking.getBookingId(), customerId, facilityId, startDate, endDate);
        contractRepository.addContract(contract);
        System.out.println("Contract created successfully.");

        // Xóa booking đã ký hợp đồng
        bookingRepository.deleteBooking(booking.getBookingId());

    }

    @Override
    public void displayContracts() {
        Set<Contract> contractSet = contractRepository.displayContracts();
        for (Contract contract : contractSet) {
            System.out.println(contract);
        }

    }

    @Override
    public void editContract() {
        System.out.println("Enter Contract ID to edit: ");
        String contractId = scanner.nextLine();
        // Hiển thị danh sách contract
        Set<Contract> contractSet = contractRepository.displayContracts();
        for (Contract c : contractSet) {
            if (c.getContractId().equals(contractId)) {
                System.out.println(c);

                System.out.println("Enter new Booking ID: ");
                String newBookingId = scanner.nextLine();

                System.out.println("Enter new Customer ID: ");
                String newCustomerId = scanner.nextLine();

                System.out.println("Enter new Facility ID: ");
                String newFacilityId = scanner.nextLine();

                System.out.print("Enter new start date (yyyy-MM-dd): ");
                String newStartDateString = scanner.nextLine();
                LocalDate newStartDate = LocalDate.parse(newStartDateString);

                System.out.print("Enter new end date (yyyy-MM-dd): ");
                String newEndDateString = scanner.nextLine();
                LocalDate newEndDate = LocalDate.parse(newEndDateString);

                Contract newContract = new Contract(contractId, newBookingId, newCustomerId, newFacilityId, newStartDate, newEndDate);
                contractRepository.editContract(contractId, newContract);
                System.out.println("Contract updated successfully.");
                break;
            }
        }
    }

    @Override
    public void getContractsByYear() {
        System.out.println("Enter year to get Contracts:");
        String yearString = scanner.nextLine();
        List<Contract> contractsByYear = contractRepository.getContractsByYear(yearString);
        for (Contract c : contractsByYear) {
            System.out.println(c);
        }
    }
}
