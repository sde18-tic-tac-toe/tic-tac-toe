package com.tictactoe.tictactoe;

import java.util.HashMap;
import java.util.Map;

/**
 * Base Tic Tac Toe grid layer that determines all possible winning combinations.
 */
public class TicTacToeGrid implements Grid {
    public static Map<Integer, Map<Integer, Integer>> winPossibilities = new HashMap<>() {{
        put(1, new HashMap<>() {{
            put(2, 3);
            put(4, 7);
            put(5, 9);
        }});
        put(2, new HashMap<>() {{
            put(1, 3);
            put(5, 8);
        }});
        put(3, new HashMap<>() {{
            put(2, 1);
            put(6, 9);
            put(5, 7);
        }});
        put(4, new HashMap<>() {{
            put(1, 7);
            put(5, 6);
        }});
        put(5, new HashMap<>() {{
            put(2, 8);
            put(4, 6);
            put(1, 9);
            put(3, 7);
        }});
        put(6, new HashMap<>() {{
            put(3, 9);
            put(5, 4);
        }});
        put(7, new HashMap<>() {{
            put(4, 1);
            put(8, 9);
            put(5, 3);
        }});
        put(8, new HashMap<>() {{
            put(7, 9);
            put(5, 2);
        }});
        put(9, new HashMap<>() {{
            put(6, 3);
            put(8, 7);
            put(5, 1);
        }});
    }};

    private final Map<Integer, String> squaresFilled;
    private final EvaluateWin evaluateWin;
    private final EndInTieStrategy endInTieStrategy;

    /**
     * @param evaluateWin implements win parameters for Tic Tac Toe.
     * @param endInTieStrategy implements tie game parameters for Tic Tac Toe.
     */
    public TicTacToeGrid(EvaluateWin evaluateWin,
                         EndInTieStrategy endInTieStrategy) {
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
        this.evaluateWin = evaluateWin;
        this.endInTieStrategy = endInTieStrategy;
    }

    /**
     * @return squares filled implementation for Tic Tac Toe.
     */
    public Map<Integer, String> getSquaresFilled() {
        return squaresFilled;
    }

    /**
     * @return player or computer win implementation for Tic Tac Toe.
     */
    public EvaluateWin getEvaluateWin() {
        return evaluateWin;
    }

    /**
     * @return tie game implementation for Tic Tac Toe.
     */
    public EndInTieStrategy getEndInTieStrategy() {
        return endInTieStrategy;
    }

    /**
     * Prints grid and appends player/computer selection for each turn.
     */
    public void displayGrid() {
        StringBuffer sb = new StringBuffer();
        sb.append("     |     |     \n");
        sb.append("  ").append(getSquaresFilled().get(1)).
                append("  |  ").append(getSquaresFilled().get(2)).
                append("  |  ").append(getSquaresFilled().get(3)).
                append("\n");
        sb.append("_____|_____|_____\n");
        sb.append("     |     |     \n");
        sb.append("  ").append(getSquaresFilled().get(4)).
                append("  |  ").append(getSquaresFilled().get(5)).
                append("  |  ").append(getSquaresFilled().get(6)).
                append("\n");
        sb.append("_____|_____|_____\n");
        sb.append("     |     |     \n");
        sb.append("  ").append(getSquaresFilled().get(7)).
                append("  |  ").append(getSquaresFilled().get(8)).
                append("  |  ").append(getSquaresFilled().get(9)).
                append("\n");
        System.out.println(sb);
    }
}