package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;


/**
 * Created by volkg_000 on 3/3/2016.
 */
public class BlockWinStrategy extends TicTacToeStrategy {
    private int winCombinations[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9},
            {1, 5, 9}, {3, 6, 9}, {2, 5, 8}, {1, 4, 7}, {3, 5, 7}};
    private char marker;

    public BlockWinStrategy(GameBoard gameboard, char marker) {
        super(gameboard);
        this.marker = marker;
    }

    public int getBestMove() {
        return getBlockWinMove();
    }

    public char getMarker() {
        return marker;
    }

    public char getOpponentMarker() {
        if(marker == 'O') {
            return 'X';
        }
        else {
            return 'O';
        }

    }



    protected int findWinFor(char marker) {


        int i;
        for (i = 0; i < winCombinations.length; i++) {
            int[] possiblewin = winCombinations[i];

            int squarenum = possiblewin[0];
            char squarevalue = gameboard.getSquareValue(squarenum);
            int squarenum2 = possiblewin[1];
            char squarevalue2 = gameboard.getSquareValue(squarenum2);
            int squarenum3 = possiblewin[2];
            char squarevalue3 = gameboard.getSquareValue(squarenum3);
            if (squarevalue == squarevalue2 && squarevalue2 == marker && squarevalue2 != squarevalue3) {
                if(gameboard.isSquareOpen(squarenum3) == true) {
                    return squarenum3;
                }

            }
            if (squarevalue == squarevalue3 && squarevalue3 == marker && squarevalue2 != squarevalue3) {
                if(gameboard.isSquareOpen(squarenum2) == true) {
                    return squarenum2;
                }

            }
            if (squarevalue2 == squarevalue3 && squarevalue3 == marker && squarevalue != squarevalue3) {
                if(gameboard.isSquareOpen(squarenum) == true) {
                    return squarenum;
                }

            }



        }
        return 0;
    }

    protected int getBlockWinMove() {
        int possiblewin = findWinFor(getOpponentMarker());
        if(possiblewin == 0) {
            return getBestOpenMove();
        }
        else {
            return possiblewin;
        }
    }
}