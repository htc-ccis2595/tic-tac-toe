package edu.htc.tictactoe.strategy;


import edu.htc.tictactoe.GameBoard;

/**
 * Created by Manimal on 2/29/2016.
 */
public class RandomMoveStrategy extends TicTacToeStrategy {
   private GameBoard board;

    public RandomMoveStrategy(GameBoard board){
        super(board);
    }

}
