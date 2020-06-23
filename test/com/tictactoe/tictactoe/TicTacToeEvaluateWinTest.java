package com.tictactoe.tictactoe;

import static org.junit.Assert.*;

public class TicTacToeEvaluateWinTest {

    Player player;
    EvaluateWinStrategy evaluateWinStrategy;

    @org.junit.Before
    public void setUp() throws Exception {
        player = new Player("Chase", "X", 1, new UserSelectSquare());
        evaluateWinStrategy = new TicTacToeEvaluateWin();
    }

    @org.junit.Test
    public void evaluateWin357() {
        player.getMarkers().add(5);
        assertFalse(evaluateWinStrategy.evaluateWin(player, 5));
        player.getMarkers().add(2);
        assertFalse(evaluateWinStrategy.evaluateWin(player, 2));
        player.getMarkers().add(3);
        assertFalse(evaluateWinStrategy.evaluateWin(player, 3));
        player.getMarkers().add(7);
        assertTrue(evaluateWinStrategy.evaluateWin(player, 7));
    }

    @org.junit.Test
    public void evaluateWin123() {
        player.getMarkers().add(2);
        assertFalse(evaluateWinStrategy.evaluateWin(player, 2));
        player.getMarkers().add(1);
        assertFalse(evaluateWinStrategy.evaluateWin(player, 1));
        player.getMarkers().add(8);
        assertFalse(evaluateWinStrategy.evaluateWin(player, 8));
        player.getMarkers().add(6);
        assertFalse(evaluateWinStrategy.evaluateWin(player, 6));
        player.getMarkers().add(3);
        assertTrue(evaluateWinStrategy.evaluateWin(player, 3));
    }

    @org.junit.Test
    public void evaluateWin147() {
        player.getMarkers().add(2);
        assertFalse(evaluateWinStrategy.evaluateWin(player, 2));
        player.getMarkers().add(1);
        assertFalse(evaluateWinStrategy.evaluateWin(player, 1));
        player.getMarkers().add(7);
        assertFalse(evaluateWinStrategy.evaluateWin(player, 7));
        player.getMarkers().add(6);
        assertFalse(evaluateWinStrategy.evaluateWin(player, 6));
        player.getMarkers().add(4);
        assertTrue(evaluateWinStrategy.evaluateWin(player, 4));
    }
}