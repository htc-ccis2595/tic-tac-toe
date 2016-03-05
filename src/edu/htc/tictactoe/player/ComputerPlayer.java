package edu.htc.tictactoe.player;

import edu.htc.tictactoe.TicTacToe;
import edu.htc.tictactoe.strategy.TicTacToeStrategy;

/**
 * Created by volkg_000 on 2/23/2016.
 */
public class ComputerPlayer extends Player {
    TicTacToeStrategy strategy;

    public ComputerPlayer(String name, char marker, TicTacToeStrategy strategy) {
        super(name, marker);
        this.strategy = strategy;

    }

    public TicTacToeStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(TicTacToeStrategy strategy) {
        this.strategy = strategy;
    }

    public int getMove() {

        return strategy.getBestMove(); }


    }




