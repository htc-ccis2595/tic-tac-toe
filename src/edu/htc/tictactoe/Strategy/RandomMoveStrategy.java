package edu.htc.tictactoe.Strategy;

import edu.htc.tictactoe.GameBoard;

/**
 * Created by Sam on 3/16/2016.
 */
public class RandomMoveStrategy extends TicTacToeStrategy {
    private GameBoard randomBoard;

    public RandomMoveStrategy(GameBoard board) {
        super(board);
        GameBoard randomBoard = board;
    }

    @Override
    public int getBestMove(GameBoard randomBoard) {
        int move = getRandomMove(randomBoard);
        return move;
    }



}
