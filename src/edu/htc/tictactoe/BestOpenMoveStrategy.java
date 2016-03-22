package edu.htc.tictactoe;

import java.util.Random;

/**
 * Created by Gyan on 3/17/2016.
 */
public class BestOpenMoveStrategy extends RandomMoveStrategy {

        public BestOpenMoveStrategy(GameBoard board)
    {
        super(board);

    }


    public int getBestOpenMove() {
        GameBoard board = new GameBoard();
        int bestOpenMove =0;
        {
            if(board.isSquareOpen(5)== true) {
                bestOpenMove = 5;
            }else if(board.isSquareOpen(1) == true ){
                bestOpenMove = 1;
            }else if(board.isSquareOpen(7) == true){
                bestOpenMove = 7;
            }else if(board.isSquareOpen(3) == true){
                bestOpenMove = 3;
            }else if(board.isSquareOpen(9)==true){
                bestOpenMove = 9;
            }else getRandomMove();

            return bestOpenMove;
        }
    }
}
