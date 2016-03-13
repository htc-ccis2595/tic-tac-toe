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
        Integer intPickedSquare=0;
        int index=0;
        Integer randomInt = 0;


        int IntBestOpenMove = 0;
        //** First look at the center spot, and select that if it is open
        //** Center square is actually location 4 on the board
        if (board.isSquareOpen(4)) {
            IntBestOpenMove = 4;
            return IntBestOpenMove;
        }
        //** Second find all open corners and
        //** then choose a random one
        //** The corner will have locations 1,3,7,9
        //** Put these locations into a list array.  If the square is open,
        //** we will add it to the array.
        ArrayList<Integer> openCorners = new ArrayList<>();

        if (board.isSquareOpen(0)){
            openCorners.add(1);
        }
        if (board.isSquareOpen(2)){
            openCorners.add(3);
        }
        if (board.isSquareOpen(6)){
            openCorners.add(7);
        }
        if (board.isSquareOpen(8)){
            openCorners.add(9);
        }

        //** if the number of elements in the array is greater that zero,
        //** pick a random corner
        if (openCorners.size() > 1) {
            // create a new Java Random object
            Random randomGenerator = new Random();
            randomInt = 0;
            boolean blnIsOpen = false;
            boolean blnExit;
            boolean blnValid = false;
            // get the next random int
            index = randomGenerator.nextInt(openCorners.size());
            intPickedSquare = openCorners.get(index);
            //** picked square needs to be adjusted so the marker goes into the right square
            intPickedSquare--;
            return intPickedSquare;
        }

        if (openCorners.size() == 1) {
            intPickedSquare = openCorners.get(index);
            //** picked square needs to be adjusted so the marker goes into the right square
            intPickedSquare--;
            return intPickedSquare;
        }
             //** if the center and corners are not taken, then
            //** then check the middle squares

            //** Third find all open middles and
            //** then choose a random one
            //** The middles will have locations 2,4,6,8
            //** Put these locations into a list array.  If the square is open,
            //** we will add it to the array.
        ArrayList<Integer> openMiddles = new ArrayList<>();
        if (board.isSquareOpen(1)){
                openMiddles.add(1);
            }
        if (board.isSquareOpen(3)){
                openMiddles.add(3);
            }
        if (board.isSquareOpen(5)){
                openMiddles.add(5);
            }
        if (board.isSquareOpen(7)){
                openMiddles.add(7);
            }

            //** if the number of elements in the array is greater that zero,
            //** pick a random corner
        if (openMiddles.size() > 0) {
                // create a new Java Random object
                Random randomGenerator = new Random();
                 // get the next random int
                index = randomGenerator.nextInt(openMiddles.size());
                intPickedSquare = openMiddles.get(index);
                //** picked square needs to be adjusted so the marker goes into the right square
                //**intPickedSquare--;
            }
        return intPickedSquare;

    }
    }




    //** First look at the center spot, and select that if it is open

    //** Second find all open corners and select a random corner

    //** Third if the center and corners are not taken, take a random square


