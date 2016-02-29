package edu.htc.tictactoe.strategy;

import java.util.Random;
import edu.htc.tictactoe.GameBoard;

/**
 * Created by clifford.mauer on 2/8/2016.
 */
public abstract class TicTacToeStrategy {

    //GameBoard board = new GameBoard();

    public static void main(String[] args){
        testGetRandomMove();
    }

    public static void testGetRandomMove(){

        System.out.println();
        System.out.println("----------------------------------------------");
        System.out.println("Testing getRandomMove method");
        GameBoard board = new GameBoard(new char[]{'1','X','3','4','O','6','X','8','O'});

        //Creates anonymous inner class with dummy getBestMove behavior
        TicTacToeStrategy strategy = new TicTacToeStrategy() {
            @Override
            public int getBestMove(GameBoard board, char gameMarker) {
                return 0;
            }
        };

        //Since the result is random, testing multiple times to validate good output

        boolean error = false;
        int numberOfRuns = 50;

        for (int i=0; i<numberOfRuns; i++){

            int result = strategy.getRandomMove(board);
            System.out.println("The random result is " + result);
            if (result < 0 || result > 8){
                error = true;
                System.out.println("Error! Square " + result + " is out of bounds.  Must be between 1 and 9");
            } else if (board.isSquareOpen(result) == false) {
                error = true;
                System.out.println("Error! Square " + result + " is not open!");
            }

        }

        if (error == false){
            System.out.println("Correct.  No bad output was found in " + numberOfRuns + " tries!");

        }
    }



    public abstract int getBestMove(GameBoard board, char gameMarker);



    protected int getRandomMove(GameBoard board){
        boolean blnExit = false;
        Integer randomInt = 0;
        boolean blnIsOpen = false;

        // This method should get the open squares from the game board and
        // select one randomly to return.

        board.getOpenSquares();


        // create a new Java Random object
        Random random = new Random();

        do{
            // get the next random int
            randomInt = random.nextInt(10);
            if (randomInt > 0 && randomInt < 10) {
                blnIsOpen = board.isSquareOpen(randomInt-1);
                }
                 if (blnIsOpen) {
                    blnExit = true;
                } else {
                    blnExit = false;
                }
        } while (!blnExit);

        return randomInt;
    }
}
