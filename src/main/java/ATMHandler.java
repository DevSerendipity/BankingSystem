import customer.Customer;
import customer.CustomerMessagePrinter;

import java.util.Scanner;

public class ATMHandler {

    void atmActions(Customer customer) {
        CustomerMessagePrinter customerMessagePrinter = new CustomerMessagePrinter();
        BalanceHandler balanceHandler = new BalanceHandler();
        System.out.println("Hello " + customer.getName() + customerMessagePrinter.printCustomerMessage());
        Scanner input = new Scanner(System.in);
        int atm = input.nextInt();
        while ( atm != 3 ) {
            balanceHandler.balanceModification(customer, atm);
            System.out.println(customerMessagePrinter.printCustomerMessage());
            atm = input.nextInt();
        }
    }
}
