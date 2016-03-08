package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by clifford.mauer on 2/8/2016.
 */
public abstract class BestOpenMoveStrategy extends TicTacToeStrategy {

    public int getBestOpenMove(GameBoard board) {
        // Move will be a number from 1 to 9 which will represent the
        // actual location on the board.  So, as long as IntBestOpenMove is 0,
        // no move decision has been made yet.

        int IntBestOpenMove = 0;
        //** First look at the center spot, and select that if it is open
        //** Center square is actually location 4 on the board
        if (board.isSquareOpen(4)){
            IntBestOpenMove = 5;
            return IntBestOpenMove;
        }
        //** Second find all open corners and
        //** then choose a random one
        //** The corner will have locations 1,3,7,9
        //** Put these locations into a list array.  If the square is open,
        //** we will add it to the array.
        ArrayList<Integer> openCorners = new ArrayList<>();
        openCorners.add(1);
        openCorners.add(3);
        openCorners.add(7);
        openCorners.add(9);

        for (int j = 0; j < openCorners.size() ; j++) {
            //** if square is not open, remove it from the array
            if (!board.isSquareOpen(j)){
                openCorners.remove(j);
            }
        }

         //** if the number of elements in the array is greater that zero,
        //** pick a random corner
        if (openCorners.size()>0) {
            Integer intArraySize = openCorners.size();
            // create a new Java Random object
            Random random = new Random();
            Integer randomInt = 0;
            boolean blnIsOpen = false;
            boolean blnExit;

            // get the next random int
            randomInt = random.nextInt(4);
            if (randomInt > 0 && randomInt < openCorners.size()) {
                IntBestOpenMove = openCorners.get(randomInt);
            }
        }
            //** if the center and corners are not taken, then
            //** then check the middle squares

        //** Third find all open middles and
        //** then choose a random one
        //** The middles will have locations 2,4,6,8
        //** Put these locations into a list array.  If the square is open,
        //** we will add it to the array.
        ArrayList<Integer> openMiddles = new ArrayList<>();
        openCorners.add(2);
        openCorners.add(4);
        openCorners.add(6);
        openCorners.add(8);

        for ( int i : openMiddles   ) {
            //** if square is not open, remove it from the array
            if (!board.isSquareOpen(i)){
                openMiddles.remove(i);
            }
        }

        //** if the number of elements in the array is greater that zero,
        //** pick a random corner
        if (openMiddles.size()>0) {
            Integer intArraySize = openMiddles.size();
            // create a new Java Random object
            Random random = new Random();
            Integer randomInt = 0;
            boolean blnValid = false;
            // get the next random int
            do {
                randomInt = random.nextInt(openMiddles.size());
                if (randomInt > 0 && randomInt < 4) {
                    IntBestOpenMove = openMiddles.get(randomInt);
                    if (board.isSquareOpen(IntBestOpenMove)){
                        blnValid = true;
                    }
                }
            } while (!blnValid);
        }
        return IntBestOpenMove;
    }



    //** First look at the center spot, and select that if it is open

    //** Second find all open corners and select a random corner

    //** Third if the center and corners are not taken, take a random square
    }


