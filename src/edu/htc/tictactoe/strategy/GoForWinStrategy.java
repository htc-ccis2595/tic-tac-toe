package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;

/**
 * Created by cheey on 3/6/2016.
 */
public class GoForWinStrategy extends TicTacToeStrategy {
    GameBoard game;
    char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private int[][] winCombination = {{1, 2, 3}, {1, 5, 9}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, {3, 5, 7}, {4, 5, 6}, {7, 8, 9}};

    public GoForWinStrategy(GameBoard game)
    {
        super(game);
    }

    @Override
    public int getBestMove() {
        return goForWin();
    }

    public int goForWin()
    {
        for (int win[] : winCombination) {
            int pos1 = win[0];
            int pos2 = win[1];
            int pos3 = win[2];

            char marker1 =  board[pos1-1];
            char marker2 =  board[pos2-1];
            char marker3 = board[pos3 - 1];

            if (marker1 == 'O' && marker2 == 'O') {
                return pos3;
            }

        }
        return 0;

    }
}
