package com.tictactoe.tictactoe;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ComputerMakeWager implements MakeWager {
    @Override
    public int makeWager(Player player) {
        int wager = ThreadLocalRandom.current().nextInt((int) (player.getWagerPoints() * 0.25),
                (int) (player.getWagerPoints() * 0.6) + 1);
        player.setWagerPoints(player.getWagerPoints() - wager);
        System.out.println("Computer wagers " + wager);
        return wager;
    }
}
