package edu.htc.tictactoe;
import edu.htc.tictactoe.player.*;
import edu.htc.tictactoe.strategy.RandomMoveStrategy;
import edu.htc.tictactoe.strategy.TicTacToeStrategy;

import java.util.Scanner;
public class TicTacToe {



  private Player player1;
  private Player player2;
  private Scanner scanner = new Scanner(System.in);

  private GameBoard gameBoard;
  //constructor
  public TicTacToe(Player player1,
                   Player player2 )
  {
    this.player1 = player1;
    this.player2 = player2;
  }

  public void playGame() {

    gameBoard = new GameBoard(); //initalize gameboard

    //if player1 has no name and marker, setup human player
    if( player1 == null ) {
      player1 = setupHumanPlayer('X');
    }

    System.out.println("Player 1's name " + player1.getName());
    System.out.println("Player 1's marker " + player1.getMarker());

    String playai;

    //if player2 has no name and marker, setup human player
    if( player2 == null ) {
      do {
        System.out.println("Would you like to play an AI " + player1.getName() + "? ");
        playai = scanner.next();
      } while(playai.equalsIgnoreCase("") && !playai.equalsIgnoreCase("no") && !playai.equalsIgnoreCase("yes"));
      if(playai.equalsIgnoreCase("yes")){ //if user input is yes, create ComputerPlayer
        player2 = setupComputerPlayer('O');

      }
      else { //if user input is not = to yes, setup HumanPlayer
        player2 = setupHumanPlayer('O'); }
    }

    System.out.println("Player 2's name " + player2.getName());
    System.out.println("Player 2's marker " + player2.getMarker());


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
      //tie
      if(gameBoard.getOpenSquares().length == 0) {
        System.out.println("It was tie!! ");
        break;
      }


    }
    //would you like to play again?
    String playagain;
    do {
      System.out.println("Would you like to play again? ");
      playagain = scanner.next();
    } while (playagain.equalsIgnoreCase(""));

    //if user wants to play again use current player names and markers
   if(playagain.equalsIgnoreCase("Yes")) {
     gameBoard = new GameBoard(); //initalize gameboard
     TicTacToe game = new TicTacToe(player1, player2);



     game.playGame();

   }
    //if user would like to stop playing
   else  {
      System.out.println("Thanks for playing!");
    }


  }

//setup name and marker for human player
  private Player setupHumanPlayer(char marker) {
      String name;
      do {
          System.out.println("What is your name player? ");
          name = scanner.next();
      } while (name.equalsIgnoreCase(""));

      return new HumanPlayer(name, marker);

    }
  //setup computerplayer with RandomMoveStrategy
  private ComputerPlayer setupComputerPlayer(char marker) {
    String ai;

    ai = "Terminator";
    TicTacToeStrategy strategy = new RandomMoveStrategy(gameBoard);


    return new ComputerPlayer(ai,marker, strategy);
  }


  public static void main(String args[]) {



    TicTacToe game = new TicTacToe( null, null );
    game.playGame();




  }




}
