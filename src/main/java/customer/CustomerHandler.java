package customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerHandler {
    private final static ArrayList<Customer> customers = new ArrayList<>();
    private static String userName;

    public List<Customer> getCustomers() {
        return Collections.unmodifiableList(customers);
    }

    public Customer getCustomer(String userName) {
        return getCustomers().stream().filter(customer -> customer.getName().equals(userName)).findAny().get();
    }

    public void addCustomer(Customer customer) {
        getCustomers().add(customer);
    }

    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        CustomerHandler.userName = userName;
    }
}
