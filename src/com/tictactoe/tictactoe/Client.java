package com.tictactoe.tictactoe;

import java.util.Scanner;

public class Client {

    private static TicTacToeGame ticTacToeGame;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nWelcome, player 1! Please enter your name: ");
        String name = scanner.nextLine();

        gameIteration(name);
    }

    private static void gameIteration(String name) {
        ticTacToeGame = new TicTacToeGame(new TicTacToeGrid(new TicTacToeEvaluateWin(),
                new TicTacToeEndInTie()), new TicTacToeInitiateGame(),
                new TicTacToeNextTurn());

        ticTacToeGame.getInitiateGame().initiateGame(ticTacToeGame, name);

        ticTacToeGame.getGrid().displayGrid();

        TurnResult turnResult = TurnResult.CONTINUE;
        while (turnResult == TurnResult.CONTINUE) {
            // get wagers
            int userWager = ticTacToeGame.getPlayers().get(1).getMakeWager().makeWager(
                    ticTacToeGame.getPlayers().get(1));

            int computerWager = ticTacToeGame.getPlayers().get(2).getMakeWager().makeWager(
                    ticTacToeGame.getPlayers().get(2));

            // highest wager takes next turn
            int highestWager = 0;
            if(userWager >= computerWager) {
                System.out.println("You won the wager this round! Your turn.");
                highestWager = 1;
            } else {
                System.out.println("You lost the wager this round. Computer takes this turn");
                highestWager = 2;
            }

            turnResult = ticTacToeGame.getNextTurn().nextTurn(highestWager, ticTacToeGame);
        }

        if (turnResult == TurnResult.USER_WINS) {
            System.out.println("Congrats! You are the winner!");
        } else if (turnResult == TurnResult.COMPUTER_WINS) {
            System.out.println("Sorry! You've been had...");
        } else if (turnResult == TurnResult.DRAW) {
            System.out.println("Draw ticTacToeGame!");
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

