package com.tictactoe.tictactoe.grid;

import java.util.Map;

/**
 * Tic Tac Toe Family that determines when tie condition exists.
 */
public class TicTacToeEndInTie implements EndInTie {
    /**
     * @param grid references Grid.
     * @return tie game when turn count reaches 9.
     */
    @Override
    public boolean endInTie(Grid grid) {
        boolean result = false;
        int tokenCount = 0;
        for(Map.Entry<Integer, String> square : grid.getSquaresFilled().entrySet()) {
            if(!square.getValue().equals(" ")) {
                tokenCount++;
            }
        }
        if(tokenCount == 9) {
            result = true;
        }
        return result;
    }
}