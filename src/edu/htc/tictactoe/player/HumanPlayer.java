package edu.htc.tictactoe.player;

import java.util.Scanner;

/**
 * Created by Sam on 3/14/2016.
 */
public class HumanPlayer extends Player {

    public int getMove() {
        Scanner scanner = new Scanner(System.in);
        int move = 0;
        do {
            System.out.println("Please enter the square you want to play:");
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("That input was not valid. Please try again.");
            }

            try {
              move = Integer.parseInt(scanner.next());

            } catch (NumberFormatException e) {
                System.out.println("Please enter a value of an open square: 1-9");
            } catch (Exception other) {
                System.out.println("Something happened.");
            }
        }while (move < 1 || move > 9 );
        return move;
        }

    public HumanPlayer(String n, char m) {
        super(n, m);
    }
}




