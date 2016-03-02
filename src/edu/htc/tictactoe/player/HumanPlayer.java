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
        String getMoveInt = humanPlayer.next();
        Integer getMove = Integer.parseInt(getMoveInt);
        if (getMove > 1 && getMove < 10)
            getMove = getMove;
        return getMove;

    }

}
