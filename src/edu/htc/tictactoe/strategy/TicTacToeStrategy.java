package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;

import java.util.Random;

/**
 * Created by Owner on 2/28/2016.
 */
public abstract class TicTacToeStrategy {
    protected GameBoard board;
    private Random random = new Random();
    char playerMarker;
    char computerMarker;
    private int[][] winCombinations = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, {1, 5, 9}, {3, 5, 7}};

    public TicTacToeStrategy(GameBoard board, char computerMarker, char playerMarker) {
        this.board = board;
        this.playerMarker = playerMarker;
        this.computerMarker = computerMarker;
    }

    public abstract int getBestMove();

    protected int getRandomMove() {
        int[] openSquares = board.getOpenSquares();
        if (openSquares.length == 0) {
            return 0;
        }
        int randomIndex = random.nextInt(openSquares.length);
        return openSquares[randomIndex];
    }

    protected int getBestOpenMove() {
        int[] openSquares = board.getOpenSquares();
        if (board.isSquareOpen(5)) {
            return 5;
        } else if (board.isSquareOpen(1)) {
            return 1;
        } else if (board.isSquareOpen(3)) {
            return 3;
        } else if (board.isSquareOpen(7)) {
            return 7;
        } else if (board.isSquareOpen(9)) {
            return 9;
        } else {
            return getRandomMove();
        }
    }

    protected int getBlockWinMove() {
        char[] playerSquares = board.getSquaresForMarker(playerMarker);
        for (int[] winCombination : winCombinations) {

            if (playerSquares[winCombination[0] - 1] == playerMarker && playerSquares[winCombination[1] - 1] == playerMarker) {

                if (board.isSquareOpen(winCombination[2])) {

                    return winCombination[2];
                }
            } else if (playerSquares[winCombination[0] - 1] == playerMarker && playerSquares[winCombination[2] - 1] == playerMarker) {

                if (board.isSquareOpen(winCombination[1])) {

                    return winCombination[1];
                }
            } else if (playerSquares[winCombination[1] - 1] == playerMarker && playerSquares[winCombination[2] - 1] == playerMarker) {

                if (board.isSquareOpen(winCombination[0])) {

                    return winCombination[0];
                }
            }
        }
        return getBestOpenMove();

    }

    protected int getGoForWinMove() {
        char[] playerSquares = board.getSquaresForMarker(computerMarker);
        for (int[] winCombination : winCombinations) {

            if (playerSquares[winCombination[0] - 1] == computerMarker && playerSquares[winCombination[1] - 1] == computerMarker) {

                if (board.isSquareOpen(winCombination[2])) {

                    return winCombination[2];
                }
            } else if (playerSquares[winCombination[0] - 1] == computerMarker && playerSquares[winCombination[2] - 1] == computerMarker) {

                if (board.isSquareOpen(winCombination[1])) {

                    return winCombination[1];
                }
            } else if (playerSquares[winCombination[1] - 1] == computerMarker && playerSquares[winCombination[2] - 1] == computerMarker) {

                if (board.isSquareOpen(winCombination[0])) {

                    return winCombination[0];
                }
            }

        }
        return getBlockWinMove();

    }

    public static void main(String[] args) {
        testGetRandomMove();
    }

    private static void testGetRandomMove() {
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println("Testing GetRandomMove Method");
        GameBoard board = new GameBoard(new char[]{'X', '2', '3', 'X', '5', 'O', '7', 'O', '9'});

        //Creates anonymous inner class with dummy getBestMove behavior
        TicTacToeStrategy strategy = new TicTacToeStrategy(board, 'O', 'X') {
            @Override
            public int getBestMove() {
                return 0;
            }
        };

        //Since result is random, testing multiple times to validate good output
        boolean error = false;
        int numberOfRuns = 50;
        for (int i = 0; i < numberOfRuns; i++) {
            int result = strategy.getRandomMove();
            if (result < 1 || result > 9) {
                error = true;
                System.out.println("Error! Result " + result + " is out of bounds. Must be between 1 and 9");
            } else if (!board.isSquareOpen(result)) {
                error = true;
                System.out.println("Error! Square " + result + "is not open!");
            }
        }
        if (!error) {
            System.out.println("No bad output was found in " + numberOfRuns + " tries.");
        }
    }
}


