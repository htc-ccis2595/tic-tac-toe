package edu.htc.tictactoe.Strategy;
import edu.htc.tictactoe.GameBoard;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Sam on 3/14/2016.
 */
public abstract class TicTacToeStrategy {
    private static GameBoard stratboard;

    public TicTacToeStrategy(GameBoard board) {
        stratboard = board;
    }


    //abstract method for getting best move
    public abstract int getBestMove(GameBoard b);

    public static int getRandomMove(GameBoard b) {
        int index;
        int randomMove;
        Random move = new Random();
        ArrayList<Integer> openSqr = new ArrayList<Integer>();
        for (Integer integer : b.getOpenSquares()) {
            openSqr.add(integer);
        }

        index = move.nextInt(openSqr.size());
        randomMove = openSqr.get(index);
        return randomMove;
    }

    public static int getBestOpenMove(GameBoard b) {
        int index;
        int bestMove;
        Random move = new Random();
        ArrayList<Integer> openSquare = new ArrayList<Integer>();
        ArrayList<Integer> corners = new ArrayList<Integer>();

        for (Integer integer : b.getOpenSquares()) {
            openSquare.add(integer);

        }

        for (int i = 0;  i < openSquare.size(); i++){
            if (openSquare.get(i) == 1) corners.add(openSquare.get(i));
            else if (openSquare.get(i) == 3) corners.add(openSquare.get(i));
            else if (openSquare.get(i) == 7) corners.add(openSquare.get(i));
            else if (openSquare.get(i) == 9) corners.add(openSquare.get(i));

        }

        if (openSquare.contains(5)) {
            bestMove = 5;
            return bestMove;
        } else if (corners.size() > 0) {
            index = move.nextInt(corners.size());
            bestMove = corners.get(index);
            return bestMove;
        } else {
            index = move.nextInt(openSquare.size());
            bestMove = openSquare.get(index);
            return bestMove;
        }
    }

    public static int getBlockWinMove(GameBoard b) {
        int winCombinations[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 5, 9}, {3, 5, 7}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int bestMove = 0;
        for (int[] wincombo : winCombinations) {
            char char1 = b.getBoard()[wincombo[0]];
            char char2 = b.getBoard()[wincombo[1]];
            char char3 = b.getBoard()[wincombo[2]];
            //System.out.println("char1 = " + Character.getNumericValue(char1));
            //System.out.println("char2 = " + Character.getNumericValue(char2));
            //System.out.println("char3 = " + Character.getNumericValue(char3));

            if (char1 == char2) {
                bestMove = Character.getNumericValue(char3);
                break;
            } else if (char1 == char3) {
                bestMove = Character.getNumericValue(char2);
                break;
            } else if (char2 == char3) {
                bestMove = Character.getNumericValue(char1);
                break;
            } else {
                bestMove = getBestOpenMove(b);
            }
        }
        return bestMove;

    }

    public static int goForWin(GameBoard b, char mark) {
        int bestMove = 0;
        int winCombinations[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 5, 9}, {3, 5, 7}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        for (int[] wincombo : winCombinations) {
            char char1 = b.getBoard()[wincombo[0]];
            char char2 = b.getBoard()[wincombo[1]];
            char char3 = b.getBoard()[wincombo[2]];
            if (char1 == mark) {
                if (char1 == char2) {
                    bestMove = Character.getNumericValue(char3);
                    break;
                } else if (char1 == char3) {
                    bestMove = Character.getNumericValue(char2);
                    break;
                }
            }else if (char2 == mark){
                if (char2 == char3) {
                    bestMove = Character.getNumericValue(char1);
                    break;
                }
            }
        }
        if (bestMove == 0){
            bestMove = getBlockWinMove(b);
        }
        return bestMove;
    }


    public static void main(String[] Args) {
        int testMove;
        char boardArr[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        GameBoard boardclass = new GameBoard(boardArr);

        System.out.println("Updating board with x's in 1, 3, and 9 spots.");
        boardclass.updateSquare(1, 'x');
        boardclass.updateSquare(3, 'x');
        boardclass.updateSquare(9, 'x');

        System.out.println("Checking getRandomMove:");
        for (int i = 0; i < 20; i++) {
            testMove = getRandomMove(boardclass);
            if (!boardclass.isSquareOpen(testMove)) System.out.println("Failure");
            else System.out.println("Success " + testMove);
        }

        System.out.println("Checking getBestOpenMove. Since middle is open, answer should always be 5:");
        for (int i = 0; i < 10; i++) {
            testMove = getBestOpenMove(boardclass);
            if (!boardclass.isSquareOpen(testMove)) System.out.println("Failure");
            else System.out.println("Success " + testMove);
        }
        System.out.println("Claiming middle square with 'o'. Testing getBestOpenMove. 7 is the only corner open");
        //boardclass.updateSquare(5, 'o');
        for (int i = 0; i < 5; i++) {
            testMove = getBestOpenMove(boardclass);
            if (!boardclass.isSquareOpen(testMove)) System.out.println("Failure");
            else System.out.println("Success " + testMove);
        }
        System.out.println("Testing BlockWinStrategy. Since 1 and 3 are x's. Expected output is 2 ");
        for (int i = 0; i < 20; i++) {
            testMove = getBlockWinMove(boardclass);
            if (!boardclass.isSquareOpen(testMove)) System.out.println("Failure" + testMove);
            else System.out.println("Success " + testMove);
        }

        System.out.println("Testing go for win");
        for (int i = 0; i < 20; i++) {
            testMove = goForWin(boardclass, 'x');
            if (!boardclass.isSquareOpen(testMove)) System.out.println("Failure" + testMove);
            else System.out.println("Success " + testMove);
        }
    }
}
