package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;


/**
 * Created by volkg_000 on 3/5/2016.
 */
public class GoForWinStrategy extends BlockWinStrategy {
    public GoForWinStrategy(GameBoard gameboard, char marker) {
        super(gameboard, marker);
    }

    public int getBestMove() {
        return goForWin();
    }

    protected int goForWin() {
        int possiblewin = findWinFor(getMarker());
        findWinFor(getMarker());
        if(possiblewin == 0) {
            return getBlockWinMove();
        }

        else {
            return possiblewin;
        }

    }
}
