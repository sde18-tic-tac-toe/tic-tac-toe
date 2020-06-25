package com.tictactoe.tictactoe;

import com.tictactoe.tictactoe.player.Player;
import com.tictactoe.tictactoe.player.TicTacToeUserSelectSquare;
import com.tictactoe.tictactoe.player.UserMakeWager;

public class UserMakeWagerTest {

    public static void main(String[] args) {
        Player player = new Player("Chase", "X",
                1, new TicTacToeUserSelectSquare(),
                new UserMakeWager());
        int wager = player.getMakeWager().makeWager(player);
        System.out.println("Wager after test: " + wager);
        System.out.println("New player wager points: " + player.getWagerPoints());
    }
}
