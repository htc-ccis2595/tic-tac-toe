package edu.htc.tictactoe.player;

import edu.htc.tictactoe.GameBoard;
import edu.htc.tictactoe.strategy.*;

/**
 * Created by cheey on 2/23/2016.
 */
public class ComputerPlayer extends Player {
    //GameBoard game;

    TicTacToeStrategy strategy;
    //RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();

    public ComputerPlayer(String compName, char compMarker)
                          //TicTacToeStrategy strategy)
        {
            super(compName, compMarker);
            this.strategy = strategy;

        }

    public int getMove()

        {
//            System.out.print(getName() + "picks square " + randomMoveStrategy.getRandomMove());
//            String getMoveInt = ComputerPlayer.next();
//            Integer getMove = Integer.parseInt(getMoveInt);
//            if (getMove > 1 && getMove < 10)
//                getMove = getMove;
//             return 0;

            return  strategy.getBestMove();



        }








}
