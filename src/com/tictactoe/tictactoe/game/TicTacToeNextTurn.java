package com.tictactoe.tictactoe.game;

public class TicTacToeNextTurn implements NextTurn {

    /**
     * Tic Tac Toe implementation of nextTurn().
     * @param firstPlayer The player who won the coin toss.
     * @param game Reference to the Game.
     * @return Possible outcomes: CONTINUE = no winner and no tie,
     * USER_WINS = firstPlayer wins, COMPUTER_WINS = other player wins,
     * DRAW = game ends in tie
     */
    @Override
    public TurnResult nextTurn(int firstPlayer, Game game) {

        if(!game.isWagerGame()) {
            TurnResult result = TurnResult.CONTINUE;
            result = playerTurn(firstPlayer, game);
            if(result != TurnResult.CONTINUE) {
                return result;
            }
            int otherPlayer;
            if(firstPlayer == 1) {
                otherPlayer = 2;
            } else {
                otherPlayer = 1;
            }
            return playerTurn(otherPlayer, game);
        } else {
            return playerTurn(firstPlayer, game);
        }
    }

    private TurnResult playerTurn(int player, Game game) {

        // get player selectedSquare
        int selectedSquare = game.getPlayers().get(player).getSelectSquare().
                selectSquare(game.getGrid().getSquaresFilled());

        // update grid squaresFilled
        game.getGrid().getSquaresFilled().put(selectedSquare, game.getPlayers().get(player).getToken());

        // update player markers
        game.getPlayers().get(player).getMarkers().add(selectedSquare);

        // display board
        game.getGrid().displayGrid();

        // if we have a winner, return result
        if(game.getGrid().getEvaluateWin().evaluateWin(
                game.getPlayers().get(player),
                selectedSquare)) {

            if(game.getPlayers().get(player).getPlayerId() == 1) {
                return TurnResult.USER_WINS;
            } else {
                return TurnResult.COMPUTER_WINS;
            }
        }

        // if we end in tie
        if(game.getGrid().getEndInTie().endInTie(game.getGrid())) {
            return TurnResult.DRAW;
        }

        return TurnResult.CONTINUE;
    }
}