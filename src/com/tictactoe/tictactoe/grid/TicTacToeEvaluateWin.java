package com.tictactoe.tictactoe.grid;

import com.tictactoe.tictactoe.player.Player;

import java.util.Map;

/**
 * Tic Tac Toe Family that determines, if there is a winner, who won Tic Tac Toe game.
 */
public class TicTacToeEvaluateWin implements EvaluateWin {
    /**
     * @param player          references Player.
     * @param lastPlacedToken checks placement of last token against win/loss/draw conclusions.
     * @return false until evaluation parameters herein for win are met, where result is true.
     */
    @Override
    public boolean evaluateWin(Player player,
                               int lastPlacedToken) {

        boolean result = false;
        if(player.getMarkers().size() > 2) {
            Map<Integer, Integer> subMap = TicTacToeGrid.winPossibilities.get(lastPlacedToken);
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