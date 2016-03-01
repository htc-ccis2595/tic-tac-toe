package edu.htc.tictactoe;

import java.util.Scanner;

public class TicTacToe {

    char board[] = {' ',' ',' ',' ',' ',' ',' ',' ',' '};
    GameBoard Game = new GameBoard(board);
    Scanner scanner = new Scanner(System.in);
  public void playGame()
  {
      Game.display();
      Player player1 = new Player("Brian", 'X');
      Player player2 = new Player("Player2", 'O');
      System.out.println("Player 1 Name: " + player1.getName());
      System.out.println("Player 1 Marker: " + player1.getMarker());
      System.out.println("Player 1 Win Count: " + player1.getWinCount());
      System.out.println("Player 2 Name: " + player2.getName());
      System.out.println("Player 2 Marker: " + player2.getMarker());
      System.out.println("Player 2 Win Count: " + player2.getWinCount());
      while (1 == 1)
      {
          Game.display();
          Game.updateSquare(player1.getMove(), 'X');
          if (Game.isGameWon() == true)
          {
              Game.display();
              break;
          }
          Game.display();
          Game.updateSquare(player2.getMove(), 'O');
          if (Game.isGameWon() == true)
          {
              Game.display();
              break;
          }
      }
  }
}
