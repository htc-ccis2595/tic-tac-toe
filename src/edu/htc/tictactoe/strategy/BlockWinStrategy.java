package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;

/**
 * Created by Owner on 3/21/2016.
 */
public class BlockWinStrategy extends TicTacToeStrategy {
    public BlockWinStrategy(GameBoard board,char gameMarker, char playerMarker) {
        super(board, gameMarker, playerMarker);
    }


    @Override
    public int getBestMove() {
        return getBlockWinMove();
    }
}
