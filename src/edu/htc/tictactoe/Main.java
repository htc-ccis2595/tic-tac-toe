package edu.htc.tictactoe;

public class Main {

    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();
        game.playGame();
        GameBoard board = new GameBoard();
        board.testGameBoardDisplay();
        board.testIsSquareOpen();

    }
}
