package com.tictactoe.tictactoe;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private static final int MIN_TURN_COUNT = 0;
    private static final int MAX_TURN_COUNT = 9;

    private final Map<Integer, Player> players;
    private final Grid grid;
    private int turnCount;
    private final InitiateGame initiateGame;
    private final NextTurn nextTurn;


    public Game(Grid grid, InitiateGame initiateGame,
                NextTurn nextTurn) {
        players = new HashMap<>();
        this.grid = grid;
        this.initiateGame = initiateGame;
        this.nextTurn = nextTurn;
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

    public InitiateGame getInitiateGame() {
        return initiateGame;
    }

    public NextTurn getNextTurn() {
        return nextTurn;
    }
}
