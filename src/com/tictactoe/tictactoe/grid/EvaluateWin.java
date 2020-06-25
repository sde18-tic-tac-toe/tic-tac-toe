package com.tictactoe.tictactoe.grid;

import com.tictactoe.tictactoe.player.Player;

/**
 * Provides client interface to evaluate win condition based on the game that is
 * instantiated (Tic Tac Toe, or Checkers, for instance (not implemented.))
 */
public interface EvaluateWin {
    /**
     * @param player references Player.
     * @param lastPlacedToken checks placement of last token against win/loss/draw conclusions.
     * @return value to determine if player has won.
     */
    public boolean evaluateWin(Player player,
                               int lastPlacedToken);
}