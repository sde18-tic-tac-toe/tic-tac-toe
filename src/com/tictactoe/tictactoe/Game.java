package com.tictactoe.tictactoe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
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

    public void setTurnCount(int turnCount) {
        this.turnCount = turnCount;
    }

    public InitiateGameStrategy getInitiateGameStrategy() {
        return initiateGameStrategy;
    }

    public NextTurnStrategy getNextTurnStrategy() {
        return nextTurnStrategy;
    }
}
