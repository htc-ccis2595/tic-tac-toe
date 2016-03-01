package edu.htc.tictactoe;

import java.util.Scanner;

/**
 * Created by Sam on 2/18/2016.
 */
public class Player {
    //Player variables
    private String name;
    private  char marker;
    private int winCounter = 0;
    private int move;

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
     public void setMove(int mv){
         move = mv;
     }

    public int getMove(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the square you want to play:");
        int sq = scanner.nextInt();
        return sq;
    }

    //Increment win count when game is won
    public void addwin(){
        winCounter++;
    }

    //Test
    /*public static void main(String[] Args){
        Player testPlayer = new Player("Tim", 'x');
        System.out.println(testPlayer.name + " has won "+ testPlayer.getWinCounter() + " games.");
        testPlayer.addwin();
        System.out.println(testPlayer.name + " has won a game as marker " + testPlayer.getMarker() +". He has won a total of " + testPlayer.winCounter + " games.");
    }*/

}
