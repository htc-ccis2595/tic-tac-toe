package edu.htc.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Student on 2/8/2016.
 */
public class GameBoard {


    private char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private ArrayList openSquares;

    private int winCombinations[][] = {{1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {1, 5, 9},
            {3, 5, 7},
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}};

    /*
        public static void IsSquareOpen(){
            System.out.println();
            System.out.println("--------------------------");
            System.out.println("Testing is Square open method");
            GameBoard board = new GameBoard();

            System.out.println("Testing with empty board - all squares should be open.");
            boolean error = false;
            for(int i=1; i<=9; i++) {
                if(board.isSquareOpen(i) == false) {
                    error = true;
                    System.out.println("Error. Square " + i + "is NOT open but should be!");
                }
            }
            if (error == false ){

                System.out.println("Correct. All squares are open.");
            }
        }
    */
    public char updateSquare(int x, char c) { this.board[x-1]=c; return board[x-1];};

    public static void display(char board[]) {

        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("-" + " + " + "-" + " + " + "-");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("-" + " + " + "-" + " + " + "-");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }

    public ArrayList getOpenSquares() {return openSquares;}
    public static boolean isGameWon(char[] board) {
        GameBoard gameboard = new GameBoard();
        boolean flag=false;

        for (int i = 0; i < gameboard.winCombinations.length; i++) {
            int win[] = gameboard.winCombinations[i];
            char c1 = board[win[0] - 1];
            char c2 = board[win[1] - 1];
            char c3 = board[win[2] - 1];
            // System.out.println("c1="+c1+" C2="+c2+" c3="+c3);

            if (c1 == 'X' && c2 == 'X' && c3 == 'X') {

                System.out.println("X won");
                flag=true;
            } else if (c1 == 'O' && c2 == 'O' && c3 == 'O') {
                System.out.println("O won");
                flag=true;
            }

        }
        return flag;
    }

    public boolean isSquareOpen(int x) {
        if (board[x - 1] == 'x' || board[x - 1] == 'X'|| board[x-1] == 'O' || board[x-1] == 'o') {
            // System.out.println("match found!");
            // System.out.println("board[x-1]=" + board[x - 1]);
            return false;
        } else {
            // System.out.println("Match not found!");
            // System.out.println("board[x-1]=" + board[x - 1]);
            return true;
        }
    }
    public char getSquareValue(int x) {return board[x-1];}

/*
    public boolean IsSquareOpen(int x){
        if ( board[x-1])
        for (int i=1; i<=9; i++) {

        }
    } */
    public static void main(String[] args) {
        //testGameBoardDisplay();

        Scanner scan;
        scan = new Scanner(System.in);
        GameBoard gameboard = new GameBoard();



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


            //gameboard.board[0]='O';


            // gameboard.display(gameboard.board);

            // gameboard.display(gameboard.board);

        } else {
            System.out.println("response"+play_response);
            System.out.println("Exiting game...");
            System.exit(0);

        }
        gameboard.display(gameboard.board);
        System.out.println("-------------------------\n");
        


        gameboard.board[0]='O';
        gameboard.display(gameboard.board);
        gameboard.updateSquare(1,'O');

        ArrayList<Integer> openSquares = new ArrayList<Integer>();
        for(int i=1; i<=9; i++ ) {
            openSquares.add(new Integer(i));
        }

        for(int i=0; i<openSquares.size(); i++ ) {
           System.out.println(openSquares.get(i));
           }
        if (gameboard.isSquareOpen(1) == false ) {
            System.out.println("IsOpenSquare Is used up!");
        }
       System.out.println("board[1]="+gameboard.getSquareValue(1));
        if ( gameboard.isGameWon(gameboard.board)) {
            System.out.println("Game Over!");
        } else {
            System.out.println("Game not over!");
        }
        gameboard.updateSquare(2,'O');
        gameboard.updateSquare(3,'O');
        gameboard.display(gameboard.board);
        if ( gameboard.isGameWon(gameboard.board)) {
            System.out.println("Game Over!");
        } else {
            System.out.println("Game not over!");
        }
      /*  if ( gameboard.isGameWon(gameboard.board)) {
            System.out.println("Game Over!");
        } else {
            System.out.println("Game not over!");
        }
     */

    }
}