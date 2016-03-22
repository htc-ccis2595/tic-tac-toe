package edu.htc.tictactoe;
import java.util.Random;

/**
 * Created by Gyan on 2/21/2016.
 */
public abstract class TicTacToeStrategy {

    private GameBoard board;
    private Random random = new Random();
    public TicTacToeStrategy(GameBoard board){
        this.board=board;
    }

    public abstract int getBestMove();

    public int getRandomMove(){
        int[] openSquares = board.getOpenSquares();
        if(openSquares.length == 0){
            return 0;
        }

        int randomIndex = random.nextInt(openSquares.length);
        return openSquares[randomIndex];
    }

    public static void main(String[] args){
        testGetRandomMove();
    }

    private static void testGetRandomMove(){
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("Testing getRandomMoveMethod");
        GameBoard board = new GameBoard(new char[]{'1','X','3','4','O','6','X','8','O'});

        //Creates anonymous inner class with dummy getBestMove behaviour
        TicTacToeStrategy strategy = new TicTacToeStrategy(board) {
            @Override
            public int getBestMove() {
                return 0;
            }
        };

        //Since result is randon, testing testing multiple times to validate good output
        boolean error = false;
        int numberOfRuns = 50;
        for(int i=0; i<numberOfRuns; i++) {
            int result = strategy.getRandomMove();
            if (result < 1 || result > 9) {
                error = true;
                System.out.println("Error! Result " + result + " is out of bounds. Must be between 1 and 9");
            } else if (board.isSquareOpen(result) == false) {
                error = true;
                System.out.println("Error! Square " + result + " is not open!");
            }
        }
        if(error == false){
            System.out.println("Correct. No bad output was found in  " + numberOfRuns + " tries.");

        }

    }

}

