package edu.htc.tictactoe;

public class Main {

    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();
        game.playGame();

        //"Class 'variable name' = new Class();"
        GameBoard board = new GameBoard();
        //'variable name'.method ()"
        board.display();

    }
}
