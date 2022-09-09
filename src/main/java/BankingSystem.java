import customer.Customer;
import customer.CustomerHandler;

import java.util.Scanner;

public class BankingSystem {
    CustomerHandler customerHandler = new CustomerHandler();
    Scanner input = new Scanner(System.in);
    private String userName;

    void getBankDetails() {
        System.out.println("Enter customer name ");
        setUserName(input.nextLine());
        if ( !isCustomerPresent(customerHandler.getCustomers().stream().filter(
                customer -> customer.getName().equals(getUserName())).findAny().get()) ) {
            System.out.println("We don't have a customer with that name");
        }
    }

    private boolean isCustomerPresent(Customer value) {
        return customerHandler.getCustomers().stream().anyMatch(customer -> customer.getName().equals(value.getName()));
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
