package edu.htc.tictactoe;
import java.util.ArrayList;
/**
 * Created by Gyan on 2/14/2016.
 */
public class GameBoard {

    static char[] board = { '1','2','3','4', '5', '6', '7','8','9'};
    int [][] winCombinations = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},
            {2,5,7},{3,6,9},{1,5,9},{3,5,7}};
    boolean error = true;

    ArrayList<Integer> openSquares = new ArrayList<Integer>(9);
    {
        int i;
        for (i = 1; i < 10; i++) {
            openSquares.add(i);
        }
        //System.out.println(openSquares);
    }


    public static void testGameBoardDisplay() {

        //Draw tic tac toe shape, Using loop
        int i;
        System.out.println();
        for (i = 0; i < 3; i++) {
            if (i == 0) {
                System.out.print("   " + board[i]);
            } else {
                System.out.print("  |  " + board[i]);
            }
        }
        System.out.println();
        System.out.println("-------------------");
        for (i = 3; i < 6; i++) {
            if (i == 3) {
                System.out.print("   " + board[i]);
            } else {
                System.out.print("  |  " + board[i]);
            }
        }
        System.out.println();
        System.out.println("-------------------");
        for (i=6; i<9; i++){
            if (i == 6) {
                System.out.print("   " + board[i]);
            }
            else {
                System.out.print("  |  " + board[i]);
            }
        }


    }




    public void isSquareOpen(){

    }

    public static void testIsSquareOpen(){

//        System.out.println();
//        System.out.println("---------------------");
//        System.out.println("Testing is square open method");
//        GameBoard board = new GameBoard();
//
//        System.out.println("Testing with empty board - all squares should be open.");
//        boolean error = false;
//        for (int i = 1; i < 10; i++){
//            if(board.isSquareOpen(i) == false){
//                error = true;
//                System.out.println("Error Square " + i + " is NOT open but should be!");
//            }
//        }
//        if(error == false){
//            System.out.println("Correct. All squares are open");
//        }


    }






}
