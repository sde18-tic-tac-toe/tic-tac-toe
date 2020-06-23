package com.tictactoe.tictactoe;

public interface NextTurnStrategy {
    public int nextTurn(int firstPlayer, Game game);
}
