package edu.htc.tictactoe;

import java.util.ArrayList;

/**
 * Created by Student on 2/8/2016.
 */
public class GameBoard {
    private char board[] = new char[9];
    private ArrayList<Integer> openSquares = new ArrayList<Integer>();
    private int winCombinations[][] = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
    GameBoard(char[] Board)
    {
        ArrayList OpenSquares = new ArrayList();
        board = Board;
        int i, j;
        for (i = 0; i < 9; i++) {
            j = i + 1;
            OpenSquares.add(i, j);
        }
        openSquares = OpenSquares;
    }
    public int[] getOpenSquares()
    {
        int GetOpenSquares[] = new int[openSquares.size()];
        int counter;
        for (counter = 0; counter < openSquares.size(); counter++)
        {
            GetOpenSquares[counter] = openSquares.get(counter).intValue();
        }
        return GetOpenSquares;
    }
    public void display()
    {
        int i, j;
        j = 0;
        for (i = 0; i < 9; i++)
        {
            if (board[i] == ' ')
                System.out.print("| ");
            else
                System.out.print("|" + board[i]);
            if (j == 2)
            {
                System.out.print("|\n" + "|-+-+-|\n");
                j = 0;
            }
            else
                j++;
        }
    }
    public void updateSquare(int squareNumber, char marker)
    {
        board[squareNumber - 1] = marker;
        int openRemover = openSquares.indexOf(squareNumber);
        openSquares.remove(openRemover);
    }
    public boolean isSquareOpen(int x)
    {
        return openSquares.contains(x);
    }
    public char getSquareValue(int x)
    {
        return board[x];
    }
    public boolean isGameWon()
    {
        ArrayList<Integer> xSpots = new ArrayList<Integer>(), oSpots = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++)
        {
            if (board[i] == 'X')
                xSpots.add(i + 1);
            else if (board[i] == 'O')
                oSpots.add(i + 1);
        }
        for (int i = 0; i < 8; i++)
        {

            if(xSpots.contains(winCombinations[i][0]) & xSpots.contains(winCombinations[i][1]) & xSpots.contains(winCombinations[i][2]))
            {
                return true;
            }
            if(oSpots.contains(winCombinations[i][0]) & oSpots.contains(winCombinations[i][1]) & oSpots.contains(winCombinations[i][2]))
            {
                return true;
            }
        }
        if (getOpenSquares().length == 0 )
            return true;
        return false;
    }
}
