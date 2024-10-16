import java.util.InputMismatchException;
import java.util.Scanner;

public class SeatSales {
    // Constants for seat prices
    static final double PREMIUM_PRICE = 45.00;
    static final double STANDARD_PRICE = 30.00;
    static final double ECONOMY_PRICE = 21.00;
    
    // Sales tax rate
    static final double SALES_TAX_RATE = 0.0825;
    
    // Service charge
    static final double SERVICE_CHARGE = 5.00;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input the number of seats sold for each category
        int premiumSeats = getValidInput(scanner, "Premium");
        int standardSeats = getValidInput(scanner, "Standard");
        int economySeats = getValidInput(scanner, "Economy");
        
        // Calculate subtotal
        double subtotal = premiumSeats * PREMIUM_PRICE + standardSeats * STANDARD_PRICE + economySeats * ECONOMY_PRICE;
        
        // Calculate tax
        double tax = subtotal * SALES_TAX_RATE;
        
        // Calculate total including tax
        double totalBeforeSurcharge = subtotal + tax;
        
        // Add service charge
        double total = totalBeforeSurcharge + SERVICE_CHARGE;
        
        // Output results
        System.out.println("Subtotal = $" + String.format("%.2f", subtotal));
        System.out.println("Tax = $" + String.format("%.2f", tax));
        System.out.println("Surcharge = $" + String.format("%.2f", SERVICE_CHARGE));
        System.out.println("Total = $" + String.format("%.2f", total));
        
        scanner.close();
    }
    
    // Function to get valid input for number of seats sold
    static int getValidInput(Scanner scanner, String category) {
        int seats;
        while (true) {
            System.out.print("Enter the number of " + category + " seats sold: ");
            try {
                seats = scanner.nextInt();
                if (seats >= 0) {
                    break;
                } else {
                    System.out.println("Negative input detected.");
                    seats *= -1; // Convert negative input to positive
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer value.");
                scanner.next(); // Consume invalid input
            }
        }
        return seats;
    }
}
