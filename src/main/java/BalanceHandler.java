import customer.Customer;
import customer.CustomerPrinter;

import java.util.Scanner;

public class BalanceHandler {
    void atmActions(Customer customer) {
        CustomerPrinter customerPrinter = new CustomerPrinter();
        System.out.println("Hello " + customer.getName() + customerPrinter.customerMessage());
        Scanner input = new Scanner(System.in);
        int atm = input.nextInt();
        while( atm != 3 ) {
            balanceModification(customer, atm);
            System.out.println(customerPrinter.customerMessage());
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

    private void withdrawMoney(Customer customer) {
        System.out.println("How much do you want to withdraw?");
        Scanner input = new Scanner(System.in);
        int moneyToWithdraw = input.nextInt();
        moneyToWithdraw = balanceCondition(moneyToWithdraw, customer.getBalance(),
                                           "You don't have enough money in the account.\nYour current balance is "
                                                   + customer.getBalance());
        int withdraw = customer.getBalance() - moneyToWithdraw;
        customer.setBalance(withdraw);
        System.out.println("Your current balance is $" + customer.getBalance());
    }

    private void depositMoney(Customer customer) {
        System.out.println("How much do you want to deposit?");
        int BALANCE_LIMIT = 20000;
        Scanner input = new Scanner(System.in);
        int deposit = input.nextInt();
        deposit = balanceCondition(deposit, BALANCE_LIMIT,
                                   "You can not add that much money at once. Add below $ " + BALANCE_LIMIT);
        int addingToBalance = customer.getBalance() + deposit;
        customer.setBalance(addingToBalance);
        System.out.println("Your current balance is $" + customer.getBalance());
    }

    private int balanceCondition(int balance, int balanceLimit, String message) {
        Scanner input = new Scanner(System.in);
        while( balance > balanceLimit ) {
            System.out.println(message);
            balance = input.nextInt();
        }
        return balance;
    }
}
