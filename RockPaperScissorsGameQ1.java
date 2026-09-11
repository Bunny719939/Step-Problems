import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGameQ1 {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int rounds = 5;
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int round = 0; round < rounds; round++) {
            System.out.print("Enter your move: ");
            String playerMove = scanner.nextLine();

            String computerMove = moves[random.nextInt(3)];
            String result = playRound(playerMove, computerMove);

            playerMoves[round] = playerMove;
            computerMoves[round] = computerMove;
            results[round] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println("Round " + (round + 1) + ": " + result);
        }

        double winPercentage = ((double) wins / rounds) * 100;

        System.out.println("\nRound | Player Move | Computer Move | Result");

        for (int round = 0; round < rounds; round++) {
            System.out.println((round + 1) + " | " +
                    playerMoves[round] + " | " +
                    computerMoves[round] + " | " +
                    results[round]);
        }

        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", winPercentage);

        scanner.close();
    }
}
