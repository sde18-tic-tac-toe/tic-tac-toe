package com.tictactoe.tictactoe;

import java.util.HashMap;
import java.util.Map;

/**
 * Class Game declares game parameters and behavior.
 */
public class Game {
    private static final int MIN_TURN_COUNT = 0;
    private static final int MAX_TURN_COUNT = 9;

    private final Map<Integer, Player> players;
    private final Grid grid;
    private int turnCount;
    private final InitiateGame initiateGame;
    private final NextTurn nextTurn;


    /**
     * @param grid instantiates Tic Tac Toe grid.
     * @param initiateGame instantiates Tic Tac Toe game.
     * @param nextTurn references ENUM type that declares win/lose/draw.
     */
    public Game(Grid grid, InitiateGame initiateGame,
                NextTurn nextTurn) {
        players = new HashMap<>();
        this.grid = grid;
        this.initiateGame = initiateGame;
        this.nextTurn = nextTurn;
        turnCount = 0;
    }


    /**
     * @return grid and turnCount as defined in the Grid interface.
     */
    public Map<Integer, Player> getPlayers() {
        return players;
    }

    public Grid getGrid() {
        return grid;
    }

    public int getTurnCount() {
        return turnCount;
    }

    /**
     * @param turnCount ENUM parameter # of rounds playable in Tic Tac Toe.
     * @throws TurnCountAssignmentException as described.
     */
    public void setTurnCount(int turnCount) throws TurnCountAssignmentException {
        if(turnCount < MIN_TURN_COUNT || turnCount > MAX_TURN_COUNT) {
            throw new TurnCountAssignmentException("turn count must be greater than " +
                    MIN_TURN_COUNT + " and less than " + MAX_TURN_COUNT);
        }
        this.turnCount = turnCount;
    }

    /**
     * @return returns an instance of Game.
     */
    public InitiateGame getInitiateGame() {
        return initiateGame;
    }

    /**
     * @return sets floor for turn count (0 to 9.)
     */
    public NextTurn getNextTurn() {
        return nextTurn;
    }
}