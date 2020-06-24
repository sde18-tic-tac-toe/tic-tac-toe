package com.tictactoe.tictactoe;

import java.util.Map;

/**
 * Grid interface, layers Grid for client facing interaction.
 */
public interface Grid {
    public void displayGrid();
    public Map<Integer, String> getSquaresFilled();
    public EvaluateWin getEvaluateWin();
    public EndInTieStrategy getEndInTieStrategy();
}