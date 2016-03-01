package edu.htc.tictactoe;

import java.util.ArrayList;

public class GameBoard{
    private char[] board;
    private ArrayList < Integer > opensquares;
    private int winCombinations[][]={{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
    public GameBoard(){
        board=new char[]{'1','2','3','4','5','6','7','8','9'
        };
        opensquares=new ArrayList<Integer>();
        opensquares.add(new Integer(1));
        opensquares.add(new Integer(2));
        opensquares.add(new Integer(3));
        opensquares.add(new Integer(4));
        opensquares.add(new Integer(5));
        opensquares.add(new Integer(6));
        opensquares.add(new Integer(7));
        opensquares.add(new Integer(8));
        opensquares.add(new Integer(9));
    }
    public GameBoard(char[] array){
        board=array;
        opensquares=new ArrayList<Integer>();
        for (int i=0; i<board.length; i++){
            char currentChar=board[i];
            if (currentChar!='X' && currentChar != 'O' ){
                opensquares.add(new Integer(i+1));
            }
        }
    }
    public void display(){
        System.out.println("   |   |   ");
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " ");
        System.out.println("   |   |   ");
    }
    public void updateSquare(int boardPos, char marker){
        board[boardPos-1]=marker;
        opensquares.remove(new Integer(boardPos));
    }
    public boolean isGameWon(){
        for (int[] winCombo:winCombinations){
            char char1=board[winCombo[0]-1];
            char char2=board[winCombo[1]-1];
            char char3=board[winCombo[2]-1];
            if (char1==char2 && char1==char3){
                return true;
            }
        }
        return false;
    }
    public int[] getOpenSquares(){
        return opensquares.stream().mapToInt(Integer::intValue).toArray();

    }


    public boolean isSquareOpen(int boardPos){
        if (board[boardPos-1]=='X' || board[boardPos-1]=='O') {
            return false;
        }
        return true;
    }
    public char getsquareValue(int boardNum){
        return board[boardNum-1];
    }

    public static void main(String[] args){
        GameBoard emptyGameBoard=new GameBoard();
        emptyGameBoard.display();
        char[] testBoard=new char[]{'X','O','X','O','5','6','X','8','9'
        };
        GameBoard testGameBoard=new GameBoard(testBoard);
        testGameBoard.display();
        testGameBoard.updateSquare(9,'X');
        testGameBoard.display();
        System.out.println("game shouldn't be won " + testGameBoard.isGameWon());
        testGameBoard.updateSquare(4,'X');
        testGameBoard.display();
        System.out.println("game should be won " + testGameBoard.isGameWon());
        System.out.println("square should not be open " + testGameBoard.isSquareOpen(1));
        System.out.println("square should be open " + testGameBoard.isSquareOpen(8));





    }
}