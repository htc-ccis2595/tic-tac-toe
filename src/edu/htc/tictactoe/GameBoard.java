package edu.htc.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Student on 2/8/2016.
 */
public class GameBoard {


    private char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private ArrayList openSquares;

    private int winCombinations[][] = {{1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {1, 5, 9},
            {3, 5, 7},
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}};

    /*
        public static void IsSquareOpen(){
            System.out.println();
            System.out.println("--------------------------");
            System.out.println("Testing is Square open method");
            GameBoard board = new GameBoard();

            System.out.println("Testing with empty board - all squares should be open.");
            boolean error = false;
            for(int i=1; i<=9; i++) {
                if(board.isSquareOpen(i) == false) {
                    error = true;
                    System.out.println("Error. Square " + i + "is NOT open but should be!");
                }
            }
            if (error == false ){

                System.out.println("Correct. All squares are open.");
            }
        }
    */
    public char updateSquare(int x, char c) { this.board[x-1]=c; return board[x-1];};

    public static void display(char[] board) {
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("-" + " + " + "-" + " + " + "-");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("-" + " + " + "-" + " + " + "-");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }

    public ArrayList getOpenSquares() {return openSquares;}
    public boolean isSquareOpen(int x) {
        if (board[x - 1] == 'x' || board[x - 1] == 'X'|| board[x-1] == 'O' || board[x-1] == 'o') {
            // System.out.println("match found!");
            // System.out.println("board[x-1]=" + board[x - 1]);
            return false;
        } else {
            // System.out.println("Match not found!");
            // System.out.println("board[x-1]=" + board[x - 1]);
            return true;
        }
    }
    public char getSquareValue(int x) {return board[x-1];}

/*
    public boolean IsSquareOpen(int x){
        if ( board[x-1])
        for (int i=1; i<=9; i++) {

        }
    } */
    public static void main(String[] args) {
        //testGameBoardDisplay();
        GameBoard gameboard = new GameBoard();
        gameboard.board[0]='O';
        gameboard.display(gameboard.board);
        gameboard.updateSquare(2,'O');
        System.out.println("\n");
        System.out.println("-------------------------\n");
        gameboard.display(gameboard.board);
        gameboard.updateSquare(8,'X');
        System.out.println("-------------------------\n");
        gameboard.display(gameboard.board);
        System.out.println("-------------------------\n");

        ArrayList<Integer> openSquares = new ArrayList<Integer>();
        for(int i=1; i<=9; i++ ) {
            openSquares.add(new Integer(i));
        }

        for(int i=0; i<openSquares.size(); i++ ) {
           System.out.println(openSquares.get(i));
           }
        if (gameboard.isSquareOpen(1) == false ) {
            System.out.println("IsOpenSquare Is used up!");
        }
        System.out.println("board[1]="+gameboard.getSquareValue(1));

    }
}