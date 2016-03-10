package edu.htc.tictactoe;
import edu.htc.tictactoe.stratagem.TicTacToeStrategy;

/**
 * Created by Prince Roka on 3/9/2016.
 */
public interface Ai {

    void Ai(int place);
    void setStrategy(TicTacToeStrategy strategy);
}
