package com.tictactoe.tictactoe;

import java.util.HashMap;
import java.util.Map;

public class TicTacToeEvaluateWin implements EvaluateWinStrategy{
    @Override
    public boolean evaluateWin(Player player,
                               int lastPlacedToken,
                               Map<Integer, Map<Integer, Integer>> winPossibilities) {
        boolean result = false;
        if(player.getMarkers().size() > 2) {
            Map<Integer, Integer> subMap = winPossibilities.get(lastPlacedToken);
            for(Map.Entry<Integer, Integer> token : subMap.entrySet()) {
                if(player.getMarkers().contains(token.getKey())) {
                    if(player.getMarkers().contains(token.getValue())) {
                        result = true;
                    }
                }
            }
        }
        return result;
    }
}
