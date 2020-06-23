package com.tictactoe.tictactoe;

import java.util.Map;

public interface GridStrategy {
    public void displayGrid();
    public Map<Integer, String> getSquaresFilled();
    public EvaluateWinStrategy getEvaluateWinStrategy();
    public EndInTieStrategy getEndInTieStrategy();
}
