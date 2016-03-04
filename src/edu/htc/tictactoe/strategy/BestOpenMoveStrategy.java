package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;

/**
 * Created by volkg_000 on 3/1/2016.
 */
public class BestOpenMoveStrategy extends TicTacToeStrategy {
    public BestOpenMoveStrategy(GameBoard gameboard) {
        super(gameboard);
    }

    @Override

    public int getBestMove() {
        return getBestOpenMove();
    }
}


