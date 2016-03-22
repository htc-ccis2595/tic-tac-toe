package edu.htc.tictactoe;
import java.util.ArrayList;
/**
 * Created by Gyan on 2/14/2016.
 */
public class GameBoard {

    static char[] board = { '1','2','3','4', '5', '6', '7','8','9'};
    int [][] winCombinations = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},
            {2,5,7},{3,6,9},{1,5,9},{3,5,7}};
    ArrayList<Integer> openSquares = new ArrayList<Integer>();

    public GameBoard() {
        for(int i=1; i<9;i++)
        {
            openSquares.add(new Integer(i));
        }

    }

    public GameBoard(char[] board)
    {
        for(int i=1; i<10; i++)
        {
            openSquares.add(new Integer(i));
        }
        this.board = board;
    }



    public static void display() {

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

    //updating squares
    public void updateSquare(int squareNum, char marker){
        board[squareNum-1] = marker;
        openSquares.remove(new Integer(squareNum));
    }

    //game won?
    public boolean isGameWon(){
        for(int i=0; i<winCombinations.length;i++) {
            int[] combination = winCombinations[i];
            if(board[combination[0]-1] == board[combination[1]-1] &&
                    board[combination[1]-1]== board[combination[2]-1])
            {
                return true;
            }

        }
        return false;
    }

    public boolean isSquareOpen(int squareNum){
        if(openSquares.contains(new Integer(squareNum))){
            return true;
        }
        return false;
    }

    public int[] getOpenSquares(){
        int[] emptySquare = new int[openSquares.size()];
        for(int i = 0; i <emptySquare.length; i++)
        {
            emptySquare[i] = openSquares.get(i).intValue();
        }
        return emptySquare;
    }

    public static void testGameBoardDisplay() {
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("Testing display of Game Board");
        GameBoard gameBoard = new GameBoard();
        System.out.println("Testing display of Empty Game Board");
        gameBoard.display();

        System.out.println(gameBoard.isGameWon());

        int[] openSquares1 = gameBoard.getOpenSquares();
        for(int i=0; i<openSquares1.length; i++){
            System.out.println(openSquares1[i]);
        }
    }



    public static void testIsSquareOpen(){

        System.out.println();
        System.out.println("---------------------");
        System.out.println("Testing is square open method");
        GameBoard board = new GameBoard();

        System.out.println("Testing with empty board - all squares should be open.");
        boolean error = false;
        for (int i = 1; i < 10; i++){
            if(board.isSquareOpen(i) == false){
                error = true;
                System.out.println("Error Square " + i + " is NOT open but should be!");
            }
        }
        if(error == false){
            System.out.println("Correct. All squares are open");
        }
    }
}
