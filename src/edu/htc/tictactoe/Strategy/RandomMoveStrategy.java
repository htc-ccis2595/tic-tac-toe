package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by cheey on 2/29/2016.
 */
    public class RandomMoveStrategy extends TTTStrategy {

    Random random = new Random();

    public RandomMoveStrategy(GameBoard game)
    {
        super (game);

    }

    public int getBestMove(){
        return 0;
    }

    public  int getRandomMove(){



        ArrayList<Random> Random  = new ArrayList<Random>();
        int[] randomSquare = game.getOpenSquares();

        int getRandomMove = random.nextInt(randomSquare.length + 1);
        return getRandomMove;
    }
}






