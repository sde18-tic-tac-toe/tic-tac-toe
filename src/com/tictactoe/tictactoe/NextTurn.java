package com.tictactoe.tictactoe;

public interface NextTurn {
    /**
     * Client facing NextTurn implementation (Polymorphism.)
     * @param firstPlayer The player who won the coin toss.
     * @param game Reference to the Game.
     * @return Possible outcomes: 0 = no winner and no tie,
     * 1 = firstPlayer wins, 2 = other player wins,
     * 3 = game ends in tie
     */
    public TurnResult nextTurn(int firstPlayer, Game game);
}