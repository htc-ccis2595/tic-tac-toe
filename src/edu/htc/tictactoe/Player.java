package edu.htc.tictactoe;

import java.util.Scanner;

/**
 * Created by clifford.mauer on 2/8/2016.
 */
public class Player {
    String name;
    char gameMarker;
    int winCounter;

     public static void main(String[] args){

        Player player = new Player();

        player.testGetName();
        player.testGetMarker() ;
        player.testGetWinCount(0);
        player.testGetWinCount(1);
    }

    public void testGetName(){
        this.getName();
    }

    public void testGetMarker(){
        this.getMarker();
    }

    public void testGetWinCount(int intStart){
        this.getWinCount(intStart);
    }

    public  void getName(){
        String strName;
        System.out.println("Player, please enter your name:");
        Scanner input = new Scanner(System.in);
        strName = input.nextLine();
        this.name = strName;
        System.out.println("Player name has been set to : " + this.name);

    }

    public void getMarker(){
        String strMarker;
        char cMarker;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter either an X or an O to choose your game marker: ");
        strMarker = input.nextLine();

        cMarker = (strMarker.charAt(0));
        this.gameMarker = cMarker;
        System.out.println("Player marker has been set to : " + this.gameMarker);
    }

    public void getWinCount(int intStart){

        if (intStart == 0){
            this.winCounter = 0;
        }
        else{
            this.winCounter++;
        }

        System.out.println("Wins count has been set to : " + this.winCounter);

    }

    public int getMove(){
        String strMove;
        int intSquareChoice;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a block to place your X in: ");
        strMove = input.nextLine();

        intSquareChoice = Integer.valueOf(strMove);

        System.out.println("Player move has been set to : " + intSquareChoice);

        return intSquareChoice;

    }

    public void addWin(){

    }
}
