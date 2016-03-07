package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;

import java.util.Random;

/**
 * Created by cheey on 3/6/2016.
 */
public class BestOpenMoveStrategy extends TicTacToeStrategy {
    Random randomBestMove = new Random();

    public BestOpenMoveStrategy(GameBoard game)
    {
        super (game);
    }

    @Override
    public int getBestMove() {
        return getBestOpenMove();
    }

    public int getBestOpenMove() //try an int array with 1,3,7,9 & random
    {
        int bestMove = 5;
        int bestMoveArray[] = {'1', '3', '7', '9'};


//            int[] bestMoveArray = {'1', '3', '7', '9'};
//            int bestMove = ranNum.nextInt(bestMoveArray.length);
//            return bestMove[bestMoveArray];


        if (game.isSquareOpen(5) == true){
             bestMove = bestMove;}
        else if(game.isSquareOpen(1) == true){
            bestMove = bestMove;}
        else if (game.isSquareOpen(3) == true){
            bestMove = bestMove;}
        else if (game.isSquareOpen(7) == true){
            bestMove = bestMove;}
        else if (game.isSquareOpen(9) == true){
            bestMove = bestMove;}
        return bestMove;
    }
}
