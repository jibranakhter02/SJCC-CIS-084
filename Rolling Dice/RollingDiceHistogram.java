import java.util.Scanner;

public class RollingDiceHistogram {

    // Function to roll a single die
    static int roll(int faceCount) {
        int dotCount = (int)(Math.random() * faceCount) + 1;
        return dotCount;
    }

    // Function to roll two dice and return the sum
    static int rollDice() {
        return roll(6) + roll(6);
    }

    // Function to create frequency distribution and display results
    static void displayHistogram(int rolls, Scanner scanner) {
        int[] counters = new int[11]; // Index 0 to 10 corresponds to sums 2 to 12

        System.out.println("Press Enter to roll the dice...");
        scanner.nextLine(); // Wait for user to press enter

        // Simulate rolling the dice 'rolls' times and count occurrences
        for (int i = 0; i < rolls; i++) {
            int sum = rollDice();
            counters[sum - 2]++; // Increment counter corresponding to the sum
        }

        // Display the frequency distribution
        for (int i = 0; i < counters.length; i++) {
            System.out.printf("%2d: %d%n", i + 2, counters[i]);
        }
    }

    public static void main(String[] args) {
        final int NUM_ROLLS = 1000; // Number of times to roll the dice
        Scanner scanner = new Scanner(System.in);
        displayHistogram(NUM_ROLLS, scanner);
        scanner.close();
    }
}