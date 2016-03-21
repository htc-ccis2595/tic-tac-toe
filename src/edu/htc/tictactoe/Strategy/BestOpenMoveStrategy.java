package edu.htc.tictactoe.Strategy;
import edu.htc.tictactoe.GameBoard;


/**
 * Created by Sam on 3/16/2016.
 */
public class BestOpenMoveStrategy extends TicTacToeStrategy {
    private GameBoard BOMboard;

    public BestOpenMoveStrategy(GameBoard board) {
        super(board);
        BOMboard = board;
    }

    @Override
    public int getBestMove(GameBoard BOMboard) {
        int move = getBestOpenMove(BOMboard);
        return move;
    }
}



