package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;
import edu.htc.tictactoe.player.ComputerPlayer;

import java.util.Random;

/**
 * Created by cheey on 3/6/2016.
 */
public class BestOpenMoveStrategy extends RandomMoveStrategy {


    Random randomBestMove = new Random();

    public BestOpenMoveStrategy(GameBoard game)
    {
        super (game);
    }

    @Override
    public int getBestMove() {
        return getBestOpenMove();
    }

    public int getBestOpenMove()

    {
            //an int array with 1,3,7,9 & random
//            int []bestMoveArray = {'1', '3', '5', '7', '9'};
//            int bestMove = randomBestMove.nextInt(bestMoveArray.length);
//            return bestMoveArray[bestMove];

          int bestMove = 0;
        {
            if (game.isSquareOpen(5) == true) {
                bestMove = 5;
            } else if (game.isSquareOpen(1) == true) {
                bestMove = 1;
            } else if (game.isSquareOpen(3) == true) {
                bestMove = 3;
            } else if (game.isSquareOpen(7) == true) {
                bestMove = 7;
            } else if (game.isSquareOpen(9) == true) {
                bestMove = 9;
            }
            else getRandomMove();

            return bestMove;
        }

    }
}
