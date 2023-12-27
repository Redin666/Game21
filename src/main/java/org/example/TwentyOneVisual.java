package org.example;

import java.util.List;
import java.util.Scanner;


public class TwentyOneVisual {
    public static void main(String[] args) {
        TwentyOneGame game = new TwentyOneGame();
        Scanner scanner = new Scanner(System.in);

        while (!game.isGameOver()) {
            displayHands(game.getPlayerHand(), game.getComputerHand());
            System.out.println("Your score: " + game.getPlayerScore());
            System.out.println("Balance: $" + game.getBalance());
            System.out.println("Do you want to hit? (yes/no)");
            String choice = scanner.nextLine().toLowerCase();

            if ("yes".equals(choice)) {
                game.playerHit();
            } else if ("no".equals(choice)) {
                game.computerPlay();
            }
        }

        displayHands(game.getPlayerHand(), game.getComputerHand());
        System.out.println("Your score: " + game.getPlayerScore());
        System.out.println("Computer score: " + game.getComputerScore());
        System.out.println("Balance: $" + game.getBalance());


        if (game.getPlayerScore() > 21) {
            System.out.println("You busted! Computer wins.");
        } else if (game.getComputerScore() > 21 || game.getPlayerScore() > game.getComputerScore()) {
            System.out.println("You win!");
            game.updateBalance(10);
        } else {
            System.out.println("Computer wins!");
        }
    }

    private static void displayHands(List<Card> playerHand, List<Card> computerHand) {
        System.out.println("Your hand: " + playerHand);
        System.out.println("Computer's hand: " + computerHand.get(0) + " [?] ");
    }
}
