package edu.htc.tictactoe.players;

import java.util.Scanner;

/**
 * Created by Prince Roka on 3/7/2016.
 */
public class HumanPlayer extends Player {

    public HumanPlayer(String name, char gameMarker) {
        super(name, gameMarker);
    }

    Scanner ask = new Scanner(System.in);

    public int getMove() {
        int moveInt = 0;
        System.out.println("Where would you like to move? Enter a number 1 through 9: ");

        while (moveInt == 0) {
            String moveRqst = ask.next();
            try {
                moveInt = Integer.parseInt(moveRqst);
            } catch (NumberFormatException exStrToIntSuperman) {
                System.out.println("No Strings allowed.");
                System.out.println("Where would you like to move? Enter a number 1 through 9: ");
            }
        }

        while (outsideRange(moveInt)) {
            if (outsideRange(moveInt)) {
                System.out.println("You must enter a number 1 through 9");
            }

            moveInt = ask.nextInt();

        }
        return moveInt;
    }
}
