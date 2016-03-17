package edu.htc.tictactoe;
import edu.htc.tictactoe.*;
import edu.htc.tictactoe.player.ComputerPlayer;
import edu.htc.tictactoe.player.HumanPlayer;
import edu.htc.tictactoe.player.Player;

import java.util.ArrayList;
import java.util.Scanner;


public class TicTacToe {
  //instance variables
  private char boardArr[] ={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
  private GameBoard boardClass;
  private HumanPlayer player1;
  private HumanPlayer player2;
  private ComputerPlayer computer;
  ArrayList<Object> players = new ArrayList<Object>();
  Scanner scannerttt = new Scanner(System.in);
  private int numOfPlayers;
  private Player currentPlayer;
  private int difficultylevel = 0;




    //methods
  public void playGame() {
    int chosenSqr;
    boardClass =  new GameBoard(boardArr);
    boolean turnDone;
    boolean winner = false;
    int numOfPlayers = 3;
    System.out.println("Welcome. Let's start by determining our players.");
    while (numOfPlayers > 2){
      System.out.println("How many people are playing today? Please enter 1 or 2: ");
      numOfPlayers = scannerttt.nextInt();
      if ( numOfPlayers > 2 || numOfPlayers <= 0) System.out.println("Sorry, that is not a valid number of players. Please try again.");
    }

    if (numOfPlayers == 1) {
        while (difficultylevel < 1 || difficultylevel > 4) {
            System.out.println("Please enter the level of difficulty 1-4 that you wish to play: ");
            System.out.println("    1. Simple");
            System.out.println("    2. Easy");
            System.out.println("    3. Medium");
            System.out.println("    4. Hard");
            difficultylevel = scannerttt.nextInt();
            if (difficultylevel < 1 || difficultylevel > 4)
                System.out.println("That is not a valid entry. Please try again.");
        }
    }
    getPlayers(numOfPlayers);
    System.out.println("Great! Let's get started. " + player1.getName() +" will go first.");
    System.out.println("Here is the current board:");
    boardClass.display();
    currentPlayer = (Player) players.get(0);
    while (!winner) {
      chosenSqr = currentPlayer.getMove();
      turnDone = false;
      while (!turnDone) {
        if (validateSqrNum(chosenSqr)) {
          boardClass.getOpenSquares();
          if (boardClass.isSquareOpen(chosenSqr)) {
            boardClass.updateSquare(chosenSqr, currentPlayer.getMarker());
            turnDone = true;
            System.out.println("Here is the current board:");
            boardClass.display();
            if (boardClass.isGameWon(currentPlayer.getMarker())) {
              winner = true;
            }
            if (!winner) {
              if (currentPlayer == player1) currentPlayer = (Player) players.get(1);
              else currentPlayer = player1;
              System.out.println(currentPlayer.getName() + ", it is your turn now.");
            }
          } else System.out.println("Sorry that square is not available");
        } else {
            System.out.println("Sorry that is not a valid square number.");
            turnDone = true;

        }
      }

      if (winner) {
          System.out.println( currentPlayer.getName() + " has won the game!!!" );
          currentPlayer.addwin();
          System.out.println(currentPlayer.getName() + " has won " + currentPlayer.getWinCounter() + " games so far!");
      }
      if (boardClass.getOpenSquares().length == 0){
        System.out.println("There are no moves left. Game over!");
        winner = true;
      }
      }
    }




  public void getPlayers(int numberOfPlayers){
    int selection = 0;
    String playername = "";
    char mark;
    while (playername.length() == 0) {
      System.out.println("Player, please enter your name: ");
      playername = scannerttt.next();
      if (playername.length() == 0) System.out.println("No name entered. Please try again.");
    }
    while(selection != 1 && selection !=2) {
      System.out.println("Player, Enter 1 to use x or 2 to use o:");
      selection = scannerttt.nextInt();
      if (selection != 1 && selection !=2) System.out.println("That was not a valid selection. Please try again.");
    }
    if (selection == 1){
      mark = 'x';
    }else mark = 'o';
    player1 = new HumanPlayer(playername, mark);
    players.add(player1);
    System.out.println("Thank you " + player1.getName() +".");
    if(numberOfPlayers == 2) {
      playername = "";
      while (playername.length() == 0) {
        System.out.println("Player 2, please enter your name: ");
        playername = scannerttt.next();
        if (playername.length() == 0) System.out.println("No name entered. Please try again.");
      }
      System.out.println("Player 1 is using: " + player1.getMarker());
      System.out.println(playername);
      if (player1.getMarker() == 'x') {
        mark = 'o';
      } else {
        mark = 'x';
      }
      player2 = new HumanPlayer(playername, mark);
      players.add(player2);
      System.out.println("Player 2 is using: " + player2.getMarker());
    }
    else{
      if (player1.getMarker() == 'x') {
        mark = 'o';
      } else {
        mark = 'x';
      }
      computer = new ComputerPlayer("Computer", mark, boardClass, difficultylevel);
      players.add(computer);
    }

  }

  public boolean validateSqrNum(int num){
    if (num < 1 || num > 9) return false;
    else return true;
  }

}
