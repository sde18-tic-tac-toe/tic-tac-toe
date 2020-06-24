package com.tictactoe.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class TicTacToeComputerSelectSquareTest {

    Map<Integer, String> squaresFilled;
    Player computer;

    @Before
    public void setUp() throws Exception {
        squaresFilled = new HashMap<>() {{
            put(1, " ");
            put(2, " ");
            put(3, " ");
            put(4, " ");
            put(5, " ");
            put(6, " ");
            put(7, " ");
            put(8, " ");
            put(9, " ");
        }};
        computer = new Player("TicTac", "O", 2,
                new TicTacToeComputerSelectSquare());
    }

    @Test
    public void testSelectSquareWinningMove1() {
        squaresFilled.put(1, "O");
        squaresFilled.put(3, "O");
        squaresFilled.put(4, "X");
        squaresFilled.put(5, "x");
        assertEquals(2,
            computer.getSelectSquare().selectSquare(squaresFilled));
    }

    @Test
    public void testSelectSquareWinningMove2() {
        squaresFilled.put(1, "O");
        squaresFilled.put(3, "X");
        squaresFilled.put(4, "O");
        squaresFilled.put(6, "X");
        assertEquals(7,
            computer.getSelectSquare().selectSquare(squaresFilled));
    }

    @Test
    public void testSelectSquareBlock1() {
        squaresFilled.put(1, "O");
        squaresFilled.put(3, "X");
        squaresFilled.put(6, "X");
        assertEquals(9,
                computer.getSelectSquare().selectSquare(squaresFilled));
    }

    @Test
    public void testSelectSquareBlock2() {
        squaresFilled.put(1, "O");
        squaresFilled.put(2, "X");
        squaresFilled.put(3, "O");
        squaresFilled.put(4, "X");
        squaresFilled.put(6, "X");
        squaresFilled.put(8, "O");
        assertEquals(5,
                computer.getSelectSquare().selectSquare(squaresFilled));
    }

    @Test
    public void testSelectSquareBestSelectionMostlyFilled() {
        squaresFilled.put(1, "O");
        squaresFilled.put(4, "X");
        squaresFilled.put(5, "X");
        squaresFilled.put(6, "O");
        squaresFilled.put(7, "O");
        squaresFilled.put(8, "O");
        squaresFilled.put(9, "X");
        int squareSelected = computer.getSelectSquare().selectSquare(squaresFilled);
        System.out.println("squareSelected: " + squareSelected);
        assertTrue(squareSelected == 2 || squareSelected == 3);
    }

    @Test
    public void testSelectSquareBestSelectionEmpty() {
        int squareSelected = computer.getSelectSquare().selectSquare(squaresFilled);
        System.out.println("squareSelected: " + squareSelected);
//        assertTrue(squareSelected == 2 || squareSelected == 3);
    }
}