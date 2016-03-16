package edu.htc.tictactoe;
import java.util.Random;

public class Stratagy {


    public static int randomMove() {
     Random myRandom = new Random();
        boolean check = false;
        int value = 0;
        while(check == false){
          value = myRandom.nextInt(8);
            if(GameBoard.boardVals.get(value) != "X" && GameBoard.boardVals.get(value) != "O"){

                check = true;
            }
        }
        return value;
    }

    public static int bestOpenMove() {
        if (GameBoard.boardVals.get(4) == "4") {
            return 4;
        } else {
            return -1;
        }
    }

    public static int blockWin() {


        if (getSquareToBlock(0, 1, 2) != -1) {
            return getSquareToBlock(0, 1, 2);
        } else if (getSquareToBlock(3, 4, 5) != -1) {
            return getSquareToBlock(3, 4, 5);
        } else if (getSquareToBlock(6, 7, 8) != -1) {
            return getSquareToBlock(6, 7, 8);
        } else if (getSquareToBlock(0, 3, 6) != -1) {
            return getSquareToBlock(0, 3, 6);
        } else if (getSquareToBlock(1, 4, 7) != -1) {
            return getSquareToBlock(1, 4, 7);
        } else if (getSquareToBlock(2, 5,8) != -1) {
            return getSquareToBlock(2, 5, 8);
        } else if (getSquareToBlock(0,4, 8) != -1) {
            return getSquareToBlock(0, 4, 8);
        } else if (getSquareToBlock(2, 4, 6) != -1) {
            return getSquareToBlock(2, 4, 6);
        } else {
            return -1;
        }
    }

    public static int goForWin() {


        if (getSquareForWin(0, 1, 2) != -1) {
            return getSquareForWin(0, 1, 2);
        } else if (getSquareForWin(3, 4, 5) != -1) {
            return getSquareForWin(3, 4, 5);
        } else if (getSquareForWin(6, 7, 8) != -1) {
            return getSquareForWin(6, 7, 8);
        } else if (getSquareForWin(0, 3, 6) != -1) {
            return getSquareForWin(0, 3, 6);
        } else if (getSquareForWin(1, 4, 7) != -1) {
            return getSquareForWin(1, 4, 7);
        } else if (getSquareForWin(2, 5, 8) != -1) {
            return getSquareForWin(2,5, 8);
        } else if (getSquareForWin(0, 4, 8) != -1) {
            return getSquareForWin(0, 4, 8);
        } else if (getSquareForWin(2,4, 6) != -1) {
            return getSquareForWin(2, 4, 6);
        } else {
            return -1;
        }
    }


    public static int getSquareToBlock(int sq1, int sq2, int sq3) {
        int counter = 0;
        int targetsquare = -1;
        if (GameBoard.boardVals.get(sq1) == TicTacToe.player1.playerTolken) {
            counter = counter + 1;

        }
        if (GameBoard.boardVals.get(sq1) != TicTacToe.player1.playerTolken && GameBoard.boardVals.get(sq1) != TicTacToe.player1.playerTolken) {
            targetsquare = sq1;
        }
        if (GameBoard.boardVals.get(sq2)== TicTacToe.player1.playerTolken) {
            counter = counter + 1;

        }
        if (GameBoard.boardVals.get(sq2) != TicTacToe.player1.playerTolken && GameBoard.boardVals.get(sq2) != TicTacToe.player1.playerTolken) {
            targetsquare = sq2;
        }
        if (GameBoard.boardVals.get(sq3) == TicTacToe.player1.playerTolken) {
            counter = counter + 1;

        }
        if (GameBoard.boardVals.get(sq3) != TicTacToe.player1.playerTolken && GameBoard.boardVals.get(sq3) != TicTacToe.player1.playerTolken) {
            targetsquare = sq3;
        }

        if(targetsquare == -1) {
            return -1;
        }
        else {
            if (counter == 2 && GameBoard.boardVals.get(targetsquare) != "X" && GameBoard.boardVals.get(targetsquare) != "O") {
                System.out.println("RAN getSquareToBlock with target = " + targetsquare);
                return targetsquare;
            } else if (counter == 3) {
                return -1;
            } else {
                return -1;
            }
        }
    }


    public static int getSquareForWin(int sq1, int sq2, int sq3) {
        int counter = 0;

        int targetsquare = -1;
        if (GameBoard.boardVals.get(sq1) == TicTacToe.player2.playerTolken) {
            counter = counter + 1;

        }
        if (GameBoard.boardVals.get(sq1) != TicTacToe.player2.playerTolken && GameBoard.boardVals.get(sq1) != TicTacToe.player1.playerTolken) {
            targetsquare = sq1;
        }
        if (GameBoard.boardVals.get(sq2) == TicTacToe.player2.playerTolken) {
            counter = counter + 1;

        }
        if (GameBoard.boardVals.get(sq2) != TicTacToe.player2.playerTolken && GameBoard.boardVals.get(sq2) != TicTacToe.player1.playerTolken) {
            targetsquare = sq2;
        }
        if (GameBoard.boardVals.get(sq3) == TicTacToe.player2.playerTolken) {
            counter = counter + 1;

        }
        if (GameBoard.boardVals.get(sq3) != TicTacToe.player2.playerTolken && GameBoard.boardVals.get(sq3) != TicTacToe.player1.playerTolken) {
            targetsquare = sq3;
        }
        if(targetsquare == -1) {
            return -1;
        }
        else {
            if (counter == 2 && GameBoard.boardVals.get(targetsquare) != "X" && GameBoard.boardVals.get(targetsquare) != "O") {
                System.out.println("RAN getSquareForWin with target = " + targetsquare);
                return targetsquare;
            } else if (counter == 3) {
                return -1;
            } else {
                return -1;
            }
        }
    }

   public static int takeCorner(){
       String s1 = GameBoard.boardVals.get(0);
       String s3 = GameBoard.boardVals.get(2);
       String s7 = GameBoard.boardVals.get(6);
       String s9 = GameBoard.boardVals.get(8);
       if(s1 != "X" && s1 != "O"){
           return Integer.parseInt(s1);
       }
       if(s3 != "X" && s3 != "O"){
           return Integer.parseInt(s3);
       }
       if(s7 != "X" && s7 != "O"){
           return Integer.parseInt(s7);
       }
       if(s9 != "X" && s9 != "O"){
           return Integer.parseInt(s9);
       }
       else{return -1;}
   }
    public static int takeEdge(){
        String s2 = GameBoard.boardVals.get(1);
        String s4 = GameBoard.boardVals.get(3);
        String s6 = GameBoard.boardVals.get(5);
        String s8 = GameBoard.boardVals.get(7);
        if(s2 != "X" && s2 != "O"){
            return Integer.parseInt(s2);
        }
        if(s4 != "X" && s4 != "O"){
            return Integer.parseInt(s4);
        }
        if(s6 != "X" && s6 != "O"){
            return Integer.parseInt(s6);
        }
        if(s8 != "X" && s8 != "O"){
            return Integer.parseInt(s8);
        }
        else{return -1;}
    }

    public static int sendRespose(){

        if(goForWin() != -1){
            return goForWin();

    }  else if(blockWin() != -1){
            return blockWin();
        }
       else if(bestOpenMove() != -1){
            return bestOpenMove();

        }
        else if (takeCorner() != -1){
            return takeCorner();
        }
        else if (takeEdge() != -1){
            return takeEdge();
        }
        else{return randomMove();}
    }
    }
