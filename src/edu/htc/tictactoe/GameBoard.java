package edu.htc.tictactoe;

import java.util.ArrayList;

/**
 * Created by Sam on 2/18/2016.
 */
public class GameBoard {
    //variables
    private char board[] ={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private ArrayList<Integer> openSquares = new ArrayList<Integer>();

    private int winCombinations[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 5, 6}, {3, 5, 7}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}};

    public GameBoard(char brd[]){
        board = brd;
        for (int b = 1; b < 10; b++){
            if (board[b] != 'x' | board[b] != 'o'){
                openSquares.add(b);

            }
        }
    }


    //methods



    public void display() {
        System.out.println(" " + board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("---+---+---");
        System.out.println(" " + board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("---+---+---");
        System.out.println(" " + board[7] + " | " + board[8] + " | " + board[9]);
    }

    public void updateSquare(int sqnum, char mark) {
        board[sqnum] = mark;
        openSquares.remove(new Integer(sqnum));
    }


    public boolean isGameWon(char m) {
        for (int[] wincombo : winCombinations) {
            char char1 = board[wincombo[0]];
            char char2 = board[wincombo[1]];
            char char3 = board[wincombo[2]];
            if (char1 == char2 && char1 == char3) {
                return true;
            }
        }
        return false;
    }

    public boolean isSquareOpen(int sqrnum){
        return openSquares.contains(sqrnum);

    }

    public int[] getOpenSquares(){
        int[] openSqArray = new int[openSquares.size()];
        for (int i=0; i < openSqArray.length; i++)
        {
            openSqArray[i] = openSquares.get(i).intValue();
        }
        return openSqArray;

    }



    public static void main(String[] Args){
        char testboard[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        GameBoard testGameboard= new GameBoard(testboard);
        testGameboard.display();
        if (testGameboard.isGameWon('x')) {
            System.out.println("Game has been won!");
        }
        else{
                System.out.println("No winner yet.");
            }
        System.out.println("This is the list of open squares:");
        for(int p = 0; p < (testGameboard.getOpenSquares().length); p++){
            int testArray[] = testGameboard.getOpenSquares();
            System.out.println(testArray[p]);
        }
        System.out.println("Player changed square 4 to x");
        testGameboard.updateSquare(4,'x');
        System.out.println("This is the list of open squares now:");
        for(int p = 0; p < (testGameboard.getOpenSquares().length); p++){
            int testArray[] = testGameboard.getOpenSquares();
            System.out.println(testArray[p]);
        }
        }



    }






