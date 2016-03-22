package edu.htc.tictactoe.player;

import edu.htc.tictactoe.GameBoard;
import edu.htc.tictactoe.strategy.*;

/**
 * Created by Owner on 2/28/2016.
 */
public class ComputerPlayer extends Player {

    TicTacToeStrategy ticTacToeStrategy;
    char playerMarker;
    public ComputerPlayer(String name, char gameMarker, GameBoard board, int gameLevel) {
        super(name, gameMarker);
        if(gameMarker == 'X' || gameMarker == 'x')
        {
            playerMarker = 'O';
        }
        else
        {
            playerMarker = 'X';
        }
        if (gameLevel == 4){
            ticTacToeStrategy = new GoForWinStrategy(board, gameMarker, playerMarker);
        }
        else if (gameLevel == 3){
            ticTacToeStrategy = new BlockWinStrategy(board, gameMarker, playerMarker);
        }
        else if (gameLevel == 2){
            ticTacToeStrategy = new BestOpenMoveStrategy(board, gameMarker, playerMarker);
        }
        else {
            ticTacToeStrategy = new RandomMoveStrategy(board, gameMarker, playerMarker);
        }
    }

    @Override
    public int getMove() {
        return ticTacToeStrategy.getBestMove();
    }
}
