package edu.htc.tictactoe.player;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Created by volkg_000 on 2/22/2016.
 */
public class HumanPlayer extends Player {
    private Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name, char marker) {
        super(name, marker);
    }

    public int getMove() {


        int pos = 0;
        while (pos > 9 || pos < 1) {
            System.out.println("Enter a number between 1 and 9 to play your marker: ");
            try {
                pos = Integer.parseInt(scanner.next());
            } catch (NumberFormatException exc) {
                System.out.println("Integer must be between 1 and 9!!!, you dingus!!!!");
            }

        }
        return pos;
    }
}

