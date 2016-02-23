package edu.htc.tictactoe;
import java.util.ArrayList;
import java.util.Scanner;
public class TicTacToe {



  private Player player1;
  private Player player2;
  private Scanner scanner = new Scanner(System.in);

  private GameBoard gameBoard;

  public TicTacToe(Player player1,
                   Player player2 )
  {
    this.player1 = player1;
    this.player2 = player2;
  }

  public void playGame() {

    if( player1 == null ) {
      player1 = setupPlayer('X');
    }

    System.out.println("Player 1's name " + player1.getName());
    System.out.println("Player 1's marker " + player1.getMarker());

    if( player2 == null ) {
      player2 = setupPlayer('O');
    }

    System.out.println("Player 2's name " + player2.getName());
    System.out.println("Player 2's marker " + player2.getMarker());

    gameBoard = new GameBoard(); //initalize gameboard

    while (gameBoard.isGameWon() == false) {
      gameBoard.display();
      int move;
      do {
         move = player1.getMove();//player 1 move

      } while (gameBoard.isSquareOpen(move) == false);


      gameBoard.updateSquare(move, 'X');
      //if won break
      gameBoard.display();
      if(gameBoard.isGameWon()) {
        System.out.println("Game won by player 1! ");
        System.out.println("Player 1's win count: " + player1.getWinCounter());
        player1.addWin();
        System.out.println("Player 1's updated win count: " + player1.getWinCounter());
        break;
      }
      if(gameBoard.getOpenSquares().length == 0) {
        System.out.println("It was tie!! ");
        break;
      }

      int move2;
      do {
        move2 = player2.getMove();
      } while (gameBoard.isSquareOpen(move2) == false);
      gameBoard.updateSquare(move2, 'O');


      //if won break
      gameBoard.display();
      if(gameBoard.isGameWon()) {
        System.out.println("Game won by player 2! ");
        System.out.println("Player 2's win count: " + player2.getWinCounter());
        player2.addWin();
        System.out.println("Player 2's updated win count: " + player2.getWinCounter());
        break;

      }

      if(gameBoard.getOpenSquares().length == 0) {
        System.out.println("It was tie!! ");
        break;
      }


    }
    String playagain;
    do {
      System.out.println("Would you like to play again? ");
      playagain = scanner.next();
    } while (playagain.equalsIgnoreCase(""));

   if(playagain.equalsIgnoreCase("Yes")) {
     TicTacToe game = new TicTacToe(player1, player2);

     game.playGame();

   }
    else if(!playagain.equalsIgnoreCase("Yes") && playagain.equalsIgnoreCase("No")) {
      System.out.println("Thanks for playing!");
    }


  }


  private Player setupPlayer(char marker) {
      String name;
      do {
          System.out.println("What is your name player? ");
          name = scanner.next();
      } while (name.equalsIgnoreCase(""));

      return new Player(name, marker);

    }


  public static void main(String args[]) {



    TicTacToe game = new TicTacToe( null, null );
    game.playGame();




  }




}
