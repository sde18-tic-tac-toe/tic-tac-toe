package com.tictactoe.tictactoe;

import java.util.Map;
import java.util.Scanner;

public class UserSelectSquare implements SelectSquareStrategy {
    @Override
    public int selectSquare(Map<Integer, String> squaresFilled) {
        Scanner scan = new Scanner(System.in);
        int userPos = scan.nextInt();
        while (!squaresFilled.get(userPos).equals("")) {
            System.out.println("Position taken! Enter a correct Position");
            userPos = scan.nextInt();
        }
        return userPos;
    }
}
