package edu.htc.tictactoe.player;



/**
 * Created by Owner on 2/21/2016.
 */
public abstract class  Player {
    protected String name;
    protected char gameMarker;
    protected int winCounter = 0;

    //Constructor for player name and game Marker
    public Player(String name, char gameMarker) {
        this.name = name;
        this.gameMarker = gameMarker;
    }

    //Method to increment the win Counter
    public int addWin(){
        winCounter++;
        return winCounter;
    }

    // Getter method for player name
    public String getName(){
        return name;
    }

    //Getter method for Game Marker
    public char getMarker(){
        return gameMarker;
    }

    public abstract int  getMove();
    //Test method
    public static void main(String args[]){
        Player player = new HumanPlayer("Player1",'X');
        int square = player.getMove();
        System.out.println("You picked square : " + square);
        int winCounter = player.addWin();
        System.out.println("Win Count = " + winCounter);
    }

}
