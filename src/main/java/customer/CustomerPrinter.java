package customer;

public class CustomerPrinter {

    public String printCustomerMessage() {
        return "\nIf you wish to deposit money press 1\nIf you wish to withdraw money press 2\nTo exit press 3";
    }

    public void printCustomerDetails(Customer value) {
        System.out.format("Name: %s\nBalance: $%d\nAccountID: %d", value.getName(), value.getBalance(),
                          value.getAccountId());
    }

}
