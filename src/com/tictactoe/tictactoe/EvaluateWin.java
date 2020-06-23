package com.tictactoe.tictactoe;

import java.util.Map;

public interface EvaluateWin {
    public boolean evaluateWin(Player player,
                               int lastPlacedToken);
}
