package edu.htc.tictactoe.player;

import edu.htc.tictactoe.GameBoard;
import edu.htc.tictactoe.strategy.TicTacToeStrategy;

/**
 * Created by clifford.mauer on 2/8/2016.
 */
public class ComputerPlayer {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGameMarker() {
        return gameMarker;
    }

    public void setGameMarker(char gameMarker) {
        this.gameMarker = gameMarker;
    }

    public int getWinCounter() {
        return winCounter;
    }

    public void setWinCounter(int winCounter) {
        this.winCounter = winCounter++;
    }

    public String name;
    char gameMarker;
    public int winCounter;
    public boolean isCurrentPlayer;

    TicTacToeStrategy strategy = new TicTacToeStrategy() {
        @Override
        public int getBestMove(GameBoard board, char gameMarker) {
            int IntReturnMove;

            IntReturnMove = getRandomMove(board);
            return IntReturnMove;
        }
    };

    public int getMove(GameBoard board, char gameMarker){

        int IntReturnMove;

        IntReturnMove = strategy.getBestMove(board,gameMarker);

        System.out.println(this.name+"'s move has been set to : " + IntReturnMove);

        return IntReturnMove;


    }
}
