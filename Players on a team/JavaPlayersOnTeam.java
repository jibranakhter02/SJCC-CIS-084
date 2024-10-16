import java.util.Scanner;

public class JavaPlayersOnTeam {
    
    static Scanner stdin;
    
    public static void main(String[] args) {
        int teamSize;
        int playersOnTeam;
        int morePlayersNeeded;
        int extraPlayers;
        
        stdin = new Scanner(System.in);
        
        try {
            teamSize = selectTeamSize();
            System.out.println("There should be " + teamSize + " players");
            
            System.out.print("How many players are currently on the team? ");
            playersOnTeam = stdin.nextInt();
            
            if (playersOnTeam < teamSize) {
                System.out.println("There are not enough players");
                morePlayersNeeded = teamSize - playersOnTeam;
                System.out.println(morePlayersNeeded + " more players are needed");
            } else if (playersOnTeam > teamSize) {
                System.out.println("There are too many players");
                extraPlayers = playersOnTeam - teamSize;
                System.out.println(extraPlayers + " players need to be removed");
            } else {
                System.out.println("You have the correct number of players\n");
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a valid integer.");
        }
    }
    
    static int selectTeamSize() {
        int teamSelection;
        int teamSize = 0;
        
        do {
            System.out.println("Select a professional sport");
            System.out.println("1 - NFL Football");
            System.out.println("2 - NFL Basketball");
            System.out.println("3 - MLB Baseball");
            System.out.println("4 - NHL Hockey");
            System.out.print("Select (1-4): ");
            
            teamSelection = stdin.nextInt();
            
            if (teamSelection == 1)
                teamSize = 53;
            else if (teamSelection == 2)
                teamSize = 13;
            else if (teamSelection == 3)
                teamSize = 25;
            else if (teamSelection == 4)
                teamSize = 23;
            else
                System.out.println("Illegal selection - try again");
        } while (teamSize == 0);
        
        return teamSize;
    }
}
