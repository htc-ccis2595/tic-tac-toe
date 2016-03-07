package edu.htc.tictactoe.players;

import edu.htc.tictactoe.GameBoard;
import edu.htc.tictactoe.players.*;

import java.util.Scanner;

/**
 * Created by Prince Roka on 3/7/2016.
 */
public class HumanPlayer extends Player {

    public HumanPlayer(String name, char gameMarker) {
        super(name, gameMarker);
    }

    Scanner scanner = new Scanner(System.in);

    public int getMove() {
        int moveInt = 0;
        System.out.println();
        System.out.println("Where would you like to move? Enter a number 1 through 9: ");

        while (outsideRange(moveInt)) {
            moveInt = scanner.nextInt();
            if (outsideRange(moveInt)) {
                System.out.println("You must enter a number 1 through 9");
            }
        }
        return moveInt;
    }
}
