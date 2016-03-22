package edu.htc;


import edu.htc.tictactoe.TicTacToe;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Tic Tac Toe Game, Let's Play!!");
        System.out.println();

//        GameBoard display = new GameBoard();
//        display.testGameBoardDisplay();
//        display.isSquareOpen();
        TicTacToe play = new TicTacToe();
        play.playGame();
    }
}
