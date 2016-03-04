package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;


/**
 * Created by volkg_000 on 3/3/2016.
 */
public class BlockWinStrategy extends TicTacToeStrategy {
    private int winCombinations[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9},
            {1, 5, 9}, {3, 6, 9}, {2, 5, 8}, {1, 4, 7}, {3, 5, 7}};
    private char marker;
    public BlockWinStrategy(GameBoard gameboard) {
        super(gameboard);
    }

    public int getBestMove() {
        return getBlockWinMove();
    }
}
