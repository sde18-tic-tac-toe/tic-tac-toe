package com.tictactoe.tictactoe.game;

import com.tictactoe.tictactoe.player.*;

import java.util.Scanner;

public class TicTacToeInitiateGame implements InitiateGame {

    /**
     * @param game Reference to the Game.
     * @param name Reference to player name (generated from user input prompt.)
     * @return result of coin flip, in this case either a 0 or a 1, but to provide
     * proper context to the player, these options are reframed to 1 for heads and
     * 2 for tails.
     */
    @Override
    public int initiateGame(Game game, String name) {

        game.getPlayers().put(1, new Player(name, "X", 1, new TicTacToeUserSelectSquare(),
                new UserMakeWager()));
        game.getPlayers().put(2, new Player("Syntactical Computer", "O", 2,
                new TicTacToeComputerSelectSquare(), new ComputerMakeWager()));

        System.out.println("Welcome to Tic-Tac-Toe, " + name + "!");
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nWould you like to view instructions for Tic Tac Toe ([y]es or [n]o)? ");
        String viewInstructions = scanner.nextLine();
        while(!viewInstructions.toLowerCase().equals("y") && !viewInstructions.toLowerCase().equals("n") &&
                !viewInstructions.toLowerCase().equals("yes") && !viewInstructions.toLowerCase().equals("no")) {
            System.out.print("Invalid selection. Please enter [y]es or [n]o: ");
            viewInstructions = scanner.nextLine();
        }

        if (viewInstructions.toLowerCase().equals("y")) {
            System.out.println();
            displayInstructions();
            if (game.isWagerGame()) {
                System.out.println();
                displayWagerInstructions();
            }
        }

        if(!game.isWagerGame()) {
            return coinFlip(scanner);
        }

        return 0;
    }

    private int coinFlip(Scanner scanner) {
        System.out.print("Lets flip a coin to see who goes first! \n Please choose [1] for heads or [2] for tails... ");
        String playerFlip = scanner.nextLine();
        while(!playerFlip.equals("1") && !playerFlip.equals("2")) {
            System.out.print("Invalid selection. Please select [1] for heads or [2] for tails to see who goes first! ");
            playerFlip = scanner.nextLine();
        }

        double flipResult = Math.random();
        int coinFlipResult = 0;
        if (flipResult <= 0.5 && playerFlip.equals("1")) {
            System.out.println("The coin landed heads up! You're first!\n");
            coinFlipResult = 1;
        } else if
        (flipResult > 0.5 && playerFlip.equals("1")) {
            System.out.println("The coin landed tails up... You're going second.\n");
            coinFlipResult = 2;
        } else if
        (flipResult >= 0.5 && playerFlip.equals("2")) {
            System.out.println("The coin landed tails up! You're first!\n");
            coinFlipResult = 1;
        } else if
        (flipResult < 0.5 && playerFlip.equals("2")) {
            System.out.println("The coin landed heads up... You're going second.\n");
            coinFlipResult = 2;
        }

        return coinFlipResult;
    }

    private void displayWagerInstructions() {
        System.out.println("Wagering:\n \n" +
                "Each player begins the game with 100 points total, of which they can choose to \n" +
                "wager at the start of each turn. Players can bet as much or as little as \n" +
                "they like, though the winner of the wager will go first in that given round. \n");
    }

    private void displayInstructions() {
        System.out.println("Here is the game board... Note that each grid square is represented by a number. " +
                "These numbers represent how you select the square you want to place your token.\n\n" +

                "      |     |     \n" +
                "   1  |  2  |  3  \n" +
                " _____|_____|_____\n" +
                "      |     |     \n" +
                "   4  |  5  |  6  \n" +
                " _____|_____|_____\n" +
                "      |     |     \n" +
                "   7  |  8  |  9  \n" +
                "      |     |     \n");

        //Thread.sleep(4000);

        System.out.println("The objective of the game is to complete a line of three placements of \"X\". \n" +
                "The game will flip a coin to determine who goes first, and then you will take turns making \n" +
                "placements until either you or the computer wins, or there is a draw (all squares filled without \n" +
                "a winning combo.) To win, you must occupy three consecutive squares in a straight line with an \"X\", \n" +
                "be them top to bottom, left to right, or diagonally across the grid array (or vise versa in all cases.) \n");

        //Thread.sleep(10000);

        System.out.println("Here is an example of a winning combination after 5 turns: \n\n" +

                "      |     |     \n" +
                "   X  |  O  |  O  \n" +
                " _____|_____|_____\n" +
                "      |     |     \n" +
                "   4  |  X  |  O  \n" +
                " _____|_____|_____\n" +
                "      |     |     \n" +
                "   7  |  8  |  X  \n" +
                "      |     |      \n\n" +
                "As you can see, squares that have not yet been selected have no designation and \n" +
                "that grid square is open for selection. Selections that have been made will replace\n" +
                "the empty square associated with that grid square with your token.\n\n" );

        //Thread.sleep(6000);

        System.out.println("Sound good? Lets play! \n \n");
    }
}