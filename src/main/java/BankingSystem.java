import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BankingSystem {
    private final Scanner input = new Scanner(System.in);
    private final String userInput = input.nextLine();
    private final ArrayList<Customer> customers = new ArrayList<>();

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    void getBankDetails() {
        boolean haveCustomer = false;
        for (Customer value : customers) {
            if (value.getName().equals(userInput)) {
                haveCustomer = true;
                bankActions(value);
                System.out.println("Name : " + value.getName() + "\nBalance " + value.getBalance() + "$\nAccountID" +  new BigInteger(53, new Random()));
            }
        }
        if(!haveCustomer){
            System.out.println("We don't have a customer with that name");
        }
    }

    void bankActions(Customer customer) {
        System.out.println("Hello " + customer.getName() + "\nIf you wish to deposit money press 1 \nIf you wish to withdraw money press 2\nTo exit press 3");
        int atm = input.nextInt();
        while (atm != 3) {
            if (atm == 1) {
                depositMoney(customer);
            } else if (atm == 2) {
                withdrawMoney(customer);
            }
            System.out.println("If you wish to deposit money press 1 \nIf you wish to withdraw money press 2\nTo exit press 3");
            atm = input.nextInt();
        }
    }

    private void withdrawMoney(Customer customer) {
        System.out.println("How much do you want to withdraw?");
        int balance = input.nextInt();
        balance = balanceCondition(balance, customer.getBalance(), "You don't have enough money in the account.\nYour current balance is " + customer.getBalance());
        int withdraw = customer.getBalance() - balance;
        customer.setBalance(withdraw);
        System.out.println("Your current balance is $" + customer.getBalance());
    }

    private void depositMoney(Customer customer) {
        System.out.println("How much do you want to add to your account?");
        int balance = input.nextInt();
        int BALANCE_LIMIT = 999999999;
        balance = balanceCondition(balance, BALANCE_LIMIT, "You can not add that much money at once. Add below $999999999");
        int addingToBalance = customer.getBalance() + balance;
        customer.setBalance(addingToBalance);
        System.out.println("Your current balance is $" + customer.getBalance());
    }

    private int balanceCondition(int balance, int i, String s) {
        while (balance > i) {
            System.out.println(s);
            balance = input.nextInt();
        }
        return balance;
    }
}
