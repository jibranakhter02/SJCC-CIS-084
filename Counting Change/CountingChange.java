import java.util.Scanner;

public class CountingChange {

    static Scanner stdin;

    public static void main(String[] args) {
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;

        stdin = new Scanner(System.in);

        quarters = getValidInput("Enter the number of quarters: ");
        dimes = getValidInput("Enter the number of dimes: ");
        nickels = getValidInput("Enter the number of nickels: ");
        pennies = getValidInput("Enter the number of pennies: ");

        double totalAmount = computeTotalAmount(quarters, dimes, nickels, pennies);
        System.out.printf("The total amount is $%.2f%n", totalAmount);
    }

    static int getValidInput(String prompt) {
        int input = 0;
        boolean isValid = false;

        do {
            try {
                System.out.print(prompt);
                input = stdin.nextInt();
                isValid = true; // Input is valid, exit loop
            } catch (Exception e) {
                System.out.println("Please enter a valid integer.");
                stdin.next(); // Clear invalid input from scanner buffer
            }
        } while (!isValid);

        return input;
    }

    static double computeTotalAmount(int quarters, int dimes, int nickels, int pennies) {
        double totalAmount = quarters * 0.25 + dimes * 0.10 + nickels * 0.05 + pennies * 0.01;
        return totalAmount;
    }
}