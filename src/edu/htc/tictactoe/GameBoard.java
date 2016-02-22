package edu.htc.tictactoe;

import java.util.ArrayList;

/**
 * Created by Sam on 2/18/2016.
 */
public class GameBoard {
    //variables
    public char board[] = {'0','1','2','3','4','5','6','7','8','9'};
    public ArrayList<Integer> openSquares = new ArrayList<Integer>(){{
        add(0);
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        add(6);
        add(7);
        add(8);
        add(9);

        }};
    public void display(){
        System.out.println(" "+board[1]+" | "+board[2]+" | "+board[3]);
        System.out.println("---+---+---");
        System.out.println(" "+board[4]+" | "+board[5]+" | "+board[6]);
        System.out.println("---+---+---");
        System.out.println(" "+board[7]+" | "+board[8]+" | "+board[9]);
    }
    public void updateSquare(int sqnum, char mark){
        board[sqnum] = mark;
        openSquares.remove(new Integer(sqnum));
    }

    private int winCombinations[][] = {{1,2,3},{4,5,6},{7,8,9},{1,5,6},{3,5,7},{1,4,7},{2,5,8},{3,6,9}};

    public boolean isGameWon(char m){

    }
    };


