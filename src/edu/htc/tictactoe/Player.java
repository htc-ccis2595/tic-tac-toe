package edu.htc.tictactoe;

/**
 * Created by cheey on 2/9/2016.
 */
public class Player {

    String Name;
    char gameMarker;
    int winCounter;

    Player playerX = new Player();

    public String getName()
    {return Name;}

    public int getMarker()
    {return gameMarker;}

    public int getWinCount()
    {return winCounter;}

//    public int getMove()
//    {}
//
//    public int addWin()
//    {}

}
