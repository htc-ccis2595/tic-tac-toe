package edu.htc.tictactoe;

import java.util.Scanner;

/**
 * Created by clifford.mauer on 2/8/2016.
 */
public class Player {
    String name;
    char gameMarker;
    int winCounter;
    boolean isCurrentPlayer;
    Scanner input = new Scanner(System.in);

     public static void main(String[] args){

        Player player = new Player();

        player.testGetName(1);
        player.testGetMarker() ;
        player.testGetWinCount(0);
        player.testGetWinCount(1);
    }

    public void testGetName(int intPlayerNumber){
        this.getName(intPlayerNumber);
    }

    public void testGetMarker(){
        this.getMarker();
    }

    public void testGetWinCount(int intStart){
        this.getWinCount(intStart);
    }

    public  void getName(int intPlayerNumber){
        String strName;
        boolean blnValid;

        do {
                System.out.println("Player" + intPlayerNumber +", please enter your name:");
                strName = input.nextLine();
                this.name = strName;
                System.out.println("Player" + intPlayerNumber +" name has been set to : " + this.name);
                if (!this.name.isEmpty()) {
                    blnValid = true;
                } else {
                    System.out.println("Player name cannot be blank1.  Please enter a player name.");
                    blnValid = false;
                }
    } while (!blnValid);
    }



    public void getMarker(){
        String strMarker;
        char cMarker;

        System.out.println("Enter either an X or an O to choose your game marker: ");
        strMarker = input.nextLine();

        cMarker = (strMarker.charAt(0));
        this.gameMarker = cMarker;
        System.out.println(this.name + "Player marker has been set to : " + this.gameMarker);
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

    public int getMove(char cMarker){
        String strMove;
        int intSquareChoice = 0;
        Boolean blnValid;

        System.out.println(this.name+", please enter a block to place your " + cMarker + " in: ");

        do {
            strMove = input.nextLine();
            if(strMove.isEmpty()){
                System.out.println("Please enter a number..");
            } else {
                intSquareChoice = Integer.valueOf(strMove);
            }
            if (intSquareChoice > 0 & intSquareChoice <= 10){
                blnValid = true;
            } else {
                System.out.println("Player move can only be numbers 1 through 9.  Please choose again.");
                blnValid = false;
            }
        } while (!blnValid);


        System.out.println(this.name+"'s move has been set to : " + intSquareChoice);

        return intSquareChoice;

    }

    public void addWin(){

        this.winCounter++;

        return;

    }
}
