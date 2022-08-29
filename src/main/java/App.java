import java.math.BigInteger;
import java.util.Random;

public class App {
    private static final BankingSystem bankingSystem = new BankingSystem();

    public static void main(String[] args) {
        addCustomer("Man");
        addCustomer("Tom");
        bankingSystem.getBankDetails();
        getAllCustomers();
    }

    private static void addCustomer(String customer) {
        bankingSystem.add(new Customer(customer, 100));
    }

    private static void getAllCustomers() {
        bankingSystem.getCustomers().forEach(customer -> System.out.print(
                "Name : " + customer.getName() + "\nBalance " + customer.getBalance() + "$\nAccountID "
                        + new BigInteger(53, new Random())));
    }
}
