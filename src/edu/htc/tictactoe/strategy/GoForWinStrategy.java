package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;
import edu.htc.tictactoe.player.ComputerPlayer;

/**
 * Created by cheey on 3/6/2016.
 */
public class GoForWinStrategy extends BlockWinStrategy {

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
        int goWin = 0;
        for (int win[] : winCombination) {
            int pos1 = win[0];
            int pos2 = win[1];
            int pos3 = win[2];

            char marker1 = game.getSquareValue(pos1);
            char marker2 = game.getSquareValue(pos2);
            char marker3 = game.getSquareValue(pos3);

            if (marker1 == 'O' && marker2 != 'X' && marker2 != 'O') {
                if (game.isSquareOpen(pos2)== true);
                return pos2;
            }
            else if (marker1 == 'O' && marker2 == 'O' && marker3 != '0' && marker3 != 'X') {
                if (game.isSquareOpen(pos3)== true);
                return pos3;
            }

            else goWin = blockWin();
        }
        return goWin;

    }
}
