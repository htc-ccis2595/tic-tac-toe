package edu.htc.tictactoe;

import java.util.Scanner;


public class TicTacToe {
  //instance variables
  private char boardArr[] ={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
  private GameBoard boardClass;
  private Player player1;
  private Player player2;
  private Player currentPlayer;
  Scanner scannerttt = new Scanner(System.in);


  //methods
  public void playGame() {
    int chosenSqr;
    boardClass =  new GameBoard(boardArr);
    boolean turnDone = false;
    boolean winner = false;
    System.out.println("Welcome. Let's start by determining our players.");
    getPlayers();
    currentPlayer = player1;
    //System.out.println("Test before starting");
    System.out.println("Great! Let's get started. " + player1.getName() +" will go first.");
    //System.out.println("Test after current player");
    System.out.println("Here is the current board:");
    boardClass.display();
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
              if (currentPlayer == player1) currentPlayer = player2;
              else currentPlayer = player1;
              System.out.println(currentPlayer.getName() + ", it is your turn now.");
            }
          } else System.out.println("Sorry that square is not available");
        } else System.out.println("Sorry that is not a valid square number.");
      }
      if (winner) {
          System.out.println( currentPlayer.getName() + " has won the game!!!" );
          currentPlayer.addwin();
          System.out.println(currentPlayer.getName() + " has won " + currentPlayer.getWinCounter() + " games so far!");
      }
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
    player1 = new Player (playername, mark);

    System.out.println("Thank you " + player1.getName() +".");
    playername = "";
    while (playername.length() == 0) {
      System.out.println("Player 2, please enter your name: ");
      System.out.println("Test before scanner");
      playername = scannerttt.next();
      System.out.println("Test after scanner");
      if (playername.length() == 0) System.out.println("No name entered. Please try again.");
    }
    System.out.println("Test before mark.");
    System.out.println("Player 1 is using: " + player1.getMarker());
    System.out.println(playername);
    if (player1.getMarker() == 'x'){
      mark = 'o';
    }else{
      mark = 'x';
    }
    player2 = new Player(playername, mark);
    System.out.println("Player 2 is using: " + player2.getMarker());

  }

  public boolean validateSqrNum(int num){
    if (num < 1 || num > 9) return false;
    else return true;
  }

}
