package com.tictactoe.tictactoe;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ComputerSelectSquare implements SelectSquare {
    private Set<Integer> possibleMoves;
    private Set<Integer> userMoves;
    private Set<Integer> computerMoves;

    public ComputerSelectSquare() {
        possibleMoves = new HashSet<>();
        possibleMoves.add(1);
        possibleMoves.add(2);
        possibleMoves.add(3);
        possibleMoves.add(4);
        possibleMoves.add(5);
        possibleMoves.add(6);
        possibleMoves.add(7);
        possibleMoves.add(8);
        possibleMoves.add(9);
        userMoves = new HashSet<>();
        computerMoves = new HashSet<>();
    }

    @Override
    public int selectSquare(Map<Integer, String> squaresFilled) {
        // identify set of possible moves
        for(Map.Entry<Integer, String> squaresFilledRow : squaresFilled.entrySet()) {
            int square = squaresFilledRow.getKey();
            String token = squaresFilledRow.getValue();
            if(token != " ") {
                possibleMoves.remove(square);
                if(token.equals("X")) {
                    userMoves.add(square);
                } else {
                    computerMoves.add(square);
                }
            }
        }

        // if move to win or block opponent win possible, move there
        int winMove = winOrBlockMove();
        if(winMove != 0) {
            return winMove;
        }
        // otherwise, return best possible move
        else return bestPossibleMove();
    }

    private int winOrBlockMove() {
        for(Map.Entry<Integer, Map<Integer, Integer>> possibilityKey :
                TicTacToeGrid.winPossibilities.entrySet()) {
            if(computerMoves.contains(possibilityKey.getKey())) {
                for(Map.Entry<Integer, Integer> possibilityVal :
                        possibilityKey.getValue().entrySet()) {
                    if(computerMoves.contains(possibilityVal.getKey()) &&
                        possibleMoves.contains(possibilityVal.getValue())) {
                        return possibilityVal.getValue();
                    } else if(computerMoves.contains(possibilityVal.getValue()) &&
                        possibleMoves.contains(possibilityVal.getKey())) {
                        return possibilityVal.getKey();
                    }
                }
            }
        }
        for(Map.Entry<Integer, Map<Integer, Integer>> possibilityKey :
                TicTacToeGrid.winPossibilities.entrySet()) {
            if(userMoves.contains(possibilityKey.getKey())) {
                for(Map.Entry<Integer, Integer> possibilityVal :
                        possibilityKey.getValue().entrySet()) {
                    if(userMoves.contains(possibilityVal.getKey()) &&
                        possibleMoves.contains(possibilityVal.getValue())) {
                        return possibilityVal.getValue();
                    } else if(userMoves.contains(possibilityVal.getValue()) &&
                        possibleMoves.contains(possibilityVal.getKey())) {
                        return possibilityVal.getKey();
                    }
                }
            }
        }
        return 0;
    }

    private int bestPossibleMove() {
        // if two squares are open in line with currently selected square, select the first
        // one found
        for(int possibleMove : computerMoves) {
            Map<Integer, Integer> possibilities = TicTacToeGrid.winPossibilities.get(possibleMove);
            for(Map.Entry<Integer, Integer> possibility : possibilities.entrySet()) {
                if(possibleMoves.contains(possibility.getKey()) &&
                    possibleMoves.contains(possibility.getValue())) {
                    return possibility.getKey();
                }
            }
        }
        // if no two squares in line available, select next possible move
        Iterator<Integer> nextPossibility = possibleMoves.iterator();
        return nextPossibility.next();
    }
}
