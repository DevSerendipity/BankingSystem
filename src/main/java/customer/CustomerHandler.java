package customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerHandler {
    private static final ArrayList<Customer> CUSTOMERS = new ArrayList<>();
    private static String userName;

    public List<Customer> getCustomers() {
        return Collections.unmodifiableList(CUSTOMERS);
    }

    public Customer getCustomer() {
        return getCustomers().stream().filter(customer -> customer.getName().equals(getUserName())).findAny()
                             .orElseThrow(IllegalArgumentException::new);
    }

    public void addCustomer(Customer customer) {
        CUSTOMERS.add(customer);
    }

    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        CustomerHandler.userName = userName;
    }
}
