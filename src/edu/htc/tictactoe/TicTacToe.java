package edu.htc.tictactoe;

import java.util.Scanner;

public class TicTacToe {

  public GameBoard board = new GameBoard();
  public Player player1 = new Player();
  public Player player2 = new Player();
  public int intOpenSquares = 9;
  public boolean blnExitLoop;

  char[] currentBoard = new char[9];

  public void playGame() {

    int intNextMove;
    boolean blnGameWon;

    //Play the game
    do {

      if (Main.intCurrentPlayer == 1){
        player1.isCurrentPlayer = true;
        player2.isCurrentPlayer = false;
      }
      else{
        player2.isCurrentPlayer = true;
        player1.isCurrentPlayer = false;
      }

      if (player1.isCurrentPlayer) {
          intNextMove = player1.getMove('X');
          board.updateSquare(intNextMove, 'X');
      } else {
        intNextMove = player2.getMove('O');
        board.updateSquare(intNextMove, 'O');
      }
      board.display();
      intOpenSquares = board.getOpenSquares();
      System.out.println("There are "+intOpenSquares+" open squares.");
      if (intOpenSquares == 0){
        // Game is a tie
        blnExitLoop = true;
      }
      if (board.isGameWon(board.board)){
        blnExitLoop = true;
      }

    } while (!blnExitLoop);

    // if the intOpenSquares variable is greater than 0, the game has been either
    // won or lost.

    if (intOpenSquares > 0) {
      if (player1.isCurrentPlayer) {
        player1.addWin();
        System.out.println("Congratulations, " + player1.name + " you win the game!");
      } else {
        player2.addWin();
        System.out.println("Congratulations, " + player2.name + " you win the game!");
      }
    } else {
      System.out.println("Sorry, game has ended in a tie.");
    }
    ResetGame();

  }

  public void initGame(){
    currentBoard = board.board;
    player1.isCurrentPlayer = true;
    player2.isCurrentPlayer = false;
    player1.getName(1);
    player2.getName(2);

  }

  public void gameReport(){
    System.out.println("         Game Winner Report                   ");
    System.out.println("---------------------------------------");
    if (player1.winCounter == 1){
      System.out.println(player1.name + " has won " + player1.winCounter + " time.");
    }
    else{
      System.out.println(player1.name + " has won " + player1.winCounter + " times.");
    }
    if (player2.winCounter == 1){
      System.out.println(player2.name + " has won " + player2.winCounter + " time.");
    }
    else {
      System.out.println(player2.name + " has won " + player2.winCounter + " times.");
    }



  }
  public void ResetGame(){
    // reset the board back to its integer values
    board.board = new char[] {'1','2','3','4','5','6','7','8','9'};
    currentBoard = board.board;
    intOpenSquares = 9;
    blnExitLoop = false;
  }

}


