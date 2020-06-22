package com.tictactoe.tictactoe;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private String name;
    private String token;
    private long playerId;
    private Set<Integer> markers;
    private SelectSquareStrategy selectSquareStrategy;

    public Player(String name, String token, long playerId, SelectSquareStrategy selectSquareStrategy) {
        setName(name);
        setToken(token);
        setPlayerId(playerId);
        setSelectSquareStrategy(selectSquareStrategy);
        this.markers = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    private void setToken(String token) {
        this.token = token;
    }

    public long getPlayerId() {
        return playerId;
    }

    private void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public Set<Integer> getMarkers() {
        return markers;
    }

    public SelectSquareStrategy getSelectSquareStrategy() {
        return selectSquareStrategy;
    }

    private void setSelectSquareStrategy(SelectSquareStrategy selectSquareStrategy) {
        this.selectSquareStrategy = selectSquareStrategy;
    }
}
