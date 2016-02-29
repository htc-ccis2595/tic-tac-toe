package edu.htc.tictactoe.player;

import edu.htc.tictactoe.TicTacToe;

/**
 * Created by cheey on 2/23/2016.
 */
public class HumanPlayer extends Player{

    public HumanPlayer(String name, char gameMarker)
    {
        super (name, gameMarker);

    }

    public int getMove()

    {
        System.out.print(getName() + ", which square would you like to pick?");
        String getMoveInt = scanner.next();
        Integer getMove = Integer.parseInt(getMoveInt);
        if (getMove > 1 && getMove < 10)
            getMove = getMove;
        return getMove;

    }

}
