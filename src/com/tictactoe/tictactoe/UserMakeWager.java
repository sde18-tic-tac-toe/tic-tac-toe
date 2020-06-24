package com.tictactoe.tictactoe;

import java.util.Scanner;

public class UserMakeWager implements MakeWager {
    @Override
    public int makeWager(Player player) {
        int wager = 0;
        System.out.print("How many points would you like to wager on this round? ");
        Scanner scanner = new Scanner(System.in);
        wager = scanner.nextInt();
        while(wager < 0 || (player.getWagerPoints() - wager < 0)) {
            StringBuffer sb = new StringBuffer();
            sb.append("You have ").append(player.getWagerPoints()).
                    append(" points remaining. Enter a number less than or equal to ").
                    append(player.getWagerPoints()).append(": ");
            System.out.print(sb);
            wager = scanner.nextInt();
        }
        player.setWagerPoints(player.getWagerPoints() - wager);
        return wager;
    }
}
