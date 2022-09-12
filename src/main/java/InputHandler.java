import java.util.Scanner;

public class InputHandler {

    private final Scanner input = new Scanner(System.in);

    public String getUserInput() {
        return input.nextLine();
    }

    public double getInputMoneyAmount() {
        return input.nextDouble();
    }
}
