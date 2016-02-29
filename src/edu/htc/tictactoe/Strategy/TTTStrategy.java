package edu.htc.tictactoe.Strategy;

import java.util.Random;
import edu.htc.tictactoe.GameBoard;
import java.util.ArrayList;
import edu.htc.tictactoe.TicTacToe.*;

/**
 * Created by cheey on 2/23/2016.
 */




public abstract class TTTStrategy {

    GameBoard game;


    public TTTStrategy (GameBoard game)

    {
        this.game = game;
    }

    public abstract int getBestMove();

    Random random = new Random();
    ArrayList<Random> Random;


    protected int getRandomMove()
    {
        Random = new ArrayList<Random>();
        int [] Random = game.getOpenSquares();
        int nextRandom = random.nextInt(Random.length - 1);
        return nextRandom;
    }






}
