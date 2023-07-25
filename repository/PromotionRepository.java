package repository;

import model.Contract;
import model.Customer;
import model.Promotion;

import java.util.*;

public class PromotionRepository implements IPromotionRepository {
    private static final Set<Promotion> promotionSet = new TreeSet<>();
    IContractRepository contractRepository = new ContractRepository();
    ICustomerRepository customerRepository = new CustomerRepository();


    static {
        // Khởi tạo dữ liệu ban đầu nếu cần
        Promotion promotion1 = new Promotion("Discount 10%", 10, 2);
        Promotion promotion2 = new Promotion("Discount 20%", 20, 2);
        Promotion promotion3 = new Promotion("Discount 50%", 50, 1);
        promotionSet.add(promotion1);
        promotionSet.add(promotion2);
        promotionSet.add(promotion3);
    }

    @Override
    public void addPromotion(Promotion promotion) {
        promotionSet.add(promotion);
    }

    @Override
    public Set<Promotion> getAllPromotions() {
        return promotionSet;
    }

    @Override
    public List<Customer> displayCustomerByYear(String yearString) {

        IContractRepository contractRepository = new ContractRepository();
        ICustomerRepository customerRepository = new CustomerRepository();

        // 1. Show ra các hợp đồng trong năm yearString

        List<Contract> contractListByYear = contractRepository.getContractsByYear(yearString);

        // 2. Show ra danh sách khách hàng từ các hợp đồng.
        List<Customer> customerList = customerRepository.getAllCustomers();

        // 3. Tạo một danh sách để chứa khách hàng sử dụng Furama trong năm.
        List<Customer> customerListByYear = new ArrayList<>();

        for (Contract contract : contractListByYear) {
            for (Customer customer : customerList) {
                if (customer.getCustomerID().equals(contract.getCustomerId())) {
                    customerListByYear.add(customer);
                }
            }
        }
        return customerListByYear;
    }
}
