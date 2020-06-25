package com.tictactoe.tictactoe.game;

import com.tictactoe.tictactoe.game.Game;

/**
 * Main facing InitiateGame interface (Polymorphism.)
 */
public interface InitiateGame {
    /**
     * @param game Reference to the Game.
     * @param name Reference to player name (generated from user input prompt.)
     * @return references ENUM types in Game class to return the status of the
     * game, with possible outcomes bing 0 = no winner and no tie, 1 = firstPlayer
     * wins, 2 = other player (Syntactical computer) wins, and 3 = tie game.
     */
    public int initiateGame(Game game, String name);
}