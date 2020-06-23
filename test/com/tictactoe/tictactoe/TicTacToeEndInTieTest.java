package com.tictactoe.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeEndInTieTest {

    TicTacToeGrid ticTacToeGrid;

    @Before
    public void setUp() throws Exception {
        ticTacToeGrid = new TicTacToeGrid(new TicTacToeEvaluateWin(), new TicTacToeEndInTie());
    }

    @Test
    public void endInTie() {
        ticTacToeGrid.getSquaresFilled().put(1, "X");
        assertFalse(ticTacToeGrid.getEndInTieStrategy().endInTie(ticTacToeGrid));
        ticTacToeGrid.getSquaresFilled().put(2, "O");
        assertFalse(ticTacToeGrid.getEndInTieStrategy().endInTie(ticTacToeGrid));
        ticTacToeGrid.getSquaresFilled().put(3, "X");
        assertFalse(ticTacToeGrid.getEndInTieStrategy().endInTie(ticTacToeGrid));
        ticTacToeGrid.getSquaresFilled().put(4, "X");
        assertFalse(ticTacToeGrid.getEndInTieStrategy().endInTie(ticTacToeGrid));
        ticTacToeGrid.getSquaresFilled().put(5, "O");
        assertFalse(ticTacToeGrid.getEndInTieStrategy().endInTie(ticTacToeGrid));
        ticTacToeGrid.getSquaresFilled().put(6, "X");
        assertFalse(ticTacToeGrid.getEndInTieStrategy().endInTie(ticTacToeGrid));
        ticTacToeGrid.getSquaresFilled().put(7, "O");
        assertFalse(ticTacToeGrid.getEndInTieStrategy().endInTie(ticTacToeGrid));
        ticTacToeGrid.getSquaresFilled().put(8, "X");
        assertFalse(ticTacToeGrid.getEndInTieStrategy().endInTie(ticTacToeGrid));
        ticTacToeGrid.getSquaresFilled().put(9, "O");
        assertTrue(ticTacToeGrid.getEndInTieStrategy().endInTie(ticTacToeGrid));
    }
}