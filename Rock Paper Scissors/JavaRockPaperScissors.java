import java.util.Scanner;

public class JavaRockPaperScissors {

    public static void main(String[] args) {
        char player1 = ' ';
        char player2 = ' ';
        
        Scanner stdin = new Scanner(System.in);

        System.out.println("Enter R, P, S, or Q for rock, paper, scissors, or quit");
        do {
            System.out.print("Player 1 (R P S): ");
            player1 = stdin.next().toUpperCase().charAt(0);
            if (player1 == 'Q')
                break;
            else if (player1 != 'R' && player1 != 'P' && player1 != 'S') {
                System.out.println("Invalid input for player 1. Please enter R, P, S, or Q.");
                continue;
            }

            System.out.print("Player 2 (R P S): ");
            player2 = stdin.next().toUpperCase().charAt(0);
            if (player2 == 'Q')
                break;
            else if (player2 != 'R' && player2 != 'P' && player2 != 'S') {
                System.out.println("Invalid input for player 2. Please enter R, P, S, or Q.");
                continue;
            }

            // Comparison logic and result display
            if (player1 == player2)
                System.out.println("It's a tie!");
            else if ((player1 == 'R' && player2 == 'S') || (player1 == 'S' && player2 == 'P') || (player1 == 'P' && player2 == 'R'))
                System.out.println("Player 1 wins!");
            else
                System.out.println("Player 2 wins!");

        } while (player1 != 'Q' && player2 != 'Q');
        
        stdin.close();
    }
}
