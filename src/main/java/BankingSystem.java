import customer.Customer;
import customer.CustomerHandler;
import customer.CustomerPrinter;
import customer.CustomerValidator;

public class BankingSystem {
    private static final CustomerValidator customerValidator = new CustomerValidator();
    private static final CustomerHandler customerHandler = new CustomerHandler();
    private static final InputHandler inputHandler = new InputHandler();
    private static final CustomerPrinter customerPrinter = new CustomerPrinter();
    private static final ATMHandler atmHandler = new ATMHandler();

    public static void main(String[] args) {
        customerHandler.addCustomer(new Customer("Ok", 300));
        customerHandler.addCustomer(new Customer("Man", 100));
        customerHandler.addCustomer(new Customer("Tom", 200));
        System.out.println("Enter customer name ");
        customerHandler.setUserName(inputHandler.getUserInput());
        customerValidator.checkForCustomer(customerHandler.getUserName());
        atmHandler.atmActions(customerHandler.getCustomer(customerHandler.getUserName()));
        customerPrinter.printCustomerDetails(customerHandler.getCustomer(customerHandler.getUserName()));
    }
}
