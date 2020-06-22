package com.tictactoe.tictactoe;

import java.util.HashMap;
import java.util.Map;

public class TicTacToeNextTurn implements NextTurnStrategy{
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

    @Override
    public void nextTurn() {

    }
}
