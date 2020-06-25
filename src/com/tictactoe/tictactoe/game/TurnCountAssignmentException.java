package com.tictactoe.tictactoe.game;

/**
 * Exception class generates exception message when turnCount is not
 * within normal limits (0 and 9.)
 */
public class TurnCountAssignmentException extends Exception {
    public TurnCountAssignmentException(String message) {
        super(message);
    }
}