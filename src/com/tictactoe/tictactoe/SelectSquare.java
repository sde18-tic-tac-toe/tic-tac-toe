package com.tictactoe.tictactoe;

import java.util.Map;

/**
 * Client facing SelectSquare implementation (Polymorphism.)
 */
public interface SelectSquare {
    public int selectSquare(Map<Integer, String> squaresFilled);
}