package edu.htc.tictactoe.Stratagem;

import edu.htc.tictactoe.GameBoard;

import java.util.Random;

/**
 * Created by Prince Roka on 2/29/2016.
 */
public class RandomMove {

    Random randomNumber = new Random();
    public int randomMove = randomNumber.nextInt(9);
}
