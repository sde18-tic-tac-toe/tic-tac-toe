package com.tictactoe.tictactoe.grid;

import com.tictactoe.tictactoe.grid.Grid;

/**
 * Client facing. Implements rules for ending in a tie game in Tic Tac Toe.
 */
public interface EndInTie {
    /**
     * @param grid references Grid.
     * @return Statement declaring game outcome ended in a tie, in accordance with
     * Game class.
     */
    public boolean endInTie(Grid grid);
}