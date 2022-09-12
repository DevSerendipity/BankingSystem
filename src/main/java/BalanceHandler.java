import customer.Customer;

public class BalanceHandler {

    private final InputHandler inputHandler = new InputHandler();

    protected void balanceModification(Customer customer, int atm) {
        if ( atm == 1 ) {
            depositMoney(customer);
        } else if ( atm == 2 ) {
            withdrawMoney(customer);
        }
    }

    private void withdrawMoney(Customer customer) {
        System.out.println("How much do you want to withdraw?");
        double moneyToWithdraw = inputHandler.getInputMoneyAmount();
        moneyToWithdraw = balanceCondition(moneyToWithdraw, customer.getBalance(),
                                           "You don't have enough money in the account.\nYour current balance is "
                                                   + customer.getBalance());
        double withdraw = customer.getBalance() - moneyToWithdraw;
        customer.setBalance(withdraw);
        System.out.println("Your current balance is $" + customer.getBalance());
    }

    private void depositMoney(Customer customer) {
        System.out.println("How much do you want to deposit?");
        final double balanceLimit = 20000;
        double deposit = inputHandler.getInputMoneyAmount();
        deposit = balanceCondition(deposit, balanceLimit,
                                   "You can not add that much money at once. Add below $ " + balanceLimit);
        double addingToBalance = customer.getBalance() + deposit;
        customer.setBalance(addingToBalance);
        System.out.println("Your current balance is $" + customer.getBalance());
    }

    private double balanceCondition(double balance, double balanceLimit, String message) {
        while ( balance > balanceLimit ) {
            System.out.println(message);
            balance = inputHandler.getInputMoneyAmount();
        }
        return balance;
    }
}
