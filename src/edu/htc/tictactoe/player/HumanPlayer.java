package edu.htc.tictactoe.player;

import java.util.Scanner;

/**
 * Created by Owner on 2/28/2016.
 */
public class HumanPlayer extends Player {

    public HumanPlayer(String name, char gameMarker){
        super(name, gameMarker);
    }

    //method to get the square that the player wants to play in
    public int getMove(){
        Scanner scanner = new Scanner(System.in);
        int square = 0;
        while(true) {
            System.out.println("What square do you want to play " + getName() + "?");
            square = scanner.nextInt();
            if (square >= 1 && square <= 9) {
                return square;
            } else {
                System.out.println("Invalid entry:");
            }
        }
    }
}
