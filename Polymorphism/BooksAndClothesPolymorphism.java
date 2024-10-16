import java.util.Scanner;
import java.util.InputMismatchException;

public class BooksAndClothesPolymorphism {
    private static Item[] shoppingCart = new Item[10];   // contains items in user's shopping cart
    private static int shoppingCartCount = 0;  // number of total items in the cart

    // define an array of books and pants
    private static final Item[] ITEM_LIST = {
        new Book(1176, "ULYSSES", "James Joyce", 1918, 32.95, 16),
        new Book(1252, "THE GREAT GATSBY", "F. Scott Fitzgerald", 1925, 13.95, 30),
        new Pants(3001, "Jeans", "Levi's", 32, 34, "Blue", 59.99, 5),
        new Pants(3002, "Chinos", "Dockers", 34, 36, "Beige", 49.99, 15),
        new Pants(3003, "Cargo Pants", "Wrangler", 30, 32, "Green", 39.99, 20)
    };

    public static void main(String[] args) {
        // create the stdin object (to use the keyboard)
        Scanner stdin = new Scanner(System.in);
        int itemSelected = 0;   // Item ID selected by user, 0 for not available
        int itemIndex = 0;      // selected index into array of items

        // display items in the arrays using the toString method
        System.out.printf("%-4.4s %6.6s %-11.11s\n", "Item", "Price", "Description");
        for (Item item : ITEM_LIST) {
            System.out.println(item);
        }

        System.out.println("\nSelect an item by its item number. Enter 0 to quit");
        do {
            try {
                if (shoppingCartCount >= shoppingCart.length) {
                    System.out.println("Your shopping cart is full.");
                    break;
                }

                System.out.printf("item #%d: ", shoppingCartCount + 1);
                itemSelected = stdin.nextInt();       // read line from keyboard
                if (itemSelected == 0) {
                    continue;   // exit the loop
                }

                // Search ITEM_LIST looking for the user's requested itemID
                for (itemIndex = 0; itemIndex < ITEM_LIST.length; itemIndex++) {
                    if (itemSelected == ITEM_LIST[itemIndex].getItemID()) {
                        break;  // it was found, itemIndex = position in the LIST
                    }
                }

                if (itemIndex == ITEM_LIST.length) {  // reached the end and not found
                    System.out.println("Item is not available");
                } else {  // The item was found
                    if (ITEM_LIST[itemIndex].getInStock() <= 0) {
                        System.out.println("Out of stock. Please try again later");
                    } else {
                        shoppingCart[shoppingCartCount] = ITEM_LIST[itemIndex];
                        shoppingCartCount++;  // keep track of items in the cart
                        ITEM_LIST[itemIndex].setInStock(ITEM_LIST[itemIndex].getInStock() - 1); // Decrement stock count
                    }
                }
            } catch (InputMismatchException | StringIndexOutOfBoundsException e) {
                System.out.println("Illegal selection. Try again");
                stdin.nextLine(); // clear input buffer
            }
        } while (itemSelected != 0);   // loop until a '0' is entered

        // display the shopping cart
        System.out.println("\n\nThank you for shopping at dan-azon");
        double total = 0;
        for (int i = 0; i < shoppingCartCount; i++) {
            System.out.println(shoppingCart[i]);
            total += shoppingCart[i].getPrice();
        }
        System.out.println(shoppingCartCount + " items in your cart");
        System.out.printf("Your total is $%.2f\n\n", total);
    } // end of main()
} // end of class
