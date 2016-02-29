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

    String player1Marker = scanner.next().toUpperCase();
    if(player1Marker == "X"|| player1Marker == "O"){
      playerFirst = new Player(playerFirstName, player1Marker.charAt(0));
    }else {
      System.out.println("Invalid Marker, Please choose either X or O");
    }



    System.out.println("Player2, please enter your name: ");
    String playerNextName = scanner.next();
    System.out.println("Player2, please choose your Marker (X or O); ");
    String player2Marker = scanner.next().toUpperCase();
    if(player2Marker == "X"|| player1Marker == "O"){
      playerNext = new Player(playerNextName, player2Marker.charAt(0));
    }else {
      System.out.println("Invalid Marker, Please choose either X or O");
    }

    System.out.println();
    System.out.println(playerFirstName + ", you choose " + player1Marker);
    System.out.println(playerNextName + ", you choose " + player2Marker);



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
    counter++;


    //Game start
    while(!board.isGameWon())
    {
      board.display();
      board.updateSquare(firstPlayer.getMove(),firstPlayer.getGameMarker());

      if(!board.isGameWon()){
        board.updateSquare(nextPlayer.getMove(),nextPlayer.getGameMarker());
        if (board.isGameWon()) {
          System.out.println(nextPlayer.getName() + " Won!");

          System.out.println("Win count= " +nextPlayer.addWin());
          break;
        }
      }
      else
      {
        System.out.println(firstPlayer.getName() + " Won!");

        System.out.println("Win count = " + firstPlayer.addWin());
        break;
      }
    }



    
  }

}
