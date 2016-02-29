package edu.htc.tictactoe.player;
import java.util.Scanner;

/**
 * Created by volkg_000 on 2/8/2016.
 */
public abstract class Player {
    private String name; //instance variables
    private char marker;
    private int winCounter;
    private Scanner scanner = new Scanner(System.in);

    public int getWinCounter() {
        return winCounter;
    }

    public char getMarker() {
        return marker;
    }

    public String getName() {
        return name;
    }

    //constructor
    public Player(String name, char marker) {
        this.name = name;
        this.marker = marker;
        this.winCounter = 0;

    }

    //method to incrememnt win count
    public int addWin() {
        return winCounter ++;

    }
    //method that asks player what spot on the board they would like to move to
    public abstract int getMove();

    public static void main(String args[]) {
        Player mary = new HumanPlayer("mary", 'X');
        Player jordan = new HumanPlayer("jordan", 'O');
        //player 1
        System.out.println("Player 1's name: " + mary.getName());
        System.out.println("Mary's Marker: " + mary.getMarker());
        //player 2
        System.out.println("Player 2's name: " + jordan.getName());
        System.out.println("Jordan's Marker: " + jordan.getMarker());

        System.out.println("Mary's win count: " + mary.getWinCounter());
        mary.addWin();
        System.out.println("Mary's updated win count: " + mary.addWin());

        System.out.println("Jordan's win count: " + jordan.getWinCounter());
        jordan.addWin();
        System.out.println("Jordan's updated win count: " + jordan.addWin());

        mary.getMove();
    }
}




