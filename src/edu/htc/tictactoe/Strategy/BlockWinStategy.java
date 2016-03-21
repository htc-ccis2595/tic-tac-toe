package edu.htc.tictactoe.Strategy;

import edu.htc.tictactoe.GameBoard;

/**
 * Created by Sam on 3/16/2016.
 */
public class BlockWinStategy extends TicTacToeStrategy {
    private GameBoard BWboard;

    public BlockWinStategy(GameBoard board) {
        super(board);
        BWboard = board;
    }

    @Override
    public int getBestMove(GameBoard BWboard) {
        int move = getBlockWinMove(BWboard);
        return move;
    }
}
