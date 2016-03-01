package edu.htc.tictactoe.strategy;


import edu.htc.tictactoe.GameBoard;

import java.util.Random;

/**
 * Created by Manimal on 2/28/2016.
 */

public class TicTacToeStrategy {
    private Random random=new Random();
    private GameBoard board;


    public Random getRandomMove(){
        board.getOpenSquares()=random.nextInt(9)+1;
    }




}
