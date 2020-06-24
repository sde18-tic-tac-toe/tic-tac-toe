package com.tictactoe.tictactoe;

import java.util.Map;

public interface Grid {
    public void displayGrid();
    public Map<Integer, String> getSquaresFilled();
    public EvaluateWin getEvaluateWin();
    public EndInTieStrategy getEndInTieStrategy();
}
