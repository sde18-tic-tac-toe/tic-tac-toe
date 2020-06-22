package com.tictactoe.tictactoe;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ComputerSelectSquare implements SelectSquareStrategy {
    private Set<Integer> userPossibleMoves;
    private Set<Integer> computerPossibleMoves;

    public ComputerSelectSquare() {
        userPossibleMoves = new HashSet<>();
        userPossibleMoves.add(1);
        userPossibleMoves.add(2);
        userPossibleMoves.add(3);
        userPossibleMoves.add(4);
        userPossibleMoves.add(5);
        userPossibleMoves.add(6);
        userPossibleMoves.add(7);
        userPossibleMoves.add(8);
        userPossibleMoves.add(9);
        computerPossibleMoves = new HashSet<>();

    }

    @Override
    public int selectSquare(Map<Integer, String> squaresFilled) {
        int selection = 0;
        // identify set of possible moves
        for(Map.Entry<Integer, String> squaresFilledRow : squaresFilled.entrySet()) {

        }

        // if move to win possible, make that move

        // identify opponent possible moves

        // block if opponent win eminent

        // select move with best possibility of win


        return selection;
    }
}
