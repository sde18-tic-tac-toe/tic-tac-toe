package com.tictactoe.tictactoe;

public class TicTacToeNextTurn implements NextTurn {

    /**
     * Tic Tac Toe implementation of nextTurn().
     * @param firstPlayer The player who won the coin toss.
     * @param game Reference to the Game.
     * @return Possible outcomes: 0 = no winner and no tie,
     * 1 = firstPlayer wins, 2 = other player wins,
     * 3 = game ends in tie
     */
    @Override
    public int nextTurn(int firstPlayer, Game game) {

        int selectedSquare;
        // coin toss player goes first
        selectedSquare = game.getPlayers().get(firstPlayer).getSelectSquare().
                selectSquare(game.getGrid().getSquaresFilled());

        // update grid squaresFilled
        game.getGrid().getSquaresFilled().put(selectedSquare, game.getPlayers().get(firstPlayer).getToken());

        // update firstPlayer markers
        game.getPlayers().get(firstPlayer).getMarkers().add(selectedSquare);

        // display board
        game.getGrid().displayGrid();

        // if we have a winner, return first player
        if(game.getGrid().getEvaluateWin().evaluateWin(
                game.getPlayers().get(firstPlayer),
                selectedSquare)) {
            return firstPlayer;
        }

        // if we end in tie
        if(game.getGrid().getEndInTieStrategy().endInTie(game.getGrid())) {
            return 3;
        }

        // get other player number
        int otherPlayer;
        if(firstPlayer == 1) {
            otherPlayer = 2;
        } else {
            otherPlayer = 1;
        }

        // get otherPlayer selectedSquare
        selectedSquare = game.getPlayers().get(otherPlayer).getSelectSquare().
                selectSquare(game.getGrid().getSquaresFilled());

        // update grid squaresFilled
        game.getGrid().getSquaresFilled().put(selectedSquare, game.getPlayers().get(otherPlayer).getToken());

        // update firstPlayer markers
        game.getPlayers().get(otherPlayer).getMarkers().add(selectedSquare);

        // display board
        game.getGrid().displayGrid();

        // if we have a winner, return first player
        if(game.getGrid().getEvaluateWin().evaluateWin(
                game.getPlayers().get(otherPlayer),
                selectedSquare)) {
            return otherPlayer;
        }

        // if we end in tie
        if(game.getGrid().getEndInTieStrategy().endInTie(game.getGrid())) {
            return 3;
        }

        return 0;
    }
}
