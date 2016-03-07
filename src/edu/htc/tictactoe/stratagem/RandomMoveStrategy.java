package edu.htc.tictactoe.stratagem;

import edu.htc.tictactoe.*;

import java.util.Random;

/**
 * Created by Prince Roka on 2/29/2016.
 */
public class RandomMoveStrategy extends TicTacToeStrategy {

    GameBoard board;

    public RandomMoveStrategy(GameBoard board) {
        super(board);
    }

    public int getBestMove() {
        return getRandomMove();
    }

    public static void main(String args[]) {

        GameBoard board = new GameBoard();
        RandomMoveStrategy strategy = new RandomMoveStrategy(board);

        System.out.println("Testing getRandomNum");
        System.out.println(strategy.getBestMove());

    }
}