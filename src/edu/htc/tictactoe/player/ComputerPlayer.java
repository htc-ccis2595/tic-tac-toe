package edu.htc.tictactoe.player;

import edu.htc.tictactoe.GameBoard;

import edu.htc.tictactoe.strategy.*;


/**
 * Created by cheey on 2/23/2016.
 */
public class ComputerPlayer extends Player {
    GameBoard game;

    TicTacToeStrategy strategy;

    public ComputerPlayer(String compName, char compMarker, TicTacToeStrategy strategy)
                          
        {
            super(compName, compMarker);
            this.strategy = strategy;
        }

    public TicTacToeStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(TicTacToeStrategy strategy) {
        this.strategy = strategy;
    }

    public int getMove()

        {
            return  strategy.getBestMove();
        }








}
