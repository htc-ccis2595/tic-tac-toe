package edu.htc.tictactoe.player;

import java.util.Scanner;

/**
 * Created by cheey on 2/23/2016.
 */
public class HumanPlayer extends Player{

    public HumanPlayer(String name, char gameMarker)
    {
        super (name, gameMarker);

    }
    Scanner humanPlayer = new Scanner(System.in);

    public int getMove()

    {
        System.out.print(getName() + ", which square would you like to pick?");

        int getMove = 0;
        while(getMove > 9 || getMove < 1){
          try{

                getMove = Integer.parseInt(humanPlayer.next());}
            catch (NumberFormatException e){
                System.out.println("You didnt enter a number.");
                System.out.println("Please enter a number between 1 and 9");
            }
        }
            return getMove;
    }

}
