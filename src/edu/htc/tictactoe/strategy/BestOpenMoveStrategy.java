package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;

/**
 * Created by Owner on 3/7/2016.
 */
public class BestOpenMoveStrategy extends TicTacToeStrategy {
    public BestOpenMoveStrategy(GameBoard board,char gameMarker, char playerMarker){
        super(board,gameMarker, playerMarker);
    }

    @Override
    public int getBestMove() {
        return getBestOpenMove();
    }
}
