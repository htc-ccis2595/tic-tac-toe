package edu.htc;

import edu.htc.tictactoe.GameBoard;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Tic Tac Toe Game, Let's Play!!");

        GameBoard display = new GameBoard();
        display.testGameBoardDisplay();
        display.isSquareOpen();
    }
}
