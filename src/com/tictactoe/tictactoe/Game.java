package com.tictactoe.tictactoe;

import java.util.List;

public class Game {
    private List<Player> players;
    private Grid grid;
    private int turnCount;

    public Game() {
        this.players = players;
        this.grid = grid;
    }

    public void initiateGame() {

    }

    public void nextTurn() {

    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
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
