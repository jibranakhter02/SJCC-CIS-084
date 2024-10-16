import java.util.Scanner;

public class LengthOfLine {

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the coordinates of the two end-points of the line
        System.out.println("Enter the coordinates of the first end-point (x1 y1):");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.println("Enter the coordinates of the second end-point (x2 y2):");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        // Call the method to compute the length of the line segment
        double length = computeLength(x1, y1, x2, y2);

        // Display the length of the line segment with four digits past the decimal
        System.out.printf("The length of the line segment is: %.4f%n", length);

        // Close the scanner
        scanner.close();
    }

    // Method to compute the length of a line segment
    public static double computeLength(double x1, double y1, double x2, double y2) {
        double deltaX = x2 - x1;
        double deltaY = y2 - y1;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}