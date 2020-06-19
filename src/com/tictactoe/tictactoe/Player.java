package com.tictactoe.tictactoe;

import java.util.Set;

public class Player {
    private String name;
    private String token;
    private long playerId;
    private Set<Integer> markers;
    private SelectSquareStrategy selectSquareStrategy;

    public Player(String name, String token, long playerId) {
        this.name = name;
        this.token = token;
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public Set<Integer> getMarkers() {
        return markers;
    }

    public void setMarkers(Set<Integer> markers) {
        this.markers = markers;
    }

    public SelectSquareStrategy getSelectSquareStrategy() {
        return selectSquareStrategy;
    }

    public void setSelectSquareStrategy(SelectSquareStrategy selectSquareStrategy) {
        this.selectSquareStrategy = selectSquareStrategy;
    }
}
