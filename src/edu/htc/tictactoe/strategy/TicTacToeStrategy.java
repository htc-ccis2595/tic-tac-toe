package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;

import java.util.Random;

/**
 * Created by Owner on 2/28/2016.
 */
public abstract class TicTacToeStrategy {
    protected GameBoard board;
    private Random random = new Random();
    public TicTacToeStrategy(GameBoard board){
        this.board = board;
    }

    public abstract int getBestMove();

    protected int getRandomMove()
    {
        int[] openSquares = board.getOpenSquares();
        if (openSquares.length == 0){
            return 0;
        }
        int randomIndex = random.nextInt(openSquares.length);
        return openSquares[randomIndex];
    }

    public static void main(String[] args){
        testGetRandomMove();
    }

    private static void testGetRandomMove() {
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println("Testing GetRandomMove Method");
        GameBoard board = new GameBoard(new char[]{'X','2','3','X','5','O','7','O','9'});

        //Creates anonymous inner class with dummy getBestMove behavior
        TicTacToeStrategy strategy = new TicTacToeStrategy(board) {
            @Override
            public int getBestMove() {
                return 0;
            }
        };

        //Since result is random, testing multiple times to validate good output
        boolean error = false;
        int numberOfRuns = 50;
        for (int i = 0; i < numberOfRuns; i++){
            int result = strategy.getRandomMove();
            if(result < 1 || result > 9){
                error = true;
                System.out.println("Error! Result " + result + " is out of bounds. Must be between 1 and 9");
            } else if (board.isSquareOpen(result)== false){
                error = true;
                System.out.println("Error! Square " + result + "is not open!");
            }
        }
        if (error == false){
            System.out.println("No bad output was found in " + numberOfRuns + " tries.");
        }
    }
}


