import customer.Customer;
import customer.CustomerPrinter;

import java.util.Scanner;

public class ATMHandler {
    private final BalanceHandler balanceHandler = new BalanceHandler();

    void atmActions(Customer customer) {
        CustomerPrinter customerPrinter = new CustomerPrinter();
        System.out.println("Hello " + customer.getName() + customerPrinter.printCustomerMessage());
        Scanner input = new Scanner(System.in);
        int atm = input.nextInt();
        while( atm != 3 ) {
            balanceHandler.balanceModification(customer, atm);
            System.out.println(customerPrinter.printCustomerMessage());
            atm = input.nextInt();
        }
    }
}
