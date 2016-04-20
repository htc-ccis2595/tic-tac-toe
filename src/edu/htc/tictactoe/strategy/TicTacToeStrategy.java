package edu.htc.tictactoe.strategy;

import java.util.Random;
import edu.htc.tictactoe.GameBoard;
import java.util.ArrayList;

/**
 * Created by cheey on 2/23/2016.
 */




public abstract class TicTacToeStrategy {

    GameBoard game;



    public TicTacToeStrategy(GameBoard game)

    {
        this.game = game;

    }

    public abstract int getBestMove();


}
