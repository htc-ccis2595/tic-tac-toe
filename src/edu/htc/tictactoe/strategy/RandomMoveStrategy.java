package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;

/**
 * Created by clifford.mauer on 2/8/2016.
 */
public class RandomMoveStrategy extends TicTacToeStrategy {

    public int getBestMove(GameBoard board, char gameMarker) {
            //For a Level 1 computer player, the move will be random.
            int IntBestMove;
            IntBestMove = getRandomMove(board);
            return IntBestMove;

        }
    }
