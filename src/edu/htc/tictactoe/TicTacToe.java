package edu.htc.tictactoe;

public class TicTacToe {

  GameBoard board = new GameBoard();
  Player player1 = new Player();
  Player player2 = new Player();
  int intCurrentPlayer = 1;

  char[] currentBoard = new char[9];

  public void playGame() {

    int intNextMove;

    //Initialize the game
    initGame();

    //Play the game
    do {

      if (intCurrentPlayer == 1){
        intNextMove = player1.getMove();
        board.updateSquare(intNextMove,'X');
      }
      else{
        intNextMove = player2.getMove();
        board.updateSquare(intNextMove,'0');
      }
      board.display();
      swapuser();

    } while (!board.isGameWon(board.board));

    System.out.println("X wins the game!");
  }
  public void initGame(){
    currentBoard = board.board;
  }

  public void swapuser(){
    if (intCurrentPlayer==1){
      intCurrentPlayer = 2;
    }
    else{
      intCurrentPlayer = 1;
    }
  }
}
