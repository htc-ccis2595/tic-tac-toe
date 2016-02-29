package edu.htc.tictactoe.player;
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

            System.out.println("Hello user, enter a number between 1 and 9 to play your marker: ");
            int pos = scanner.nextInt();
            while(pos > 9 || pos < 1) {
                System.out.println("You dingus, type a number greater than 1 and less than 9!");
                pos = scanner.nextInt();
            }

            return pos;
        }
    }

