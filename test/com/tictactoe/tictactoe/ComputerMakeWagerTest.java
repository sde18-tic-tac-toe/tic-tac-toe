package com.tictactoe.tictactoe;

public class ComputerMakeWagerTest {

    public static void main(String[] args) {
        Player player = new Player("Chase", "X",
                1, new TicTacToeUserSelectSquare(), new ComputerMakeWager());
        int wager = player.getMakeWager().makeWager(player);
        System.out.println("Wager after test: " + wager);
        System.out.println("New player wager points: " + player.getWagerPoints());
    }
}
