package edu.htc.tictactoe;

import java.util.ArrayList;

/**
 * Created by Student on 2/8/2016.
 */
public class GameBoard {
    private char board[] = new char[9];
    private ArrayList openSquares = new ArrayList();
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
    public ArrayList getOpenSquares() {return openSquares;}
    public void display()
    {
        int i, j;
        j = 0;
        for (i = 0; i < 9; i++)
        {
            if (board[i] == ' ')
                System.out.print("|" + openSquares.get(i));
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
}
