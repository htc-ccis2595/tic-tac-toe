package edu.htc.tictactoe;

/**
 * Created by Gyan on 2/21/2016.
 */
public class ComputerPlayer extends Player{

    TicTacToeStrategy gameStrategy;
    public ComputerPlayer(String name, char gameMarker, GameBoard board){
        super(name, gameMarker);
        gameStrategy = new RandomMoveStrategy(board);
    }

    @Override
    public int getMove(){
        return gameStrategy.getBestMove();
    }
}

