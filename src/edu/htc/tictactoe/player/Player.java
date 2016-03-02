package edu.htc.tictactoe.player;

import edu.htc.tictactoe.TicTacToe;

import java.util.Scanner;

/**
 * Created by cheey on 2/9/2016.
 */
public abstract class Player {

    private String Name;
    private char gameMarker;
    private int winCounter;

    public Player (String name, char gameMarker)
    {
        this.Name = name;
        this.gameMarker = gameMarker;
    }

    public void setName(String name) {
        Name = name;
    }

    public char getGameMarker() {
        return gameMarker;
    }

    public void setGameMarker(char gameMarker) {
        this.gameMarker = gameMarker;
    }

    public String getName()
    {
        return Name;
    }

    public char getMarker()
    {
        //System.out.print("Marker: x or o?");
        //String gameMarkerStr = scanner.next();
        //char gameMarker = gameMarkerStr.charAt(0);
        return gameMarker;
    }

    public int getWinCount()
    {
        int winCounter = 0;
        winCounter += addWin();
        return winCounter;
    }

    public abstract int getMove();


    public int addWin()
    {
        int winCounter = 0;
        winCounter +=  winCounter;
        return winCounter;
    }



}
