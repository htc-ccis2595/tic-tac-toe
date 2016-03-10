package edu.htc.tictactoe.stratagem;

import edu.htc.tictactoe.*;

import java.util.Random;

/**
 * Created by Prince Roka on 2/29/2016.
 */
public class RandomMoveStrategy extends TicTacToeStrategy {

    public RandomMoveStrategy(GameBoard board, char playerMarker) {
        super(board, playerMarker);
    }

    public int getBestMove() {
        return getRandomMove();
    }
}