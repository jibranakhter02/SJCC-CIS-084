import java.util.Scanner;

public class JavaTicTacToe {
    static char[][] board = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
    };

    public static void main(String[] args) {
        int squareCounter = 0;
        char gameWinner = '-';
        char inputCharacter;
        int choice;
        char player;

        Scanner stdin = new Scanner(System.in);

        int selectFirstPlayer = (int) (Math.random() * 2);
        player = selectFirstPlayer % 2 == 1 ? 'X' : 'O';
        System.out.println("The starting player is using " + player);

        System.out.println("Enter a number 1 through 9 to select a square");

        while (squareCounter < 9 && gameWinner != 'X' && gameWinner != 'O') {
            System.out.println("--------------------------------");
            displayTicTacToe(board);
            System.out.print("Player " + player + ", enter a number (1-9): ");
            inputCharacter = stdin.next().charAt(0);
            choice = inputCharacter - '1';
            int row = choice / 3;
            int col = choice % 3;

            if (choice < 0 || choice > 8)
                System.out.println("Illegal value, try again");
            else if (board[row][col] == 'X' || board[row][col] == 'O')
                System.out.println("This space has already been used, try again");
            else {
                board[row][col] = player;
                squareCounter++;
                player = (player == 'X') ? 'O' : 'X';
            }
            gameWinner = checkForWinningGame(board);
        }

        displayTicTacToe(board);
        System.out.println("");
        if (gameWinner == 'X' || gameWinner == 'O')
            System.out.printf("Player %c wins the game\n\n", gameWinner);
        else
            System.out.printf("Tie game\n\n");
        stdin.close();
    }

    public static void displayTicTacToe(char[][] board) {
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public static char checkForWinningGame(char[][] board) {
        for (int row = 0; row < 3; row++) {
            // Check rows
            if (board[row][0] == board[row][1] && board[row][1] == board[row][2])
                return board[row][0];
        }

        for (int col = 0; col < 3; col++) {
            // Check columns
            if (board[0][col] == board[1][col] && board[1][col] == board[2][col])
                return board[0][col];
        }

        // Check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return board[0][0];
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return board[0][2];

        return '-';
    }
}
