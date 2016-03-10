package edu.htc.tictactoe.players;
import edu.htc.tictactoe.*;
import edu.htc.tictactoe.stratagem.*;

/**
 * Created by Prince Roka on 3/7/2016.
 */
public class ComputerPlayer extends Player implements Ai{
    TicTacToeStrategy strategy;

    public ComputerPlayer(String name, char gameMarker, TicTacToeStrategy strategy) {
        super(name, gameMarker);
        this.strategy = strategy;
    }

    public void setStrategy(TicTacToeStrategy strategy) {
        this.strategy = strategy;
    }

    public void Ai(int place) {
        System.out.println(this.getName() + " placed a marker on square " + place);
    }

    public int getMove() {
        return strategy.getBestMove();
    }

    public static void main(String args[]) {

        GameBoard board = new GameBoard();
        TicTacToe ticTacToe = new TicTacToe();
        ComputerPlayer tom = new ComputerPlayer("Tom", 'x', new RandomMoveStrategy(board, 'x'));

        System.out.println("Strategy: ");
        System.out.println(tom.strategy);
        System.out.println();

        System.out.println("Next Move");
        System.out.println(tom.getMove());
    }
}