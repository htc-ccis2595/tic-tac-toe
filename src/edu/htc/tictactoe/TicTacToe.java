package edu.htc.tictactoe;
import edu.htc.tictactoe.player.*;
import edu.htc.tictactoe.strategy.BestOpenMoveStrategy;
import edu.htc.tictactoe.strategy.BlockWinStrategy;
import edu.htc.tictactoe.strategy.RandomMoveStrategy;
import edu.htc.tictactoe.strategy.TicTacToeStrategy;

import java.util.Scanner;
public class TicTacToe {



  private Player player1;
  private Player player2;
  private Scanner scanner = new Scanner(System.in);


  private GameBoard gameboard;
  //constructor
  public TicTacToe(Player player1,
                   Player player2)
  {
    this.player1 = player1;
    this.player2 = player2;

  }

  public void playGame() {

    if( gameboard == null) {
      gameboard = new GameBoard();
    }
    System.out.println("Board reset: " + this.gameboard.openSquares);

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
        String difficulty;
        System.out.println("Select Difficulty Easy, Normal or Hard: ");
        difficulty = scanner.next();
        if(difficulty.equalsIgnoreCase("easy")) {
          player2 = setupComputerPlayer('O');
        }
        else if(difficulty.equalsIgnoreCase("normal")) {
          player2 = setupComputerPlayer1('O');
        }
        else if(difficulty.equalsIgnoreCase("hard")) {
          player2 = setupComputerPlayer2('O');
        }

      }
      else { //if user input is not = to yes, setup HumanPlayer
        player2 = setupHumanPlayer('O'); }

    }

    System.out.println("Player 2's name " + player2.getName());
    System.out.println("Player 2's marker " + player2.getMarker());



    while (gameboard.isGameWon() == false) {
      gameboard.display();
      int move;
      do {
         move = player1.getMove();//player 1 move

      } while (gameboard.isSquareOpen(move) == false);


      gameboard.updateSquare(move, 'X');
      //if won break
      gameboard.display();
      if(gameboard.isGameWon()) {
        System.out.println("Game won by player 1! ");
        System.out.println("Player 1's win count: " + player1.getWinCounter());
        player1.addWin();
        System.out.println("Player 1's updated win count: " + player1.getWinCounter());
        break;
      }
      if(gameboard.getOpenSquares().length == 0) {
        System.out.println("It was tie!! ");
        break;
      }

      int move2;
      do {
        move2 = player2.getMove();
      } while (gameboard.isSquareOpen(move2) == false);
      gameboard.updateSquare(move2, 'O');


      //if won break
      gameboard.display();
      if(gameboard.isGameWon()) {
        System.out.println("Game won by player 2! ");
        System.out.println("Player 2's win count: " + player2.getWinCounter());
        player2.addWin();
        System.out.println("Player 2's updated win count: " + player2.getWinCounter());
        break;

      }
      //tie
      if(gameboard.getOpenSquares().length == 0) {
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
     TicTacToe game2 = new TicTacToe(player1, player2);
     System.out.println("Game 2 Board: " + this.gameboard.openSquares);
     gameboard = new GameBoard();
     System.out.println("Game 2 updated Board: " + this.gameboard.openSquares);
     game2.playGame();


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
    String easyai;

    easyai = "EAZY PEAZE";
    TicTacToeStrategy strategy = new RandomMoveStrategy(gameboard);


    return new ComputerPlayer(easyai, marker, strategy);
  }
  //setup ComputerPlayerMedium with BestOpenMove Strategy
  private ComputerPlayer setupComputerPlayer1(char marker) {
    String normalai;

    normalai = "MODERATELY SCARY";
    TicTacToeStrategy strategy1 = new BestOpenMoveStrategy(gameboard);


    return new ComputerPlayer(normalai, marker, strategy1);
  }

  private ComputerPlayer setupComputerPlayer2(char marker) {
    String hardai;

    hardai = "HARDLY SCARY";
    TicTacToeStrategy strategy2 = new BlockWinStrategy(gameboard);


    return new ComputerPlayer(hardai, marker, strategy2);
  }






  public static void main(String args[]) {



    TicTacToe game = new TicTacToe(null, null );

    game.playGame();





  }




}
