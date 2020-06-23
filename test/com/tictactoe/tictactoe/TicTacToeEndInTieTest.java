package com.tictactoe.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeEndInTieTest {

    Grid grid;

    @Before
    public void setUp() throws Exception {
        grid = new Grid(new TicTacToeEvaluateWin(), new TicTacToeEndInTie());
    }

    @Test
    public void endInTie() {
        grid.getSquaresFilled().put(1, "X");
        assertFalse(grid.getEndInTieStrategy().endInTie(grid));
        grid.getSquaresFilled().put(2, "O");
        assertFalse(grid.getEndInTieStrategy().endInTie(grid));
        grid.getSquaresFilled().put(3, "X");
        assertFalse(grid.getEndInTieStrategy().endInTie(grid));
        grid.getSquaresFilled().put(4, "X");
        assertFalse(grid.getEndInTieStrategy().endInTie(grid));
        grid.getSquaresFilled().put(5, "O");
        assertFalse(grid.getEndInTieStrategy().endInTie(grid));
        grid.getSquaresFilled().put(6, "X");
        assertFalse(grid.getEndInTieStrategy().endInTie(grid));
        grid.getSquaresFilled().put(7, "O");
        assertFalse(grid.getEndInTieStrategy().endInTie(grid));
        grid.getSquaresFilled().put(8, "X");
        assertFalse(grid.getEndInTieStrategy().endInTie(grid));
        grid.getSquaresFilled().put(9, "O");
        assertTrue(grid.getEndInTieStrategy().endInTie(grid));
    }
}