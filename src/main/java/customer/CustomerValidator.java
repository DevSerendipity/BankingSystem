package customer;

public class CustomerValidator {
    private final CustomerHandler customerHandler = new CustomerHandler();

    public boolean hasCustomer(Customer customer) {
        return customerHandler.getCustomers().stream().anyMatch(c -> c.getName().equals(customer.getName()));
    }

    public void checkForCustomer(String userName) {
        if ( !hasCustomer(customerHandler.getCustomer(userName)) ) {
            System.out.println("We don't have a customer with that name");
        }
    }
}
