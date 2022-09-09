package customer;

import java.math.BigInteger;
import java.util.Random;

public class CustomerPrinter {

    public String customerMessage() {
        return "\nIf you wish to deposit money press 1 \nIf you wish to withdraw money press 2\nTo exit press 3";
    }

    public void customerDetails(Customer value) {
        System.out.println(
                "Name : " + value.getName() + "\nBalance " + value.getBalance() + "$\nAccountID" + new BigInteger(53,
                                                                                                                  new Random()));
    }

}
