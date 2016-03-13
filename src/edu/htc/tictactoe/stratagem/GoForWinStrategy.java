package edu.htc.tictactoe.stratagem;

import edu.htc.tictactoe.GameBoard;

/**
 * Created by Prince Roka on 3/9/2016.
 */
public class GoForWinStrategy extends TicTacToeStrategy {

    public GoForWinStrategy(GameBoard board, char playerMarker) {
        super(board, playerMarker);
    }

    public int getBestMove() {
        return getGoForWinStrategy();
    }
}
