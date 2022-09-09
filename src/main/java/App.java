import customer.Customer;
import customer.CustomerHandler;
import customer.CustomerPrinter;

public class App {
    private static final BankingSystem bankingSystem = new BankingSystem();
    private static final CustomerHandler customerHandler = new CustomerHandler();
    private static final BalanceHandler balanceHandler = new BalanceHandler();
    private static final CustomerPrinter customerPrinter = new CustomerPrinter();

    public static void main(String[] args) {
        customerHandler.addCustomer(new Customer("Ok", 300));
        customerHandler.addCustomer(new Customer("Man", 100));
        customerHandler.addCustomer(new Customer("Tom", 200));
        bankingSystem.getBankDetails();
        balanceHandler.atmActions(getCustomer());
        customerPrinter.customerDetails(getCustomer());
    }

    private static Customer getCustomer() {
        return customerHandler.getCustomers().stream().filter(
                customer -> customer.getName().equals(bankingSystem.getUserName())).findAny().get();
    }

}
