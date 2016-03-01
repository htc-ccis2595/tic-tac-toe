package edu.htc.tictactoe;

import java.util.Scanner;

public class TicTacToe {
  //instance variables
  private char boardArr[] ={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
  private GameBoard boardClass = new GameBoard(boardArr);
  private Player player1;
  private Player player2;
  Scanner scannerttt = new Scanner(System.in);


  //methods
  public void playGame() {
    int chosenSqr;
    boolean turnDone = false;
    boolean winner = false;
    Player currentPlayer = player1;

    System.out.println("Welcome. Let's start by determining our players.");
    getPlayers();
    System.out.println("Great! Let's get started. " + currentPlayer.getName() + " will go first.");
    System.out.println("Here is the current board:");
    boardClass.display();
    while (!winner) {
      System.out.println("Enter the square you wish to claim: ");
      chosenSqr = scannerttt.nextInt();
      while (!turnDone) {
        if (validateSqrNum(chosenSqr)) {
          boardClass.getOpenSquares();
          if (boardClass.isSquareOpen(chosenSqr)) {
            boardClass.updateSquare(chosenSqr, currentPlayer.getMarker());
            turnDone = true;
            if (boardClass.isGameWon(currentPlayer.getMarker())) {
              winner = true;
            }
            if (!winner) {
              if (currentPlayer == player1) currentPlayer = player2;
              else currentPlayer = player1;
            }
          } else System.out.println("Sorry that square is not available");
        } else System.out.println("Sorry that is not a valid square number.");
      }
      if (winner) System.out.println(currentPlayer.getName() + " has won the game!!!");
    }
  }



  public void getPlayers(){
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
    }else{
      mark = 'o';
    }
    Player player1 = new Player (playername, mark);

    System.out.println("Thank you " + player1.getName() +".");
    playername = "";
    while (playername.length() == 0) {
      System.out.println("Player 2, please enter your name: ");
      playername = scannerttt.next();
      if (playername.length() == 0) System.out.println("No name entered. Please try again.");
    }
    if (selection == 1){
      mark = 'o';
    }else{
      mark = 'x';
    }
    Player player2 = new Player(playername, mark);

  }

  public boolean validateSqrNum(int num){
    if (num < 1 || num > 9) return false;
    else return true;
  }

}
