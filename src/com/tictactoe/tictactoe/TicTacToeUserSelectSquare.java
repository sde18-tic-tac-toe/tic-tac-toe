package com.tictactoe.tictactoe;

import java.util.Map;
import java.util.Scanner;

/**
 * SelectSquare implementation for Tic Tac Toe user
 */
public class TicTacToeUserSelectSquare implements SelectSquare {
    /**
     * selectSquare method for Tic Tac Toe user
     * @param squaresFilled squaresFilled field from Grid class
     * @return Selected square by the user
     */
    @Override
    public int selectSquare(Map<Integer, String> squaresFilled) {
        System.out.print("Select an open position: ");
        Scanner scan = new Scanner(System.in);
        int userPos = scan.nextInt();
        while (!squaresFilled.get(userPos).equals(" ")) {
            System.out.print("Position taken! Enter a correct position: ");
            userPos = scan.nextInt();
        }
        return userPos;
    }
}