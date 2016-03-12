package edu.htc.tictactoe;

import edu.htc.tictactoe.player.Player;
import edu.htc.tictactoe.player.HumanPlayer;
import edu.htc.tictactoe.player.ComputerPlayer;
import java.util.Scanner;


public class TicTacToe {

  public GameBoard board = new GameBoard();
  public Player player1 = new HumanPlayer();
  public Player player2 = new HumanPlayer();
  public ComputerPlayer player3 = new ComputerPlayer();

  public int intOpenSquares = 9;
  public boolean blnGameIsWon = false;
  public boolean blnGameisTie = false;
  public boolean blnExitLoop;
  Scanner input = new Scanner(System.in);

  char[] currentBoard = new char[9];

  public void playGame() {

    int intNextMove;
    boolean blnGameWon;

    //Play the game
    do {

      if (Main.intCurrentPlayer == 1) {
        player1.isCurrentPlayer = true;
        if (player2 == null) {
          player3.isCurrentPlayer = false;
        } else {
          player2.isCurrentPlayer = false;
        }
      } else {
        if (player2 == null) {
          player3.isCurrentPlayer = true;
          player1.isCurrentPlayer = false;
        } else {
          player2.isCurrentPlayer = true;
          player1.isCurrentPlayer = false;
        }
      }

      if (player1.isCurrentPlayer) {
        intNextMove = player1.getMove('X');
        board.updateSquare(intNextMove, 'X');
        Main.intCurrentPlayer = 2;
       } else {
        if (player2 == null) {
          //Computer is playing ..
          intNextMove = player3.getMove(board, 'O');
          board.updateSquare(intNextMove, 'O');
          Main.intCurrentPlayer = 1;
        } else {
          intNextMove = player2.getMove('O');
          board.updateSquare(intNextMove, 'O');
          Main.intCurrentPlayer = 1;
        }
      }
      board.display();
      intOpenSquares = board.getOpenSquares();
      System.out.println("There are " + intOpenSquares + " open squares.");
      if (intOpenSquares == 0) {
        if (board.isGameWon(board.board)) {
          blnExitLoop = true;
          blnGameIsWon = true;
        } else { // Game is a tie
          blnExitLoop = true;
          blnGameisTie = true;
        }
      }

    } while (!blnExitLoop);

    // if the intOpenSquares variable is greater than 0, the game has been either
    // won or lost.

    if (blnGameIsWon) {
      if (player1.isCurrentPlayer) {
        player1.addWin();
        System.out.println("Congratulations, " + player1.name + " you win the game!");
      } else {
      if (player2 == null) {
        //player3 is the winner. So add a win to the WinCounter..
        player3.setWinCounter(1);
        System.out.println("Congratulations, " + player3.name + " you win the game!");
      } else {
        if (player2 != null){
          player2.addWin();
          System.out.println("Congratulations, " + player2.name + " you win the game!");
        }
      }}

    } else {
      if (blnGameisTie)
        System.out.println("Sorry, game has ended in a tie.");
    }
    ResetGame();
  }

  public void initGame(){
    currentBoard = board.board;
    player1.isCurrentPlayer = true;
    player2.isCurrentPlayer = false;

    //Update the tictactoe class to ask if there are two players
    System.out.println("Hi! My name is Hal.");
    System.out.println("How many players will be playing tictactoe? 1? or 2?");
    Integer IntAnswer;
    IntAnswer = input.nextInt();
    if (IntAnswer == 1){
        // get the name for the human
        player1.getName(1);
        // set the name for the computer to "Hal"
        player3.setName("HAL");
        player2 = null;
        System.out.println("OK, the computer will be playing the game with you!");
        // Now lets determine the level of difficulty for playing the game
        //     1 -- Simple
        //     2 -- Easy
        //     3 -- Medium
        //     4 -- Hard

        System.out.println("Now lets determine the level of difficulty for this game!");
        System.out.println("Level 1 is Simple");
        System.out.println("Level 2 is Easy");
        System.out.println("Level 3 is Medium");
        System.out.println("Level 4 is Hard");
        IntAnswer = input.nextInt();

        if (IntAnswer > 0 & IntAnswer < 5){
            board.intGameLevel = IntAnswer;
        }

    } else {
      player1.getName(1);
      player2.getName(2);
    }
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
    if (player2 != null) {
      if (player2.winCounter == 1) {
        System.out.println(player2.name + " has won " + player2.winCounter + " time.");
      } else {
        System.out.println(player2.name + " has won " + player2.winCounter + " times.");
      }
    }
    if (player2 == null){
      if (player3.winCounter == 1){
        System.out.println(player3.name + " has won " + player3.winCounter + " time.");
      }
      else {
        System.out.println(player3.name + " has won " + player3.winCounter + " times.");
      }
    }
   }
  public void ResetGame(){
    // reset the board back to its integer values
    board.board = new char[] {'1','2','3','4','5','6','7','8','9'};
    currentBoard = board.board;
    intOpenSquares = 9;
    blnExitLoop = false;
    blnGameIsWon = false;
    blnGameisTie = false;
  }

}


