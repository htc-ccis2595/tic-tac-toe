package edu.htc.tictactoe.player;

import edu.htc.tictactoe.GameBoard;
import edu.htc.tictactoe.strategy.RandomMoveStrategy;
import edu.htc.tictactoe.strategy.TicTacToeStrategy;

/**
 * Created by Owner on 2/28/2016.
 */
public class ComputerPlayer extends Player {

    TicTacToeStrategy ticTacToeStrategy;
    public ComputerPlayer(String name, char gameMarker, GameBoard board) {
        super(name, gameMarker);
        ticTacToeStrategy = new RandomMoveStrategy(board);
    }

    @Override
    public int getMove() {
        return ticTacToeStrategy.getBestMove();
    }
}
