package edu.htc.tictactoe.Strategy;

import edu.htc.tictactoe.GameBoard;

/**
 * Created by Sam on 3/16/2016.
 */
public class GoForWinStrategy extends TicTacToeStrategy {
    private GameBoard randomBoard;
    private char mark;

    public GoForWinStrategy(GameBoard board) {
        super(board);
        GameBoard randomBoard = board;
    }

    @Override
    public int getBestMove(GameBoard randomBoard) {
        int move = goForWin(randomBoard, mark);
        return move;
    }
}
