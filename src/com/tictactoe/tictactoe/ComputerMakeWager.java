package com.tictactoe.tictactoe;

import java.util.Random;

public class ComputerMakeWager implements MakeWager {
    @Override
    public int makeWager(Player player) {
        int wager = (int) (Math.random() * player.getWagerPoints() * 0.5);
        player.setWagerPoints(player.getWagerPoints() - wager);
        System.out.println("Computer wagers " + wager);
        return wager;
    }
}
