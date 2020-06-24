package com.tictactoe.tictactoe;

public interface NextTurn {
    public TurnResult nextTurn(int firstPlayer, Game game);
}
