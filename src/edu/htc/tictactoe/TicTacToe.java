package edu.htc.tictactoe;
import java.util.Scanner;

public class TicTacToe {

  private GameBoard board;
  private Player playerFirst;
  private Player playerNext;

  public TicTacToe(){
    this.board = new GameBoard();
  }

  public void playGame() {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Player1, please enter your name: ");
    String playerFirstName = scanner.next();
    System.out.println("Player2, please choose your Marker (X or O): ");
    String player1Marker = scanner.next();
    playerFirst = new Player(playerFirstName, player1Marker.charAt(0));

    System.out.println("Player2, please enter your name: ");
    String playerNextName = scanner.next();
    System.out.println("Player2, please choose your Marker (X or O); ");
    String player2Marker = scanner.next();
    playerNext = new Player(playerNextName, player2Marker.charAt(0));


    int counter = 0;

    Player firstPlayer;
    Player nextPlayer;
    if(counter % 2 == 0) {
      firstPlayer = playerFirst;
      nextPlayer = playerNext;
    }
    else {
      firstPlayer = playerNext;
      nextPlayer = playerFirst;
    }


    
  }

}
