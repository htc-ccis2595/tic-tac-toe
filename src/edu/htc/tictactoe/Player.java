package edu.htc.tictactoe;

import javax.lang.model.element.Name;
import java.util.Scanner;

/**
 * Created by Student on 2/8/2016.
 */
public class Player {
    private String name = new String();
    private char gameMarker;
    private int winCounter;

    Player(String defName, char GameMarker)
    {
        name = defName;
        gameMarker = GameMarker;
        winCounter = 0;
    }
    public String getName()
    {
        return name;
    }
    public char getMarker()
    {
        return gameMarker;
    }
    public int getWinCount()
    {
        return winCounter;
    }
    public void addWin()
    {
        winCounter = winCounter + 1;
    }
    public int getMove()
    {
        Scanner askMove = new Scanner(System.in);
        int move = 0;
        System.out.println("Enter the number of the square you wish to move in, 1-9: ");
        if (askMove.hasNextInt())
            move = askMove.nextInt();
        else
        {
            System.out.println("Invalid data entered");
            move = getMove();
        }
        if (move < 1 | move > 9)
        {
            System.out.println("Invalid number entered");
            move = getMove();
        }
        return move;
    }
}
