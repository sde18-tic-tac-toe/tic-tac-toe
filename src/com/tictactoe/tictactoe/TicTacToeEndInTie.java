package com.tictactoe.tictactoe;

import java.util.Map;

public class TicTacToeEndInTie implements EndInTieStrategy {
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
