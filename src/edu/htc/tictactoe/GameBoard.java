package edu.htc.tictactoe;

import java.util.ArrayList;

/**
 * Created by Owner on 2/21/2016.
 */
public class GameBoard {
    private char[] board = {'1','2','3','4','5','6','7','8','9'};
    private int [][] winCombinations = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
    ArrayList<Integer> openSquares = new ArrayList<Integer>();

    //Constructor for Game Board square and Open Suares
    public GameBoard() {
        for(int i=1;i<=9;i++)
        {
            openSquares.add(new Integer(i));
        }
    }

    public GameBoard(char[] board)
    {
        for(int i=1;i<=9;i++)
        {
            openSquares.add(i);
        }
        this.board = board;
    }

    //Display method to print the game board
    public void display(){

        for(int i = 0; i < board.length;i++)
        {
            if(i%3 == 0)
            {
                System.out.println("+---+---+---+");
                System.out.print("| " + board[i] + " | ");
            }
            else
            {
                System.out.print(board[i] + " | ");
            }
            if(i%3 == 2)
            {
                System.out.println();
            }
        }
        System.out.println("+---+---+---+");
        System.out.print("Open squares: ");
        for(Integer square:openSquares)
        {
            System.out.print(square + ",");
        }
        System.out.println();
    }

    public char[] getSquaresForMarker(char playerMarker) {
        char playerSquares[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (int i = 0; i < board.length; i++) {
            if (board[i] == playerMarker) {
                playerSquares[i] = board[i];
            } else {
                playerSquares[i] = ' ';
            }
        }
        return playerSquares;
    }
        //Testing gameboard display
    public static void testGameBoardDisplay(){
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println(" Testing display of Game Board");
        GameBoard gameBoard = new GameBoard();
        System.out.println(" Testing display of Empty Game Board");
        gameBoard.display();

        //testing the board after the markers
        System.out.println(" Testing display of Game Board after adding O in the top right, X in the middle right and O in the bottom left");
        try {
            gameBoard.updateSquare(1,'O');
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            gameBoard.updateSquare(6,'X');
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            gameBoard.updateSquare(7,'O');
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("End of testing display of the Game Board");
        gameBoard.display();

        //Calling Is game won method
        System.out.println(gameBoard.isGameWon());

        //Calling get open squares method to see which squares are open
        int[] openSquares1 = gameBoard.getOpenSquares();
        for (int anOpenSquares1 : openSquares1) {
            System.out.println(anOpenSquares1);
        }
    }

    //Testing if a square is open
    public static void testIsSquareOpen(){
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println(" Testing if a square is open");
        GameBoard gameboard = new GameBoard();

        System.out.println("Tesing Empty board - All squares should be open");
        boolean isOpen = false;
        for (int i=1; i<=9; i++){
            if(gameboard.isSquareOpen(i) == false){
                isOpen = true;
                System.out.println("Error "+ i + "is not open!" );
            }
        }
        if (isOpen ==false){
            System.out.println("All squares are open!");
        }

        //Testing after updating the squares

    }


    //update the squares method
    public void updateSquare(int squareNum, char marker) throws Exception{
        if (squareNum < 1 || squareNum > 9){
            throw new Exception("Invalid Square Number");
        }
        board[squareNum - 1] = marker;
        openSquares.remove(new Integer(squareNum));
    }

    //Is Game won method
    public boolean isGameWon() {
        for (int[] combination : winCombinations) {
            if (board[combination[0] - 1] == board[combination[1] - 1] && board[combination[1] - 1] == board[combination[2] - 1]) {
                return true;
            }
        }
        return false;
    }

    //Get open Squares method
    public int[] getOpenSquares(){
        int[] ret = new int[openSquares.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = openSquares.get(i);
        }
        return ret;
    }

    //Is Square Open
    public boolean isSquareOpen(int squareNum){
        return openSquares.contains(squareNum);
    }

    public static void main(String args[])
    {
        testGameBoardDisplay();
        testIsSquareOpen();
    }
}
