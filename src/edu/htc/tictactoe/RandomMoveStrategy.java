package edu.htc.tictactoe;
import java.util.Random;

/**
 * Created by Gyan on 3/17/2016.
 */
public class RandomMoveStrategy extends TicTacToeStrategy {

    public RandomMoveStrategy(GameBoard board){
        super(board);
    }

    @Override
    public int getBestMove(){
        return getRandomMove();
    }

}
