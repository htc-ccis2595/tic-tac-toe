package edu.htc.tictactoe.player;
import edu.htc.tictactoe.GameBoard;
import edu.htc.tictactoe.Strategy.BestOpenMoveStrategy;
import edu.htc.tictactoe.Strategy.BlockWinStategy;
import edu.htc.tictactoe.Strategy.GoForWinStrategy;
import edu.htc.tictactoe.Strategy.RandomMoveStrategy;

/**
 * Created by Sam on 3/14/2016.
 */
public class ComputerPlayer extends Player {
    private GameBoard compboard;
    private int d;
    public ComputerPlayer(String n, char m, GameBoard b, int difficulty) {
        super(n, m);
        compboard = b;
        d = difficulty;
    }

    @Override
    public int getMove() {
        int bestMove = 0;
        if (d == 1) {
            RandomMoveStrategy compStrategy = new RandomMoveStrategy(compboard);
            bestMove = compStrategy.getBestMove(compboard);
        } else if (d == 2) {
            BestOpenMoveStrategy compStrategy = new BestOpenMoveStrategy(compboard);
            bestMove = compStrategy.getBestMove(compboard);
        } else if (d == 3) {
            BlockWinStategy compStrategy = new BlockWinStategy(compboard);
            bestMove = compStrategy.getBestMove(compboard);
        } else if (d == 4) {
            GoForWinStrategy compStrategy = new GoForWinStrategy(compboard);
            bestMove = compStrategy.getBestMove(compboard);
        }
        return bestMove;
    }
}
