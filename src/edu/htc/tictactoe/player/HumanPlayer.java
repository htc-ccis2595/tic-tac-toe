package edu.htc.tictactoe.player;

import java.util.Scanner;

/**
 * Created by Sam on 3/14/2016.
 */
public class HumanPlayer extends Player {

    public int getMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the square you want to play:");
        return scanner.nextInt();
    }

    public HumanPlayer(String n, char m) {
        super(n, m);
    }
}




