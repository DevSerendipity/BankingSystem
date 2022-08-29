import java.math.BigInteger;
import java.util.*;

public class BankingSystem {
    private final Scanner input = new Scanner(System.in);
    private final ArrayList<Customer> customers = new ArrayList<>();
    private String userInput = input.nextLine();

    public List<Customer> getCustomers() {
        return Collections.unmodifiableList(customers);
    }

    public void add(Customer customer) {
        customers.add(customer);
    }

    void getBankDetails() {
        boolean hasCustomer = customers.stream().anyMatch(this::isCustomerPresent);
        if ( !hasCustomer ) {
            System.out.println("We don't have a customer with that name");
        }
        System.out.println("Try again");
        userInput = input.nextLine();
    }

    private boolean isCustomerPresent(Customer value) {
        if ( value.getName().equals(userInput) ) {
            atmActions(value);
            customerDetails(value);
            return true;
        }
        return false;
    }

    private void customerDetails(Customer value) {
        System.out.println(
                "Name : " + value.getName() + "\nBalance " + value.getBalance() + "$\nAccountID" + new BigInteger(53,
                                                                                                                  new Random()));
    }

    void atmActions(Customer customer) {
        System.out.println("Hello " + customer.getName() + customerMessage());
        int atm = input.nextInt();
        while( atm != 3 ) {
            balanceModification(customer, atm);
            System.out.println(customerMessage());
            atm = input.nextInt();
        }
    }

    private void balanceModification(Customer customer, int atm) {
        if ( atm == 1 ) {
            depositMoney(customer);
        } else if ( atm == 2 ) {
            withdrawMoney(customer);
        }
    }

    private String customerMessage() {
        return "\nIf you wish to deposit money press 1 \nIf you wish to withdraw money press 2\nTo exit press 3";
    }

    private void withdrawMoney(Customer customer) {
        System.out.println("How much do you want to withdraw?");
        int balance = input.nextInt();
        balance = balanceCondition(balance, customer.getBalance(),
                                   "You don't have enough money in the account.\nYour current balance is "
                                           + customer.getBalance());
        int withdraw = customer.getBalance() - balance;
        customer.setBalance(withdraw);
        System.out.println("Your current balance is $" + customer.getBalance());
    }

    private void depositMoney(Customer customer) {
        System.out.println("How much do you want to add to your account?");
        int balance = input.nextInt();
        int BALANCE_LIMIT = 999999999;
        balance = balanceCondition(balance, BALANCE_LIMIT,
                                   "You can not add that much money at once. Add below $999999999");
        int addingToBalance = customer.getBalance() + balance;
        customer.setBalance(addingToBalance);
        System.out.println("Your current balance is $" + customer.getBalance());
    }

    private int balanceCondition(int balance, int balanceLimit, String message) {
        while( balance > balanceLimit ) {
            System.out.println(message);
            balance = input.nextInt();
        }
        return balance;
    }
}
