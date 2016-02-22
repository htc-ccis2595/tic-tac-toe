package edu.htc.tictactoe;

/**
 * Created by Sam on 2/18/2016.
 */
public class Player {
    //Player variables
    private String name;
    private  char marker;
    private int winCounter = 0;

    //Get/Set/Construct

    public char getMarker() {
        return marker;
    }
    public String getName() {
        return name;
    }

    public void setMarker(char marker) {
        this.marker = marker;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getWinCounter(){
        return winCounter;
    }

    Player(){
        name = "Player";
        marker = 'X';
    }

    Player(String n, char m){
        name = n;
        marker = m;
    }

    //Increment win count when game is won
    public void addwin(){
        winCounter++;
    }
}
