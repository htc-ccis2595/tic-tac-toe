package edu.htc.tictactoe;
import  java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class Main {
    public GameBoard game;
    public Player player1;
    public Player player2;
    private static Scanner scan;
    public static void playGame() {
        scan = new Scanner(System.in);
        boolean EngGame = false;
        int play_response;
        char playerMarker;


        System.out.println("Do you want to play Tic-Tac-Toe?(1 for yes, 2 for no)");

        play_response=scan.nextInt();

        //System.out.println("nextline="+response);
        if ( play_response == 1 ){
            System.out.println("Want to play the game!");


            Player  players[]= new Player[2];

            for (int i=0; i < 2; i++){

                String playerName = null;
                System.out.println("Enter Player "+(i+1)+" Name: ");
                playerName = scan.next();
                if ( playerName == null ){ System.out.println(" Playername is null!"); }


                if ( playerName.trim().isEmpty() ){ System.out.println(" Playername is empty!"); }
                if ( playerName.length() == 0 ) { System.out.println("Length is o");}
                while ( (playerName == null )|| (playerName.trim().isEmpty()) ) {
                    System.out.println("Entry invalid, enter non-null name: ");
                    playerName = scan.next();
                }


                if ( i==0){
                    playerMarker = 'X';
                }else{
                    playerMarker = 'O';
                }


                System.out.println("Player Name=" + playerName);
                players[i] = new Player(playerName,playerMarker);
            }

            for (int i = 0; i<2 ; i++ ) {

                System.out.println(" players[" + i + "] => Name = " + players[i].getName() + ", Marker= " + players[i].getMarker() + ", Win Counter= " + players[i].getWinCount());
            }
                 // Until game won by a player or draw continue.

            GameBoard gameboard = new GameBoard();
            //gameboard.board[0]='O';


            // gameboard.display(gameboard.board);

           // gameboard.display(gameboard.board);

        } else {
            System.out.println("response"+play_response);
            System.out.println("Exiting game...");
            System.exit(0);

        }



    }

    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();
        playGame();

    }
}
