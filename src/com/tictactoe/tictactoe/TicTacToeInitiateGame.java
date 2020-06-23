package com.tictactoe.tictactoe;

import java.util.Scanner;

public class TicTacToeInitiateGame implements InitiateGameStrategy{

    @Override
    public void initiateGame(Game game) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, player 1! Please enter your name: " );
        String name = scanner.nextLine();
        System.out.println("Welcome to Tic-Tac-Toe, " + name + "! Please select [1]heads or [2]tails to see who goes first!");
        String playerFlip = scanner.nextLine();
        double flipResult = Math.random();
        if (flipResult <= 0.5 && playerFlip.equals("1")) {
            System.out.println("The coin landed heads up! You're first!");
        } else if
        (flipResult > 0.5 && playerFlip.equals("1")) {
            System.out.println("The coin landed tails up... You're going second.");
        } else if
        (flipResult >= 0.5 && playerFlip.equals("2")) {
            System.out.println("The coin landed tails up! You're first!");
        } else if
        (flipResult < 0.5 && playerFlip.equals("2")) {
            System.out.println("The coin landed heads up... You're going second.");
        }
    }
}
