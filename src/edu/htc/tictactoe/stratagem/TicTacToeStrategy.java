package edu.htc.tictactoe.stratagem;

import edu.htc.tictactoe.*;

import java.util.*;

/**
 * Created by Prince Roka on 3/1/2016.
 */
public abstract class TicTacToeStrategy {

    GameBoard board;

    public TicTacToeStrategy(GameBoard board) {
        this.board = board;
    }

    public abstract int getBestMove();


    //Random Move Strategy
    private Random rndm = new Random();

    protected int getRandomMove() {
        return board.getOpenSquares()[ rndm.nextInt (board.getOpenSquares().length) ];
    }

//    protected int getRandomMove() {
//        int squaresLeft = board.getOpenSquares().length;
//        return board.getOpenSquares()[rndm.nextInt(squaresLeft)];
//    }

    public static void main(String args[]) {
        int i;
        GameBoard yolo = new GameBoard(new char[]{'X', '2', 'O', '4', 'X', 'O', '7', 'O', 'X'});

        TicTacToeStrategy tac = new TicTacToeStrategy(yolo) {
            @Override
            public int getBestMove() {
                return getRandomMove();
            }
        };

        System.out.println("Showing Gameboard");
        yolo.display();

        System.out.println("Showing bestMove");
        for (i = 0; i < 10; i++) {
            System.out.println(tac.getBestMove());
        }
    }
}
