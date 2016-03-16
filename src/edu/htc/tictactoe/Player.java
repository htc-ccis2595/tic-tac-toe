package edu.htc.tictactoe;

import edu.htc.*;

import java.util.Scanner;

/**
 * Created by joe on 3/16/2016.
 */
public class Player {



    public String playerType = "";
    public String playerTolken = "";
    public String playerStratagy = "";
    public String ComputerLevel = "";


    public void setPlayerType(){
        Scanner myScanner = new Scanner(System.in);
        String input = "";
        Boolean check = true;
        System.out.println("Enter 1 to player against the computer, Enter 2 to play against a friend");

        while(check == true) {
            int num = myScanner.nextInt();
            if(num > 0 && num < 3) {
                if (num == 1) {
                    playerType = "Computer";
                    check = false;
                }
                if (num == 2) {
                    playerType = "Human";
                    check = false;
                }
            }
        }
    }


    public void setPlayerTolken(){
        String input = "";
        Boolean check = true;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Does Player 1 Want To Be X or O?");
        System.out.println("1 for x 2 for o");

        while(check == true) {
            int num = myScanner.nextInt();
            if(num > 0 && num < 3) {
                if (num == 1) {
                    playerTolken = "X";
                    check = false;
                }
                if (num == 2) {
                    playerTolken = "O";
                    check = false;
                }
            }
        }


    }

    public void humanTakeTurn(){
        boolean check = true;
        Scanner turnScanner = new Scanner(System.in);
        System.out.println("Enter the nubmer of the square you want to take");
        int num = -5;


        while(check == true){
            num = 0;
            num = turnScanner.nextInt();
            if(num > -1 && num < 10 && GameBoard.boardVals.get(num) != "X" && GameBoard.boardVals.get(num) != "O"){
                GameBoard.boardVals.set(num, playerTolken );
                check = false;
            }}


    }


public void computerTakeTurn(){
if(ComputerLevel == "HARD"){
    GameBoard.boardVals.set(Stratagy.sendRespose(), TicTacToe.player2.playerTolken );

}
    if(ComputerLevel == "EASY"){
        GameBoard.boardVals.set(Stratagy.randomMove(), TicTacToe.player2.playerTolken );

    }

}

    public static String setCompStratagy(){

            String input = "";
            Boolean check = true;
            Scanner myScanner = new Scanner(System.in);
            System.out.println("Enter 1 To play on EASY, Enter 2 to play on HARD");
            String setting = "";

            while(check == true) {
                int num = myScanner.nextInt();
                if(num > 0 && num < 3) {
                    if (num == 1) {
                        setting = "EASY";
                        check = false;
                    }
                    if (num == 2) {
                        setting = "HARD";
                        check = false;
                    }
                }
            }
          return setting;

        }



}

