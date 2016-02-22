package edu.htc.tictactoe;

import java.util.ArrayList;

/**
 * Created by Student on 2/8/2016.
 */
public class GameBoard {
    private char board[] = new char[9];
    private ArrayList openSquares;

    GameBoard()
    {
        char Board[] = {'A','B','C','D','E','F','G','H','I'};
        board = Board;
        int i, j;
        for (i = 0; i < 9; i++)
        {
            j = i + 1;
             openSquares.add(i, j);
        }
    }
}
