package edu.htc.tictactoe;

public class Main {

    public static void main(String[] args) {
        char board[] = {'O','O','X','X','X',' ','O','X',' '};
        //TicTacToe game = new TicTacToe();
        //game.playGame();
        GameBoard Game = new GameBoard(board);
        Game.display();
    }
}
