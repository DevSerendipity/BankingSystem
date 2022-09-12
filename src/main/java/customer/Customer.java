package customer;

import java.util.UUID;

public class Customer {

    private final String name;
    private final UUID accountId = UUID.randomUUID();
    private double balance;

    public Customer(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public UUID getAccountId() {
        return accountId;
    }

}
