package com.tictactoe.tictactoe;

import java.util.Scanner;

/**
 * Client houses main() method and instantiates the game.
 */
public class Client {

    private static Game game;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nWelcome, player 1! Please enter your name: ");
        String name = scanner.nextLine();

        gameSelection(scanner, name);
    }

    private static void gameSelection(Scanner scanner, String name) {
        // determine which game the user would like to play
        System.out.println("Which game would you like to play?");
        System.out.println("1: Tic Tac Toe");
        System.out.println("2: Tic Tac Toe with wagering");
        String gameSelection = scanner.nextLine();
        while(!gameSelection.equals("1") && !gameSelection.equals("2")) {
            System.out.print("Invalid selection. Please choose 1 or 2: ");
            gameSelection = scanner.nextLine();
        }

        if(gameSelection.equals("1")) {
            game = new Game(new TicTacToeGrid(new TicTacToeEvaluateWin(),
                    new TicTacToeEndInTie()), new TicTacToeInitiateGame(),
                    new TicTacToeNextTurn(), false);
            gameIteration(name);
        } else {
            game = new Game(new TicTacToeGrid(new TicTacToeEvaluateWin(),
                    new TicTacToeEndInTie()), new TicTacToeInitiateGame(),
                    new TicTacToeNextTurn(), true);
            wagerGameIteration(name);
        }

        System.out.print("Play again? [y]es or [n]o: ");
        scanner = new Scanner(System.in);
        String playAgain = scanner.nextLine();
        while(!playAgain.toLowerCase().equals("y") && !playAgain.toLowerCase().equals("n") &&
                !playAgain.toLowerCase().equals("yes") && !playAgain.toLowerCase().equals("no")) {
            System.out.print("Invalid selection. Please enter [y]es or [n]o: ");
            playAgain = scanner.nextLine();
        }

        if (playAgain.toLowerCase().equals("y")) {
            System.out.println();
            gameSelection(scanner, name);
        }
    }

    private static void gameIteration(String name) {
        int coinFlipResult = new TicTacToeInitiateGame().initiateGame(game, name);

        game.getGrid().displayGrid();

        TurnResult turnResult = TurnResult.CONTINUE;
        while (turnResult == TurnResult.CONTINUE) {
            turnResult = game.getNextTurn().nextTurn(coinFlipResult, game);
        }

        if (turnResult == TurnResult.USER_WINS) {
            System.out.println("Congrats! You are the winner!");
        } else if (turnResult == TurnResult.COMPUTER_WINS) {
            System.out.println("Sorry! You've been had...");
        } else if (turnResult == TurnResult.DRAW) {
            System.out.println("Draw game!");
        }
    }

    private static void wagerGameIteration(String name) {
        game.getInitiateGame().initiateGame(game, name);

        game.getGrid().displayGrid();

        TurnResult turnResult = TurnResult.CONTINUE;
        while (turnResult == TurnResult.CONTINUE) {
            // get wagers
            int userWager = game.getPlayers().get(1).getMakeWager().makeWager(
                    game.getPlayers().get(1));

            int computerWager = game.getPlayers().get(2).getMakeWager().makeWager(
                    game.getPlayers().get(2));

            // highest wager takes next turn
            int highestWager = 0;
            if(userWager >= computerWager) {
                System.out.println("You won the wager this round! Your turn.");
                highestWager = 1;
            } else {
                System.out.println("You lost the wager this round. Computer takes this turn");
                highestWager = 2;
            }

            turnResult = game.getNextTurn().nextTurn(highestWager, game);
        }

        if (turnResult == TurnResult.USER_WINS) {
            System.out.println("Congrats! You are the winner!");
        } else if (turnResult == TurnResult.COMPUTER_WINS) {
            System.out.println("Sorry! You've been had...");
        } else if (turnResult == TurnResult.DRAW) {
            System.out.println("Draw game!");
        }
    }
}