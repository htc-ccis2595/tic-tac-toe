package edu.htc.tictactoe;

import java.util.ArrayList;


/**
 * Created by volkg_000 on 2/8/2016.
 */
public class GameBoard {
    private char chBoard[];
    private ArrayList<Integer> openSquares; //change back to private afterwards
    private int winCombinations[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9},
            {1, 5, 9}, {3, 6, 9}, {2, 5, 8}, {1, 4, 7}, {3, 5, 7}};

    public GameBoard() {
        reset();

    }

    public void reset() {
        chBoard = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        openSquares = new ArrayList();
        openSquares.add(1);
        openSquares.add(2);
        openSquares.add(3);
        openSquares.add(4);
        openSquares.add(5);
        openSquares.add(6);
        openSquares.add(7);
        openSquares.add(8);
        openSquares.add(9);
    }

    public GameBoard(char[] board) {
        this.chBoard = board;
        openSquares = new ArrayList();
        for (int i = 0; i < board.length; i++) {
            char c = board[i];
            if (c != 'X' && c != 'O') {
                openSquares.add(i + 1);
            }
        }
    }

    public int[] getOpenSquares() {
        return openSquares.stream().mapToInt(Integer::intValue).toArray();
    }

    public char getSquareValue(int x) {

        return chBoard[x - 1];

    }


    public void display() {
        System.out.println();
        System.out.println();
        System.out.println("+-+---+---+");
        System.out.println(chBoard[0] + " | " + chBoard[1] + " | " + chBoard[2] + " |");
        System.out.println("+-+---+---+");
        System.out.println(chBoard[3] + " | " + chBoard[4] + " | " + chBoard[5] + " |");
        System.out.println("+-+---+---+");
        System.out.println(chBoard[6] + " | " + chBoard[7] + " | " + chBoard[8] + " |");
        System.out.println("+-+---+---+");

    }

    public void updateSquare(int update, char marker) {
        chBoard[update - 1] = marker;
        openSquares.remove(new Integer(update));
    }


    public boolean isGameWon() {
        boolean gameWon = false;
        int i;
        for (i = 0; i < winCombinations.length; i++) {
            int[] possiblewin = winCombinations[i];

            int squarenum = possiblewin[0];
            char squarevalue = chBoard[squarenum - 1];
            int squarenum2 = possiblewin[1];
            char squarevalue2 = chBoard[squarenum2 - 1];
            int squarenum3 = possiblewin[2];
            char squarevalue3 = chBoard[squarenum3 - 1];
            if (squarevalue == squarevalue2 && squarevalue2 == squarevalue3) {
                gameWon = true;
                break;
            }
        }
        return gameWon;
    }

    public boolean isSquareOpen(int x) {
        if (chBoard[x - 1] == 'X' || chBoard[x - 1] == 'O') {
            return false;
        } else {
            return true;
        }

    }


    public static void main(String args[]) {
        System.out.println("The chBoard: {'1', 'X', 'X', '4', '5', 'O', '7', 'O', '9'}");
        char[] testboard = new char[]{'1', 'X', 'X', '4', '5', 'O', '7', 'O', '9'};
        GameBoard testGB = new GameBoard(testboard);
        int[] openSquares = testGB.getOpenSquares();
        for (int x : openSquares) {
            System.out.println("Open square #: " + x);
        }
        System.out.println("No one has won: ");
        System.out.println(testGB.isGameWon());
        System.out.println("Were updating square 1 with X. ");
        testGB.updateSquare(1, 'X');
        System.out.println("Were updating square 9 with O. ");
        testGB.updateSquare(9, 'O');
        openSquares = testGB.getOpenSquares();
        for (int x : openSquares) {
            System.out.println("Open square #: " + x);
        }
        testGB.display();
        System.out.println("Someone has won: ");
        System.out.println(testGB.isGameWon());


        testboard = new char[]{'1', 'X', 'X', '4', '5', 'O', 'O', 'O', 'O'};
        testGB = new GameBoard(testboard);
        testGB.display();
        System.out.println("Someone has won: ");
        System.out.println(testGB.isGameWon());

        //testing for open squares
        testboard = new char[]{'1', '2', 'X', '4', '5', '6', '7', '8', '9'};
        testGB = new GameBoard(testboard);
        testGB.display();
        System.out.println("Is square 1 open? " + testGB.isSquareOpen(1));
        System.out.println("Is square 4 open? " + testGB.isSquareOpen(4));


        System.out.println("What is the value of square 3: " + testGB.getSquareValue(2));
        System.out.println("What is the value of square 9: " + testGB.getSquareValue(8));


    }


}
