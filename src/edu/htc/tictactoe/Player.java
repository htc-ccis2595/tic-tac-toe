package edu.htc.tictactoe;

import java.util.Scanner;
/**
 * Created by Student on 2/8/2016.
 */
public class Player {
    private String name;
    private char gameMarker;
    private int winCounter;

    public Player(String name, char gameMarker) {
        this.name = name;
        this.gameMarker = gameMarker;
        winCounter = 0;
    }

    public String getName() { return name; }
    public char getMarker() { return gameMarker; }
    public int getWinCount() { return winCounter; }

    public int getMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your next move from 1-9: ");
        int PlayMove = scanner.nextInt();

           while ( PlayMove < 1 || PlayMove >9 ) {
               System.out.println("Entry invalid, enter value from 1-9 only: ");
               PlayMove = scanner.nextInt();
           }
        return PlayMove;
    }
    public static void main(String[] args) {
        int i = 0;
        Player[] players = new Player[2];

        players[0] = new Player("Peter",'X');
        players[1] = new Player("Jack",'O');
        for (i = 0; i<2 ; i++ ) {
            System.out.println(" players[" + i + "] => Name = " + players[i].getName() + ", Marker= " + players[i].getMarker() + ", Win Counter= " + players[i].getWinCount());
            System.out.println(" Move to: " + players[i].getMove() );
        }

    }
}
