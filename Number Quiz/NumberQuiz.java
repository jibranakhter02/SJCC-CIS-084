import java.util.Scanner;
import java.util.Random;

public class NumberQuiz {
    // Class-level arrays
    static int[][] quizArray = new int[10][3]; // 10 rows, 3 columns
    static int[] answer = new int[10];
    
    public static void main(String[] args) {
        build(); // Generate random numbers for quiz
        quiz(); // Administer the quiz
        grade(); // Grade the quiz
    }

    // Generate random numbers for the quiz
    static void build() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            quizArray[i][0] = random.nextInt(90) + 10; // Random number between 10 and 99
            quizArray[i][1] = random.nextInt(90) + 10; // Random number between 10 and 99
        }
    }

    // Administer the quiz
    static void quiz() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Number Quiz!");

        for (int i = 0; i < 10; i++) {
            System.out.print("Question " + (i + 1) + ": What is " + quizArray[i][0] + " + " + quizArray[i][1] + "? ");
            answer[i] = scanner.nextInt(); // Store user's answer
        }
    }

    // Grade the quiz
    static void grade() {
        int score = 0;
        System.out.println("\nQuiz Results:");
        for (int i = 0; i < 10; i++) {
            int correctAnswer = quizArray[i][0] + quizArray[i][1];
            System.out.print("Question " + (i + 1) + ": " + quizArray[i][0] + " + " + quizArray[i][1] +
                             " = " + answer[i] + " ");
            if (answer[i] == correctAnswer) {
                System.out.println("(Correct)");
                score += 10;
            } else {
                System.out.println("(Incorrect, correct answer is " + correctAnswer + ")");
            }
        }
        System.out.println("\nTotal Score: " + score + " out of 100");
    }
}