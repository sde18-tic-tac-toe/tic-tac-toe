package com.tictactoe.tictactoe;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private String name;
    private String token;
    private long playerId;
    private Set<Integer> markers;
    private SelectSquare selectSquare;

    public Player(String name, String token, long playerId, SelectSquare selectSquare) {
        setName(name);
        setToken(token);
        setPlayerId(playerId);
        setSelectSquare(selectSquare);
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

    public SelectSquare getSelectSquare() {
        return selectSquare;
    }

    private void setSelectSquare(SelectSquare selectSquare) {
        this.selectSquare = selectSquare;
    }
}
