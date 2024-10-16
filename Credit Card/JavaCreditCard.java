import java.util.Scanner;

public class JavaCreditCard {
    public static final double YEARLY_INTEREST_RATE = 22.24 / 100;  // 22.24% = 0.2224
    public static final double MONTHLY_INTEREST_RATE = YEARLY_INTEREST_RATE / 12;
    public static final double CREDIT_LIMIT = 500.00;  // credit limit
    public static final int MAX_MONTHS = 12;        // maximum months to display

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input values
        System.out.print("Enter starting balance: ");
        double balance = scanner.nextDouble();

        System.out.print("Enter additional charges: ");
        double charges = scanner.nextDouble();

        System.out.print("Enter payment for each month: ");
        double payment = scanner.nextDouble();

        // Computed values
        double interest;
        double newBalance;
        int month = 1;

        // table column headings
        System.out.printf("%5s  %7s  %8s  %7s  %7s  %11s\n",
                "Month", "Balance", "Interest", "Payment", "Charges", "New Balance");

        while (month <= MAX_MONTHS && (balance > 0 && balance <= CREDIT_LIMIT)) {
            interest = balance * MONTHLY_INTEREST_RATE;    // based on 12 months in a year
            newBalance = balance + interest + charges - payment;

            // Adjust payment if it exceeds balance plus charges
            if (payment > balance + charges) {
                payment = balance + charges;
            }

            // If newBalance is negative, adjust payment to prevent it from becoming negative
            if (newBalance < 0) {
                payment = balance + charges;
                newBalance = 0; // Set newBalance to 0 to avoid negative values
            }

            // display table values
            System.out.printf("%5d  %7.2f  %8.2f  %7.2f  %7.2f  %11.2f\n",
                    month, balance, interest, payment, charges, newBalance);

            month++;                // update month number
            balance = newBalance;   // transfer newBalance to balance for next computation
        }

        // Check termination conditions and display messages accordingly
        if (balance == 0) {
            System.out.println("Balance is zero");
        } else if (balance > CREDIT_LIMIT) {
            System.out.println("Balance is greater than the credit limit");
        } else if (month > MAX_MONTHS) {
            System.out.println("Reached the maximum number of months (12) with remaining balance.");
        } else {
            System.out.println("Balance is greater than zero but less than the credit limit.");
        }
    }
}