package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;
import java.util.Random;



/**
 * Created by volkg_000 on 2/23/2016.
 */
public abstract class TicTacToeStrategy {
    //instance variables
    private Random rand = new Random();
    private int winCombinations[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9},
            {1, 5, 9}, {3, 6, 9}, {2, 5, 8}, {1, 4, 7}, {3, 5, 7}};
    GameBoard gameboard;


    //constructor
    public TicTacToeStrategy(GameBoard gameboard) {
        this.gameboard = gameboard;


    }



    public abstract int getBestMove();



    protected int getRandomMove() {


        int[] opensquares = this.gameboard.getOpenSquares();

        int randomNum = rand.nextInt(opensquares.length);

        return opensquares[randomNum];
    }

    public static void main(String args []) {
        System.out.println("Testing getRandomMove.");
        GameBoard gameboard = new GameBoard(new char[]{'1','2','3','4','5','6','7','8','9'});
        //creates anonymous inner class with dummy getBestMove behavior
        TicTacToeStrategy strategy = new TicTacToeStrategy(gameboard) {
            @Override
            public int getBestMove() {
                return 0;
            }

        };

        boolean error = false;
        int numberofruns = 50;
        for(int i=0; i < numberofruns; i++) {

            int randomnum = strategy.getRandomMove();
            if(randomnum < 1 || randomnum > 9) {
                error = true;
                System.out.println("Error! Result " + randomnum + " is out of bounds. Must be between 1 and 9");
            }
            else {
                if(gameboard.isSquareOpen(randomnum) == false){
                    error = true;
                    System.out.println("Error! Square " + randomnum + " is not open!");
                }
                }
        }
        if(error==false) {
            System.out.println("Correct! No bad output was found in " + numberofruns + " tries.");
        }
    }

}





