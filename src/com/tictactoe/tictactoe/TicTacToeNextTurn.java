package com.tictactoe.tictactoe;

public class TicTacToeNextTurn implements NextTurn {

    /**
     * Tic Tac Toe implementation of nextTurn().
     * @param firstPlayer The player who won the coin toss.
     * @param ticTacToeGame Reference to the TicTacToeGame.
     * @return Possible outcomes: 0 = no winner and no tie,
     * 1 = firstPlayer wins, 2 = other player wins,
     * 3 = ticTacToeGame ends in tie
     */
    @Override
    public TurnResult nextTurn(int firstPlayer, TicTacToeGame ticTacToeGame) {

        int selectedSquare;
        // coin toss player goes first
        selectedSquare = ticTacToeGame.getPlayers().get(firstPlayer).getSelectSquare().
                selectSquare(ticTacToeGame.getGrid().getSquaresFilled());

        // update grid squaresFilled
        ticTacToeGame.getGrid().getSquaresFilled().put(selectedSquare, ticTacToeGame.getPlayers().get(firstPlayer).getToken());

        // update firstPlayer markers
        ticTacToeGame.getPlayers().get(firstPlayer).getMarkers().add(selectedSquare);

        // display board
        ticTacToeGame.getGrid().displayGrid();

        // if we have a winner, return first player
        if(ticTacToeGame.getGrid().getEvaluateWin().evaluateWin(
                ticTacToeGame.getPlayers().get(firstPlayer),
                selectedSquare)) {
            if(ticTacToeGame.getPlayers().get(firstPlayer).getPlayerId() == 1) {
                return TurnResult.USER_WINS;
            } else {
                return TurnResult.COMPUTER_WINS;
            }
        }

        // if we end in tie
        if(ticTacToeGame.getGrid().getEndInTieStrategy().endInTie(ticTacToeGame.getGrid())) {
            return TurnResult.DRAW;
        }

//        // get other player number
//        int otherPlayer;
//        if(firstPlayer == 1) {
//            otherPlayer = 2;
//        } else {
//            otherPlayer = 1;
//        }
//
//        // get otherPlayer selectedSquare
//        selectedSquare = ticTacToeGame.getPlayers().get(otherPlayer).getSelectSquare().
//                selectSquare(ticTacToeGame.getGrid().getSquaresFilled());
//
//        // update grid squaresFilled
//        ticTacToeGame.getGrid().getSquaresFilled().put(selectedSquare, ticTacToeGame.getPlayers().get(otherPlayer).getToken());
//
//        // update firstPlayer markers
//        ticTacToeGame.getPlayers().get(otherPlayer).getMarkers().add(selectedSquare);
//
//        // display board
//        ticTacToeGame.getGrid().displayGrid();
//
//        // if we have a winner, return other player
//        if(ticTacToeGame.getGrid().getEvaluateWin().evaluateWin(
//                ticTacToeGame.getPlayers().get(otherPlayer),
//                selectedSquare)) {
//            if(ticTacToeGame.getPlayers().get(otherPlayer).getPlayerId() == 1) {
//                return TurnResult.USER_WINS;
//            } else {
//                return TurnResult.COMPUTER_WINS;
//            }
//        }
//
//        // if we end in tie
//        if(ticTacToeGame.getGrid().getEndInTieStrategy().endInTie(ticTacToeGame.getGrid())) {
//            return TurnResult.DRAW;
//        }

        return TurnResult.CONTINUE;
    }
}
