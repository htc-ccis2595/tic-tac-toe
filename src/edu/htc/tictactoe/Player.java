package edu.htc.tictactoe;

import java.util.Scanner;

/**
 * Created by Prince Roka on 2/8/2016.
 */
public class Player {
    private String name;
    private char marker;
    private int winCounter;
    public int move;
    private Scanner scanner = new Scanner(System.in);

    public Player(String playerName, char playerMarker) {
        this.name = playerName;
        this.marker = playerMarker;
        this.winCounter = 0;
    }

    private void addWin() {
        winCounter++;
    }


    public void getMove() {
        System.out.println("Where would you like to move? Enter a number 1 through 9");
        int choice = scanner.nextInt();
        if (move > 0) {
            if (move < 10) {
                move = choice;
            }

        } else {
            System.out.println("YOU! You stumpy little keebler elf, you must choose a number from 1 to 9");
        }

    }

    public int getWinCounter() {
        return winCounter;
    }

    //Testing
    public static void main(String args[]) {
        Player newPlayer = new Player("Jeffafa", 'X');
        System.out.println("Player newPlayer = new Player('Jeffafa', 'X');");
        System.out.println("Player name is " + newPlayer.name + ".");
        System.out.println("The player's symbol is " + newPlayer.marker);
        System.out.println("Wins for " + newPlayer.name + " are " + newPlayer.getWinCounter() + ".");
        newPlayer.addWin();
        System.out.println("Wins for " + newPlayer.name + " are " + newPlayer.getWinCounter() + ".");
    }
}
