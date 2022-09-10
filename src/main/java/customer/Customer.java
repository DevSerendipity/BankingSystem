package customer;

import java.math.BigInteger;
import java.util.Random;

public class Customer {

    private final String name;
    private int balance;
    private final BigInteger accountId = new BigInteger(53,
                                                        new Random());

    public Customer(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public BigInteger getAccountId() {
        return accountId;
    }

}
