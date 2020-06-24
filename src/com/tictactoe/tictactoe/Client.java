package com.tictactoe.tictactoe;

import java.util.Scanner;

public class Client {

    private static Game game;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nWelcome, player 1! Please enter your name: ");
        String name = scanner.nextLine();

        gameIteration(name);
    }

    private static void gameIteration(String name) {
        game = new Game(new TicTacToeGrid(new TicTacToeEvaluateWin(),
                new TicTacToeEndInTie()), new TicTacToeInitiateGame(),
                new TicTacToeNextTurn());

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

        System.out.print("Play again? [y]es or [n]o: ");
        Scanner scanner = new Scanner(System.in);
        String playAgain = scanner.nextLine();
        while(!playAgain.toLowerCase().equals("y") && !playAgain.toLowerCase().equals("n") &&
              !playAgain.toLowerCase().equals("yes") && !playAgain.toLowerCase().equals("no")) {
            System.out.print("Invalid selection. Please enter [y]es or [n]o: ");
            playAgain = scanner.nextLine();
        }

        if (playAgain.toLowerCase().equals("y")) {
            System.out.println();
            gameIteration(name);
        }
    }
}

