package edu.htc.tictactoe;

public class Main {
    public GameBoard board;
    public Player player1;
    public Player player2;

    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();
        game.playGame();

    }
}
