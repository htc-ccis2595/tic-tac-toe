package edu.htc.tictactoe.player;

import edu.htc.tictactoe.TicTacToe;

import java.util.Scanner;

/**
 * Created by cheey on 2/9/2016.
 */
public abstract class Player {

    private String Name;
    private char gameMarker;
    private int winCounter;

    public Player (String name, char gameMarker)
    {
        this.Name = name;
        this.gameMarker = gameMarker;
    }

    public void setName(String name) {
        Name = name;
    }

    public char getGameMarker() {
        return gameMarker;
    }

    public void setGameMarker(char gameMarker) {
        this.gameMarker = gameMarker;
    }


    //Player player2 = new Player();

    Scanner scanner = new Scanner(System.in);

    public String getName()
    {
        //System.out.print("Enter Name: "); //In tictactoe class
        //String Name = scanner.next();
        return Name;
    }

    public char getMarker()
    {
        //System.out.print("Marker: x or o?");
        //String gameMarkerStr = scanner.next();
        //char gameMarker = gameMarkerStr.charAt(0);
        return gameMarker;
    }

    public int getWinCount()
    {
        int winCounter = 0;
        winCounter += addWin();
        return winCounter;
    }

    public abstract int getMove();
//    {
//
//        System.out.print("Which square would you like to pick?");
//        String getMoveInt = scanner.next();
//        Integer getMove = Integer.parseInt(getMoveInt);
//
//        while (getMove < 1 || getMove > 9) {
//            getMove = getMove;
//            System.out.print("Pick a square: 1 through 9");
//             getMoveInt = scanner.next();
//             getMove = Integer.parseInt(getMoveInt);
//        }
//        return getMove;
//    }

    public int addWin()
    {
        int winCounter = 0;
        winCounter +=  winCounter;
        return winCounter;
    }

    public static void main(String[] args) {
//
//        Player player1 = new Player("Chee", 'X');
//        int move = player1.getMove();
//        System.out.println("Picked" + move);
//        player1.getMove();

    }


}
