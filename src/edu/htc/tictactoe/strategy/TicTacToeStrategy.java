package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;
import edu.htc.tictactoe.player.HumanPlayer;

import java.util.Random;
import java.util.ArrayList;



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
        this.gameboard.getOpenSquares();
        System.out.println("AI thinks these squares are open: " + this.gameboard.openSquares); //this keeps running over and over


    }



    public abstract int getBestMove();





    protected int getRandomMove() {


        int[] opensquares = this.gameboard.getOpenSquares();


        int randomNum = rand.nextInt(opensquares.length);

        return opensquares[randomNum];
    }

    protected int getBestOpenMove() { //medium difficulty AI

        int[] opensquares = gameboard.getOpenSquares(); //actual open squares

        //System.out.println("AI thinks these squares are open: " + gameboard.openSquares); //this keeps running over and over


        //if position 5 is open move to middle square
        if (gameboard.isSquareOpen(5) == true) {
            return 5;

        }



        ArrayList<Integer> opencorners = new ArrayList<Integer>();


        if (gameboard.isSquareOpen(1) == true) {
            opencorners.add(1);
        }

        if (gameboard.isSquareOpen(3) == true) {
            opencorners.add(3);
        }
        if (gameboard.isSquareOpen(7) == true) {
            opencorners.add(7);
        }

        if (gameboard.isSquareOpen(9) == true) {
            opencorners.add(9);
        }

        if (opencorners.size() > 0) {

            int rcm = rand.nextInt(opencorners.size());

            return opencorners.get(rcm);
        }

        //take a random remaining square
        else {
            return
                    getRandomMove();

        }
    }

    protected int getBlockWinMove() {
        int i;
        char[] chBoard = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};


             return 0;
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
        int numberofruns = 100;
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

        System.out.println("Testing getBestOpenMove.");
        GameBoard testGB = new GameBoard(new char[]{'1','2','3','4','5','6','7','8','9'});
        TicTacToeStrategy strategy1 = new TicTacToeStrategy(testGB) {
            @Override
            public int getBestMove() {
                return 0;
            }
        };

        boolean Error = false;

       int move = strategy1.getBestOpenMove();
        if(move == 5) {
            System.out.print("You da man!!!!!, pros take the middle!!!");
        }

        else {
            System.out.println("You were supposed to take the center!!");
        }

        testGB.updateSquare(5, 'O');
        for(int i=0; i < numberofruns; i++) {
            int move2 = strategy1.getBestOpenMove();
            if (move2 != 1 && move2 != 3 && move2 != 7 && move2 != 9) {
                System.out.println("Wrong move buddy"); Error = true;
            }


        }

        if(Error == false) {
            System.out.println("No bad output!!! woot!!");

        }


    }

}





