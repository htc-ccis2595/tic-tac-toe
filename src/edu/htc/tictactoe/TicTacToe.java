package edu.htc.tictactoe;

import java.util.Scanner;
import edu.htc.tictactoe.player.*;
import edu.htc.tictactoe.Strategy.*;


public class TicTacToe {

    Player player1;
    Player player2;

    GameBoard game;
    Scanner scanner = new Scanner(System.in);

public TicTacToe()
{
    game = new GameBoard();

}
  public void playGame() {

      //Player1
      System.out.print("Player 1: ");
      String Name = scanner.next();

      //System.out.print("Marker: x or o?");
      //String gameMarkerStr = scanner.next();
      //char gameMarker = gameMarkerStr.charAt(0);
      char gameMarker = 'X';

      player1 = new HumanPlayer(Name, gameMarker);



      //Player2
      System.out.print("Player 2: ");
      String Name2 = scanner.next();

//      System.out.print("Marker: x or o?");
//      String gameMarkerStr2 = scanner.next();
//      char gameMarker2 = gameMarkerStr2.charAt(0);
      char gameMarker2 = 'O';

      player2 = new HumanPlayer(Name2, gameMarker2);

      while (game.isGameWon() == false) {
          //PLAYER1 PROMPT
          game.display();
          int move = player1.getMove();
          game.isSquareOpen(move);
          if (game.isSquareOpen(move) == true) {
              game.updateSquare(move, gameMarker);
          }

          if (game.isGameWon() == true) {
              System.out.println(Name + " is the winner!");
              player1.addWin();
          }

          else {

              System.out.println("Updated Board");

              //PLAYER2 PROMPT
              game.display();
              int move2 = player2.getMove();
              game.isSquareOpen(move2);
              if (game.isSquareOpen(move2) == true) {
                  game.updateSquare(move2, gameMarker2);
              }

              if (game.isGameWon() == true) {
                  System.out.println(Name2 +  " is the winner!");
                  player2.addWin();
              }
              System.out.println("Updated Board");

          }
      }




  }

    public static void main(String[] args) {

        TicTacToe ticTac = new TicTacToe();

        ticTac.playGame();


    }



    }
