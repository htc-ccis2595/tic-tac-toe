package edu.htc.tictactoe.player;

public abstract class Player{
    private String playerName;
    private char marker;
    private int winCounter;

    public Player(String playerName,char marker){
        this.playerName=playerName;
        this.marker=marker;
        winCounter=0;
    }


    public String getPlayerName() {
        return playerName;
    }

    public char getMarker() {
        return marker;
    }

    public int getWinCounter() {return winCounter;}

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", marker=" + marker +
                ", winCounter=" + winCounter +
                '}';
    }

    public void addWin(){
        winCounter++;
    }
    public abstract int getMove();




}

