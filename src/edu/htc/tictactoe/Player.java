package edu.htc.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Owner on 2/21/2016.
 */
public class Player {
    private String name;
    private char gameMarker;
    private int winCounter = 0;

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

    //method to get the square that the player wants to play in
    public int getMove(){
        Scanner scanner = new Scanner(System.in);
        int square = 0;
        while(true) {
            System.out.println("What square do you want to play?(1-9)");
            square = scanner.nextInt();
            if (square >= 1 && square <= 9) {
                return square;
            } else {
                System.out.println("Invalid entry:");
            }
        }
    }


    // Getter method for player name
    public String getName(){
        return name;
    }

    //Getter method for Game Marker
    public char getMarker(){
        return gameMarker;
    }

    //Test method
    public static void main(String args[]){
        Player player = new Player("Player1",'X');
        int square = player.getMove();
        System.out.println("You picked square : " + square);
        int winCounter = player.addWin();
        System.out.println("Win Count = " + winCounter);
    }

}
