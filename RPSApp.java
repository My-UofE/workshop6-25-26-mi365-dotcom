import java.util.Scanner;
import java.util.Random;

enum HandSign {
    ROCK, 
    PAPER,
    SCISSORS 
}

public class RPSApp {
    /**
     * Get the computer’s move (randomly generated)
     */
    public static HandSign getComputerMove(){
        Random rd = new Random();
        int n = rd.nextInt(3); // n will be a random number in {0,1,2}
        
        HandSign computerMove = null; 

        // code using n to select
        // a HandSign
        switch(n){
            case 0:
                computerMove = HandSign.ROCK;
                break;
            case 1:
                computerMove = HandSign.PAPER;
                break;
            case 2:
                computerMove = HandSign.SCISSORS;
                break;
        }

        return computerMove;
    }

    /**
     * Get the player move from the keyboard input
     */
    public static HandSign getPlayerMove(){
        // The Scanner class is used to get the keyboard input
        Scanner in = new Scanner(System.in);
        // Use a variable to tag if the input is valid 
        // (one of the characters {s,S,p,P,r,R,q,Q}) or not
        boolean validInput = false;
        HandSign playerHandSign = null;
        do {// repeat until valid input
            System.out.println("Enter your move: [r] for rock, [p] for paper, [s] for scissor, [q] for quit");
            char inChar = in.next().toLowerCase().charAt(0);

            switch(inChar){
                case 'r':
                    playerHandSign = HandSign.ROCK;
                    validInput = true;
                    break;
                case 'p':
                    playerHandSign = HandSign.PAPER;
                    validInput = true;
                    break;
                case 's':
                    playerHandSign = HandSign.SCISSORS;
                    validInput = true;
                    break;
                case 'q':
                    System.out.println("Ending the game thanks for playing!");
                    System.exit(0);
                default:
                    System.out.println("Invalid Input try again!");
            }


        } while(!validInput);
        
        return playerHandSign;

      }

    /**
     * Check who wins
     *
     * @param h1 the first hand sign
     * @param h2 the second hand sign
     * @return 0 if two signs equal, 
     *        -1 if the second sign wins, 
     *         1 if the first sign wins
     *
     */
    public static int whoWins(HandSign h1, HandSign h2){
         if (h1 == h2){
            return 0;
         } 
         switch (h1) {
            case ROCK:
                return (h2 == HandSign.SCISSORS) ? 1 : -1;
            case PAPER:
                return (h2 == HandSign.ROCK) ? 1 : -1;
            case SCISSORS:
                return (h2 == HandSign.PAPER) ? 1 : -1;
            
         }
         return 0;

    }
    
    /**
     * The main method
     * 
     */
    public static void main(String[] args) {
        int playerScore = 0;
        int computerScore = 0;

        HandSign playerMove;// player’s sign from keyboard
        HandSign computerMove;// computer’s random sign

        int checkwin;
        boolean gameOver = false;
        while (!gameOver){
            // repeat this process till the user quits
            
            //Step1: Get the player move from the keyboard input
            playerMove = getPlayerMove();

            //Step2: Get the computer’s move (randomly generated)
            computerMove = getComputerMove();

            //Step3: Check who wins
            int result = whoWins(playerMove, computerMove);

            //Step4: Output who played what and who won the round
            System.out.println("You played: " + playerMove);
            System.out.println("Computer played: " + computerMove);

            if(result == 1){
                System.out.println("You win this round!!");
                playerScore++;
            } else if(result == -1){
                System.out.println("Computer wins this round!");
                computerScore++;
            } else{
                System.out.println("It is a tie.");
            }

            //Step5: Update and print player/computer scores
            System.out.println("#################################################");
            System.out.println("You score: " + playerScore + " Computer's score is " + computerScore);
            System.out.println("#################################################");

        }
    }
}