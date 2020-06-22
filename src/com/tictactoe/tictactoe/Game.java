package com.tictactoe.tictactoe;

import java.util.List;
import java.util.Map;

public class Game {
    private Map<Integer, Player> players;
    private Grid grid;
    private int turnCount;
    public InitiateGameStrategy initiateGameStrategy;
    public NextTurnStrategy nextTurnStrategy;


    public Game() {
        this.players = players;
        this.grid = grid;
    }


    public Map<Integer, Player> getPlayers() {
        return players;
    }

    public void setPlayers(Map<Integer, Player> players) {
        this.players = players;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public void setTurnCount(int turnCount) {
        this.turnCount = turnCount;
    }
}
