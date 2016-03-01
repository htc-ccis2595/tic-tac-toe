package edu.htc.tictactoe.strategy;


import edu.htc.tictactoe.GameBoard;

import java.util.Random;

/**
 * Created by Manimal on 2/28/2016.
 */

public abstract class TicTacToeStrategy {
    private Random random=new Random();
    private GameBoard board;

    public TicTacToeStrategy(GameBoard board){
        this.board = board;
    }

    


    public int getRandomMove() {
        int array[] = board.getOpenSquares();
        int position = random.nextInt(array.length);
        return array[position];
    }



}
