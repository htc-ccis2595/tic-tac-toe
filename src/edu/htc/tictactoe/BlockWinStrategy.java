package edu.htc.tictactoe;

/**
 * Created by Gyan on 3/17/2016.
 */
public class BlockWinStrategy extends TicTacToeStrategy {

    public BlockWinStrategy(GameBoard board){
        super(board);
    }

    @Override
    public int getBestMove(){
        return blockWinStrategy();
    }

    public int blockWinStrategy(){

        return blockWinStrategy();
    }

}
