package com.tictactoe.tictactoe;

import java.util.Map;

public interface SelectSquareStrategy {
    public int selectSquare(Map<Integer, String> squaresFilled);
}
