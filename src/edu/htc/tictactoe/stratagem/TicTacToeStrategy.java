package edu.htc.tictactoe.stratagem;
import edu.htc.tictactoe.*;
import edu.htc.tictactoe.players.*;
import java.util.*;

/**
 * Created by Prince Roka on 3/1/2016.
 */
public abstract class TicTacToeStrategy {
    GameBoard board;
    char playerMarker;

    public TicTacToeStrategy(GameBoard board, char playerMarker) {
        this.board = board;
        this.playerMarker = playerMarker;
    }

    //Win combos
    private int[][] winCombinations = {
            {1, 2, 3}, {4, 5, 6}, {7, 8, 9},
            {1, 4, 7}, {2, 5, 8}, {3, 6, 9},
            {1, 5, 9}, {3, 5, 7}
    };

    public abstract int getBestMove();


    //Random Move Strategy
    private Random rndm = new Random();

    protected int getRandomMove() {
        return board.getOpenSquares()[rndm.nextInt(board.getOpenSquares().length)];
    }


    //Best Open Move Strategy
    protected int getBestOpenMove() {
        int[] bestMoves = {5, 1, 3, 7, 9, 2, 4, 6, 8};

        for (int i = 0; i < 9; i++) {
            if (board.isSquareOpen(bestMoves[i])) {
                return bestMoves[i];
            }
        }System.out.println("getBestOpenMove Error");
        return getRandomMove();
    }


    //Block Win Strategy
    private char getEnemyMarker() {
        if (playerMarker == 'X') {
            return 'O';
        } else {
            return 'X';
        }
    }

    protected int getBlockWinStrategy() {
        char enemy = getEnemyMarker();

        for (int i = 0; i < winCombinations.length; i++) {
            int[] winSet = winCombinations[i];

            //Grabs char Value from board with Corresponding Sqr Number
            char one = board.getSquareValue(winSet[0]);
            char two = board.getSquareValue(winSet[1]);
            char three = board.getSquareValue(winSet[2]);

            //If Two Values of this Player's Marker are Found, Returns
            if (one == two || one == three || two == three) {
                if (one == enemy || two == enemy || three == enemy) {
                    if (one == two && board.isSquareOpen(winSet[2])) {
                        return winSet[2];
                    }
                    if (one == three && board.isSquareOpen(winSet[1])) {
                        return winSet[1];
                    }
                    if (two == three && board.isSquareOpen(winSet[0])) {
                        return winSet[0];
                    }
                }
            }
        }
        System.out.println("No win to block, switching to getBestOpenMove");
        return getBestOpenMove();
    }


    //Go for Win Strategy
    protected int getGoForWinStrategy() {
        for (int i = 0; i < winCombinations.length; i++) {
            int[] winSet = winCombinations[i];

            //Grabs char Value from board with Corresponding Sqr Number
            char one = board.getSquareValue(winSet[0]);
            char two = board.getSquareValue(winSet[1]);
            char three = board.getSquareValue(winSet[2]);

            //If Two Values of this Player's Marker are Found, Returns
            if (one == two || one == three || two == three) {
                if (one == playerMarker || two == playerMarker || three == playerMarker) {
                    if (one == two && board.isSquareOpen(winSet[2])) {
                        return winSet[2];
                    }
                    if (one == three && board.isSquareOpen(winSet[1])) {
                        return winSet[1];
                    }
                    if (two == three && board.isSquareOpen(winSet[0])) {
                        return winSet[0];
                    }
                }
            }
        }
        System.out.println("No winning move, switching to getBlockWinStrategy");
        return getBlockWinStrategy();
    }


    public static void main(String args[]) {
        int i;

        GameBoard board = new GameBoard();
        ComputerPlayer player2 = new ComputerPlayer("Player 2", 'X', new BestOpenMove(board, 'X'));

        board.display();
        for (i = 0; i < 9; i++) {
            board.updateSquare(player2.getMove(), player2.getMarker());
            board.display();
        }
    }
}