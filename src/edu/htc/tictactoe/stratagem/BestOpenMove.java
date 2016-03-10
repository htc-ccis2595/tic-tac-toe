package edu.htc.tictactoe.stratagem;

import edu.htc.tictactoe.GameBoard;

/**
 * Created by Prince Roka on 3/7/2016.
 */
public class BestOpenMove extends TicTacToeStrategy {

    public BestOpenMove(GameBoard board, char playerMarker) {
        super(board, playerMarker);
    }

    public int getBestMove() {
        return getBestOpenMove();
    }
}
