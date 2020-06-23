package com.tictactoe.tictactoe;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeGridTest {

    TicTacToeGrid ticTacToeGrid;

    @Before
    public void setUp() throws Exception {
        ticTacToeGrid = new TicTacToeGrid(new TicTacToeEvaluateWin(), new TicTacToeEndInTie());
    }

    @Test
    public void displayGrid() {
        ticTacToeGrid.displayGrid();
    }
}