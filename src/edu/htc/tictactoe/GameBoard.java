package edu.htc.tictactoe;
import java.util.ArrayList;

/**
 * Created by Prince Roka on 2/8/2016.
 */
public class GameBoard {

    private char[] getBoard() {
        return board;
    }

    //The board
    private char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    //Win combos
    private int[][] winCombinations = {
            {1, 2, 3}, {4, 5, 6}, {7, 8, 9},
            {1, 4, 7}, {2, 5, 8}, {3, 6, 9},
            {1, 5, 9}, {3, 5, 7}
    };

    private ArrayList<Integer> openSquares = new ArrayList<Integer>();

    public GameBoard(char[] board) {
        this.board = board;
        int counter;
        for (counter = 1; counter < 10; counter++) {
            if (board[counter - 1] != 'X' && board[counter - 1] != 'O')
                openSquares.add(counter);
        }
    }

    public GameBoard() {
        for (int counter = 1; counter < 10; counter++) {
            openSquares.add(counter);
        }
    }

    public void testGameBoard() {
        int i;

        System.out.println("Printing Blank Board");
        GameBoard gameBoard = new GameBoard();
        gameBoard.display();
        System.out.println();
        System.out.println("Testing gameWon");
        System.out.println(gameBoard.gameWon());
        System.out.println();
        for (i = 0; i < gameBoard.getOpenSquares().length; i++) {
            System.out.println(gameBoard.getOpenSquares()[i]);
        }
        System.out.println();

        System.out.println("Printing Partially Filled Board");
        GameBoard yolo = new GameBoard(new char[]{'X', '2', 'O', '4', 'X', 'O', '7', 'O', 'X'});
        yolo.display();
        System.out.println("Testing getSquareValue");
        for (i = 1; i < 9; i++) {
            System.out.println(yolo.getSquareValue(i));
        }
        System.out.println();
        System.out.println("Testing isSquareOpen");
        for (i = 1; i < 9; i++) {
            System.out.println(yolo.isSquareOpen(i));
        }
        System.out.println();
        System.out.println("Testing gameWon");
        System.out.println(yolo.gameWon());
        System.out.println();
        System.out.println("Testing updateSquare");
        yolo.display();
        yolo.updateSquare(2, 'O');
        yolo.updateSquare(4, 'X');
        yolo.display();
        System.out.println();
        System.out.println("Testing openSquares");
        System.out.println();
        for (i = 0; i < yolo.getOpenSquares().length; i++) {
            System.out.println(yolo.getOpenSquares()[i]);
        }

    }

    public boolean gameWon() {
        int i;
        for (i = 0; i < winCombinations.length; i++) {
            int[] winSet = winCombinations[i];

            int sqr = winSet[0];
            int sqr2 = winSet[1];
            int sqr3 = winSet[2];

            char bob = board[sqr - 1];
            char jim = board[sqr2 - 1];
            char larry = board[sqr3 - 1];
            if (bob == jim && jim == larry) {
                return true;
            }
        }
        return false;
    }

    public void updateSquare(int x, char m) {
        board[x - 1] = m;
        openSquares.remove(new Integer(x));
    }

    public int[] getOpenSquares() {
        return openSquares.stream().mapToInt(i -> i).toArray();
    }

    public char getSquareValue(int x) {
        return getBoard()[x - 1];
    }

    public boolean isSquareOpen(int x) {
        if (board[x - 1] == 'X' || board[x - 1] == 'O') {
            return false;
        } else {
            return true;
        }
    }

    public void display() {
        System.out.println();
        System.out.println("   |   |   ");
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " ");
        System.out.println("   |   |   ");
    }


    public static void main(String args[]) {

        GameBoard test = new GameBoard();
        test.testGameBoard();
    }
}