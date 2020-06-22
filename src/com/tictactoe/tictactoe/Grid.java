package com.tictactoe.tictactoe;

import java.util.HashMap;
import java.util.Map;

public class Grid {
    private final Map<Integer, String> squaresFilled;
    private final EvaluateWinStrategy evaluateWinStrategy;
    private final EndInTieStrategy endInTieStrategy;

    public Grid(EvaluateWinStrategy evaluateWinStrategy,
                EndInTieStrategy endInTieStrategy) {
        squaresFilled = new HashMap<>() {{
            put(1, "");
            put(2, "");
            put(3, "");
            put(4, "");
            put(5, "");
            put(6, "");
            put(7, "");
            put(8, "");
            put(9, "");
        }};
        this.evaluateWinStrategy = evaluateWinStrategy;
        this.endInTieStrategy = endInTieStrategy;
    }

    public Map<Integer, String> getSquaresFilled() {
        return squaresFilled;
    }

    public EvaluateWinStrategy getEvaluateWinStrategy() {
        return evaluateWinStrategy;
    }

    public EndInTieStrategy getEndInTieStrategy() {
        return endInTieStrategy;
    }
}
