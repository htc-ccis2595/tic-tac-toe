package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.player.ComputerPlayer;
import edu.htc.tictactoe.GameBoard;

import java.util.Random;

/**
 * Created by cheey on 2/29/2016.
 */
    public class RandomMoveStrategy extends TicTacToeStrategy {

    Random randNum = new Random();


    public RandomMoveStrategy(GameBoard game)
    {
        super (game);

    }

    public int getBestMove(){
        return getRandomMove();
    }

    public int getRandomMove()
    {
        int[] randomSquare = game.getOpenSquares();
        int getRandomMove = randNum.nextInt(randomSquare.length);
        return randomSquare[getRandomMove];
    }


    }







