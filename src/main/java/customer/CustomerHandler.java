package customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CustomerHandler {
    private final static ArrayList<Customer> customers = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);

    public String getUserInput() {
        return input.nextLine();
    }

    public List<Customer> getCustomers() {
        return Collections.unmodifiableList(customers);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
}
