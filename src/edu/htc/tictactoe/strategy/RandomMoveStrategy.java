package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;

/**
 * Created by volkg_000 on 2/23/2016.
 */
public class RandomMoveStrategy extends TicTacToeStrategy {
    public RandomMoveStrategy(GameBoard gameboard) {
        super(gameboard);
    }

    @Override

    public int getBestMove() {
        return getRandomMove();
    }
}
