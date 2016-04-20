package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;
import edu.htc.tictactoe.player.*;
import java.util.Random;


/**
 * Created by cheey on 3/6/2016.
 */
public class BlockWinStrategy extends RandomMoveStrategy {

    private int[][] winCombination = {{1, 2, 3}, {1, 5, 9}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, {3, 5, 7}, {4, 5, 6}, {7, 8, 9}};

    public BlockWinStrategy(GameBoard game) {
        super(game);


    }

    @Override
    public int getBestMove() {
        return blockWin();
    }

    public int blockWin() {
        int blockWin = 0;
        for (int win[] : winCombination){

            int pos1 = win[0];
            int pos2 = win[1];
            int pos3 = win[2];


            char marker1 = game.getSquareValue(pos1);
            char marker2 = game.getSquareValue(pos2);
            char marker3 = game.getSquareValue(pos3);

            if (marker1 == 'X' && marker2 == 'X' && marker3 != 'X' && marker3 != 'O') {
                if (game.isSquareOpen(pos3)== true);
                return pos3;
            }
            else if (marker1 == 'X' && marker2 != 'X' && marker3 == 'X' && marker2 != 'O') {
                if (game.isSquareOpen(pos2)== true);
                return pos2;
            }
            else if (marker1 != 'X' && marker2 == 'X' && marker3 == 'X' && marker1 != 'O') {
                if (game.isSquareOpen(pos1)== true);
                return pos1;
            }

            else blockWin = getRandomMove();
        }
           return blockWin;

    }

}
