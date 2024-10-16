import java.util.Scanner;

public class JavaElectricBillTryThrowCatch {
    // declare the constants for the tier limits
    public static final int TIER1_LIMIT = 350;  // 0-350 kWh
    public static final int TIER2_LIMIT = 1450; // 351-1450 kWh
    
    // declare the constants for billing rates
    public static final double TIER1_RATE = 0.23;  // 23 cents per kWh
    public static final double TIER2_RATE = 0.29;  // 29 cents per kWh
    public static final double TIER3_RATE = 0.45;  // 45 cents per kWh
    public static final double ENERGY_COMMISSION_TAX = 0.20;  // Fixed Energy Commission tax amount

    public static void main(String[] args) {
        // declare variables for kWh input, kWh each tier, billing each tier and total
        double kWh = 0;
        double tier1_kWh = 0;
        double tier2_kWh = 0;
        double tier3_kWh = 0;
        double tier1_bill = 0;
        double tier2_bill = 0;
        double tier3_bill = 0;
        double totalBill = 0;
    
        // INPUT: prompt and input the kWh used
        Scanner stdin = new Scanner(System.in);
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("Enter the kWh: ");
            try {
                kWh = stdin.nextDouble();
                validInput = true; // Set flag to true if input is numerical
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a numerical value.");
                stdin.nextLine(); // Consume invalid input
            }
        }

        // PROCESS: determine kWh in each tier
        if (kWh <= TIER1_LIMIT) {
            tier1_kWh = kWh;
        } else if (kWh <= TIER2_LIMIT) {
            tier1_kWh = TIER1_LIMIT;
            tier2_kWh = kWh - TIER1_LIMIT;
        } else {
            tier1_kWh = TIER1_LIMIT;
            tier2_kWh = TIER2_LIMIT - TIER1_LIMIT;
            tier3_kWh = kWh - TIER2_LIMIT;
        }
        
        // PROCESS: determine the billing for each tier
        tier1_bill = Math.round(tier1_kWh * TIER1_RATE * 100.0) / 100.0;
        tier2_bill = Math.round(tier2_kWh * TIER2_RATE * 100.0) / 100.0;
        tier3_bill = Math.round(tier3_kWh * TIER3_RATE * 100.0) / 100.0;
        
        // PROCESS: calculate the total bill
        totalBill = tier1_bill + tier2_bill + tier3_bill + ENERGY_COMMISSION_TAX;
        
        // OUTPUT: display the kWh used for each tier and the billing amount for each tier
        System.out.printf("Tier 1 kWh: %.2f%n", tier1_kWh);
        System.out.printf("Tier 1 Bill: $%.2f%n", tier1_bill);
        System.out.printf("Tier 2 kWh: %.2f%n", tier2_kWh);
        System.out.printf("Tier 2 Bill: $%.2f%n", tier2_bill);
        System.out.printf("Tier 3 kWh: %.2f%n", tier3_kWh);
        System.out.printf("Tier 3 Bill: $%.2f%n", tier3_bill);
        
        // OUTPUT: display the Energy Commission tax and the total bill
        System.out.printf("Energy Commission Tax: $%.2f%n", ENERGY_COMMISSION_TAX);
        System.out.printf("Total Bill: $%.2f%n", totalBill);
        
        stdin.close(); // close stdin - it is no longer needed in this program
    }
}
