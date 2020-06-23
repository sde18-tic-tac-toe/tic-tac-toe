package com.tictactoe.tictactoe;

import java.util.Scanner;

public class Client {

    private static Game game;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, player 1! Please enter your name: ");
        String name = scanner.nextLine();

        game = new Game(new Grid(new TicTacToeEvaluateWin(),
                new TicTacToeEndInTie()), new TicTacToeNextTurn());

        System.out.println("Welcome to Tic-Tac-Toe, " + name + "!");

        System.out.println("Here is the game board... Note that each grid square is represented by a number.\n" +

                "      |     |     \n" +
                "   1  |  2  |  3  \n" +
                " _____|_____|_____\n" +
                "      |     |     \n" +
                "   4  |  5  |  6  \n" +
                " _____|_____|_____\n" +
                "      |     |     \n" +
                "   7  |  8  |  9  \n" +
                "      |     |     \n");

        Thread.sleep(4000);

        System.out.println("The objective of the game is to complete a line of three placements of \"X\". \n" +
                "The game will flip a coin to determine who goes first, and then you will take turns making \n" +
                "placements until either you or the computer wins, or there is a draw (all squares filled without \n" +
                "a winning combo.) To win, you must occupy three consecutive squares in a straight line with an \"X\", \n" +
                "be them top to bottom, left to right, or diagonally across the grid array (or vise versa in all cases.) \n");

        Thread.sleep(10000);

        System.out.println("Here is an example of a winning combination after 5 turns: \n" +

                "      |     |     \n" +
                "   X  |  O  |  O  \n" +
                " _____|_____|_____\n" +
                "      |     |     \n" +
                "   4  |  X  |  O  \n" +
                " _____|_____|_____\n" +
                "      |     |     \n" +
                "   7  |  8  |  X  \n" +
                "      |     |      \n" +
                "As you can see, squares that have not yet been selected are still designated as the \n" +
                "number representative of that grid square. Selections that have been made replace\n" +
                "the number associated with that grid square.");

        Thread.sleep(6000);

        System.out.println("Sound good? Lets play! \n" +
                "Please select [1]heads or [2]tails to see who goes first!");
            String playerFlip = scanner.nextLine();
            double flipResult = Math.random();
            int coinFlipResult = 0;
            if (flipResult <= 0.5 && playerFlip.equals("1")) {
                System.out.println("The coin landed heads up! You're first!");
                coinFlipResult = 1;
            } else if
            (flipResult > 0.5 && playerFlip.equals("1")) {
                System.out.println("The coin landed tails up... You're going second.");
                coinFlipResult = 2;
            } else if
            (flipResult >= 0.5 && playerFlip.equals("2")) {
                System.out.println("The coin landed tails up! You're first!");
                coinFlipResult = 1;
            } else if
            (flipResult < 0.5 && playerFlip.equals("2")) {
                System.out.println("The coin landed heads up... You're going second.");
                coinFlipResult = 2;
            }
        }
    }

