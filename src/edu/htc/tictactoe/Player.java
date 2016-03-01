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

  /*  public void setPlayer() {
        Player  players[]= new Player[2];

        for (int i=0; i < 2; i++){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Player Name: ");
            String playerName = scanner.next();

            System.out.println("Player Name=" + playerName);
            players[i] = new Player(playerName,'X');
        }*/



//        System.out.println("Enter Player Name: ");
//        String playerName = scanner.next();
//        System.out.println("Player Name=" + playerName);
//        players[1] = new Player(playerName,'O');
       /*  Scanner scanner2 = new Scanner(System.in);
        for (int i=0; i<1 ; i++) {
            Scanner scanner = new Scanner(System.in);
            String PlayerName = scanner.next();
        }
            System.out.println("Enter Player Name: ");
            String PlayerName = scanner.next();


        }
    } */
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
    public int addWin() { return winCounter++; }
    public static void main(String[] args) {

        // Player[] players = new Player[2];

        //players[0] = new Player("Peter",'X');
        // players[1] = new Player("Jack",'O');

        /* for (int i=0; i<2 ; i++) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String = scanner.nextLine();
            while ( String == null) {
                System.out.println("You have entered invalid name, Enter your name: ");
                String = scanner.nextLine();
            }

        Marker scanner= new Marker(System.in);
            System.out.println("Enter Marker of either O or X: ");
            Char = scanner.next();
            
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Marker either X or O: ");

        */

        Player  players[]= new Player[2];

        for (int i=0; i < 2; i++){
            Scanner scanner = new Scanner(System.in);
            String playerName = null;
            System.out.println("Enter Player Name: ");
            playerName = scanner.next();
            if ( playerName == null ){ System.out.println(" Playername is null!"); }


            if ( playerName.trim().isEmpty() ){ System.out.println(" Playername is empty!"); }
            if ( playerName.length() == 0 ) { System.out.println("Length is o");}
               while ( (playerName == null )|| (playerName.trim().isEmpty()) ) {
                   System.out.println("Entry invalid, enter non-null name: ");
                   playerName = scanner.next();
               }


             System.out.println("Enter Marker: Either X or O ");
            char playerMarker = scanner.next().trim().charAt(0);
            System.out.println("playerMarker="+playerMarker);

            while ( playerMarker != 'X' || playerMarker != 'x'  || playerMarker != 'O'  ||  playerMarker != 'o') {
                System.out.println("Entry invalid, enter X or O only: ");
                playerMarker = scanner.next().trim().charAt(0);
                System.out.println("playerMarker="+playerMarker);
            }


            System.out.println("Player Name=" + playerName);
            players[i] = new Player(playerName,playerMarker);
        }

        for (int i = 0; i<2 ; i++ ) {

            System.out.println(" players[" + i + "] => Name = " + players[i].getName() + ", Marker= " + players[i].getMarker() + ", Win Counter= " + players[i].getWinCount());
//            System.out.println(" Move to: " + Gameplayers[i].getMove() );
//            System.out.println(" Current winCount=" + players[i].getWinCount() + "After winning: winConter= " + players[i].addWin() + " ");
//            System.out.println("Win counter="+players[i].addWin());
//            System.out.println("Win counter="+players[i].addWin());
//            System.out.println("Win counter now="+players[i].getWinCount());

        }

    }


}
