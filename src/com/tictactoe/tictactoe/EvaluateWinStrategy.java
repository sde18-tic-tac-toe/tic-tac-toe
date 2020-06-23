package com.tictactoe.tictactoe;

import java.util.Map;

public interface EvaluateWinStrategy {
    public boolean evaluateWin(Player player,
                               int lastPlacedToken);
}
