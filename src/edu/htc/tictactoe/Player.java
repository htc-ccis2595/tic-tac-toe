package edu.htc.tictactoe;
import java.util.Scanner;

/**
 * Created by volkg_000 on 2/8/2016.
 */
public class Player {
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
    public int getMove() {
        System.out.println("Hello user, enter a number between 1 and 9 to play your marker: ");
        int pos = scanner.nextInt();
        while(pos > 9 || pos < 1) {
            System.out.println("You dingus, type a number greater than 1 and less than 9!");
            pos = scanner.nextInt();
        }

        return pos;
    }
    public static void main(String args[]) {
        Player mary = new Player("mary", 'X');
        Player jordan = new Player("jordan", 'O');
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




