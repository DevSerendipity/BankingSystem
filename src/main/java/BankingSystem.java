import customer.Customer;
import customer.CustomerHandler;
import customer.CustomerMessagePrinter;
import customer.CustomerValidator;

public class BankingSystem {
    private static final CustomerValidator CUSTOMER_VALIDATOR = new CustomerValidator();
    private static final CustomerHandler CUSTOMER_HANDLER = new CustomerHandler();
    private static final InputHandler INPUT_HANDLER = new InputHandler();
    private static final CustomerMessagePrinter CUSTOMER_PRINTER = new CustomerMessagePrinter();
    private static final ATMHandler ATM_HANDLER = new ATMHandler();

    public static void main(String[] args) {
        CUSTOMER_HANDLER.addCustomer(new Customer("Ok", 300));
        CUSTOMER_HANDLER.addCustomer(new Customer("Man", 100));
        CUSTOMER_HANDLER.addCustomer(new Customer("Tom", 200));
        System.out.println("Enter customer name ");
        CUSTOMER_HANDLER.setUserName(INPUT_HANDLER.getUserInput());
        CUSTOMER_VALIDATOR.checkForCustomer();
        ATM_HANDLER.atmActions(CUSTOMER_HANDLER.getCustomer());
        CUSTOMER_PRINTER.printCustomerDetails(CUSTOMER_HANDLER.getCustomer());
    }
}
