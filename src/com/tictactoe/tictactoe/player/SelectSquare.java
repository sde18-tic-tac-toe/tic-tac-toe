package com.tictactoe.tictactoe.player;

import java.util.Map;

/**
 * Client facing SelectSquare implementation (Polymorphism.)
 */
public interface SelectSquare {
    public int selectSquare(Map<Integer, String> squaresFilled);
}