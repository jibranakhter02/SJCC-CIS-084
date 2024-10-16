import java.util.Scanner;

public class JavaFalafel {
    // class level constants and variables
    private static final double FALAFEL_PRICE = 5.15;
    private static final double SODA_PRICE = 2.24;
    private static final double EXTRAS_PRICE = 1.57;
    private static final double HUMMUS_PRICE = 3.99; // New item: Hummus
    private static final double TAX_RATE = 0.087;   // 8.7% tax rate
    
    static Scanner stdin;     // Scanner object for reading from the keyboard
    static boolean menuDisplayed = false;
    static double price = 0.00;
    static int falafel_count = 0;
    static int soda_count = 0;
    static int extras_count = 0;
    static int hummus_count = 0; // Counter for the new item
    static int total_items = 0; // Counter for total items
    static double subtotal = 0.00;
    
    public static void main(String[ ] args) {
        stdin = new Scanner(System.in);  // create the Scanner object
        
        char selection;
        do
        {
            price = 0.00;           // clear any previous price
            selection = menu( );    // display menu and get user's selection           
            switch (selection)
            {
            case 'F':
                price = FALAFEL_PRICE;
                falafel_count++;
                break;
            case 'S':
                price = SODA_PRICE;
                soda_count++;
                break;
            case 'X':
                price = EXTRAS_PRICE;
                extras_count++;
                break;   
            case 'H': // New case for Hummus
                price = HUMMUS_PRICE;
                hummus_count++;
                break;
            case 'T':
                break;
            default:
                System.out.println (" Illegal selection, try again.");
            } // end of switch (selection)
            
            subtotal += price;
            if (selection != 'T') total_items++; // Increment total items count only if 'T' is not entered
        } while (selection != 'T');

        System.out.println(); // Add a line gap after all selections
        displayBill( );
        
        stdin.close();  // Close stdin - it is no longer needed in this program
    } // end of public static void main(String[ ] args)

    static char menu( )
    {        
        char choice = ' ';
        // display the menu only one time
        if (!menuDisplayed) {
            System.out.printf ("\n");  // blank line before start of menu
            System.out.printf (" F = falafel  $%.2f\n", FALAFEL_PRICE);
            System.out.printf (" S = soda     $%.2f\n", SODA_PRICE);
            System.out.printf (" X = extras   $%.2f\n", EXTRAS_PRICE);
            System.out.printf (" H = hummus   $%.2f\n", HUMMUS_PRICE); // Display new item
            System.out.printf (" T = total\n\n");
            menuDisplayed = true;
        }
        System.out.printf (" Make your selection (FSXT): ");
        
        // get the user's selection and convert to upper case
        choice = stdin.nextLine( ).toUpperCase( ).charAt(0);
        return choice;               
    } // end of char menu( ) method
    
    static void displayBill() {
        // Display counts for each item
        System.out.printf(" Falafels: %d\n", falafel_count);
        System.out.printf(" Sodas: %d\n", soda_count);
        System.out.printf(" Extras: %d\n", extras_count);
        System.out.printf(" Hummus: %d\n", hummus_count);
        
        // Display line of dashes
        System.out.println(" -----------------");

        // Display total items count
        System.out.printf(" %d Total items\n\n", total_items);
        
        // Calculate subtotal, tax, and total
        double tax = subtotal * TAX_RATE;
        double total = subtotal + tax;
        
        // Display subtotal, tax, and total with 2 digits past the decimal
        System.out.printf("   Subtotal: $%.2f\n", subtotal);
        System.out.printf("   Tax (8.7%%): $%.2f\n", tax);
        System.out.printf("   Total: $%.2f\n", total);
    }
    
} // end of class JavaFalafel