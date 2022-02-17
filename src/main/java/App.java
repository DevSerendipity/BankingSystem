import java.math.BigInteger;
import java.util.Random;

public class App {
    private static final BankingSystem bankingSystem = new BankingSystem();


    public static void main(String[] args) {
        bankingSystem.getCustomers().add(new Customer("Man", 100));
        bankingSystem.getCustomers().add(new Customer("Tom", 100));
        bankingSystem.getBankDetails();
        getAllCustomers();
    }

    private static void getAllCustomers() {
        for (Customer value : bankingSystem.getCustomers()) {
            System.out.println("Name : " + value.getName() + "\nBalance " + value.getBalance() + "$\nAccountID " + new BigInteger(53, new Random()));
        }
    }
}
