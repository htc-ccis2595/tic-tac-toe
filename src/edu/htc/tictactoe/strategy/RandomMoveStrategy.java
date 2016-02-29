package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;

/**
 * Created by Owner on 2/28/2016.
 */
public class RandomMoveStrategy extends TicTacToeStrategy{

    public RandomMoveStrategy(GameBoard board) {
        super(board);
    }

    @Override
    public int getBestMove() {
        return getRandomMove();
    }
}
