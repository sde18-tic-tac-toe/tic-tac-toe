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

        int turnResult = 0;
        while (turnResult == 0) {
            turnResult = game.getNextTurn().nextTurn(coinFlipResult, game);
        }

        if (turnResult == 1) {
            System.out.println("Congrats! You are the winner!");
        } else if (turnResult == 2) {
            System.out.println("Sorry! You've been had...");
        } else if (turnResult == 3) {
            System.out.println("Draw game!");
        }

        System.out.println("Play again? [y]yes or [n]no");
        Scanner scanner = new Scanner(System.in);
        String playAgain = scanner.nextLine();
        if (playAgain.equals("y")) {
            System.out.println("Restart");
            gameIteration(name);
        }
    }
}

