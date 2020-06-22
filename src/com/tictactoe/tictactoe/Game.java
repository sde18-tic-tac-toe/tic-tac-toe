package com.tictactoe.tictactoe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private final int MIN_TURN_COUNT = 0;
    private final int MAX_TURN_COUNT = 9;

    private final Map<Integer, Player> players;
    private final Grid grid;
    private int turnCount;
    private final InitiateGameStrategy initiateGameStrategy;
    private final NextTurnStrategy nextTurnStrategy;


    public Game(Grid grid, InitiateGameStrategy initiateGameStrategy,
                NextTurnStrategy nextTurnStrategy) {
        players = new HashMap<>();
        this.grid = grid;
        this.initiateGameStrategy = initiateGameStrategy;
        this.nextTurnStrategy = nextTurnStrategy;
        turnCount = 0;
    }


    public Map<Integer, Player> getPlayers() {
        return players;
    }

    public Grid getGrid() {
        return grid;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public void setTurnCount(int turnCount) throws TurnCountAssignmentException {
        if(turnCount < MIN_TURN_COUNT || turnCount > MAX_TURN_COUNT) {
            throw new TurnCountAssignmentException("turn count must be greater than " +
                    MIN_TURN_COUNT + " and less than " + MAX_TURN_COUNT);
        }
        this.turnCount = turnCount;
    }

    public InitiateGameStrategy getInitiateGameStrategy() {
        return initiateGameStrategy;
    }

    public NextTurnStrategy getNextTurnStrategy() {
        return nextTurnStrategy;
    }
}
