package com.tictactoe.tictactoe.client;

import com.tictactoe.tictactoe.game.Game;
import com.tictactoe.tictactoe.game.TicTacToeInitiateGame;
import com.tictactoe.tictactoe.game.TicTacToeNextTurn;
import com.tictactoe.tictactoe.game.TurnResult;
import com.tictactoe.tictactoe.grid.TicTacToeEndInTie;
import com.tictactoe.tictactoe.grid.TicTacToeEvaluateWin;
import com.tictactoe.tictactoe.grid.TicTacToeGrid;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Main houses main() method and instantiates the game.
 */
public class Main {

    private static Game game;
    private static String name;
    private static Scanner scanner;

    /**
     * main method for the application
     * @param args arguments to the program
     * @throws InterruptedException Exception in case of program interruption
     */
    public static void main(String[] args) throws InterruptedException {

        // read in and display banner
        try {
            BufferedReader in = new BufferedReader(new FileReader("./resources/welcome.txt"));
            String line;
            while((line = in.readLine()) != null)
            {
                System.out.println(line);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // get user name
        scanner = new Scanner(System.in);
        System.out.print("\nWelcome, player 1! Please enter your name: ");
        name = scanner.nextLine();

        // get game selection and start the game
        gameSelection();
    }

    /**
     * Private method to drive selection of game
     */
    private static void gameSelection() {
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
            gameIteration();
        } else {
            game = new Game(new TicTacToeGrid(new TicTacToeEvaluateWin(),
                    new TicTacToeEndInTie()), new TicTacToeInitiateGame(),
                    new TicTacToeNextTurn(), true);
            wagerGameIteration();
        }

        // Determine if user would like to play again
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
            gameSelection();
        }
    }

    /**
     * Private method each tic tac toe without wagering game iteration
     */
    private static void gameIteration() {
        // initiate game and flip a coin to determine which player goes first
        int coinFlipResult = new TicTacToeInitiateGame().initiateGame(game, name);

        game.getGrid().displayGrid();

        // continue game until there is a winner or game ends in tie
        TurnResult turnResult = TurnResult.CONTINUE;
        while (turnResult == TurnResult.CONTINUE) {
            turnResult = game.getNextTurn().nextTurn(coinFlipResult, game);
        }

        // print game result
        System.out.println(getGameResultMessage(turnResult));
    }

    /**
     * Private method for each wagering tic tac toe game iteration
     */
    private static void wagerGameIteration() {
        // initiate game
        game.getInitiateGame().initiateGame(game, name);

        game.getGrid().displayGrid();

        // continue game until a player wins or game ends in draw
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
            // initiate next turn and get turn result
            turnResult = game.getNextTurn().nextTurn(highestWager, game);
        }
        // print game result
        System.out.println(getGameResultMessage(turnResult));
    }

    /**
     * Private method for obtaining game result
     * @param turnResult TurnResult of the last turn of the game
     * @return Message with game outcome
     */
    private static String getGameResultMessage(TurnResult turnResult) {
        String resultMessage;
        if (turnResult == TurnResult.USER_WINS) {
            resultMessage = "Congrats! You are the winner!";
        } else if (turnResult == TurnResult.COMPUTER_WINS) {
            resultMessage = "Sorry! You've been had...";
        } else if (turnResult == TurnResult.DRAW) {
            resultMessage = "Draw game!";
        } else {
            resultMessage = "Inconclusive game conclusion.";
        }
        return resultMessage;
    }
}