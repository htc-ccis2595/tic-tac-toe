package edu.htc.tictactoe;

import java.util.Scanner;

public class TicTacToe {
  //instance variables
  private char boardArr[] ={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
  private GameBoard boardClass = new GameBoard(boardArr);
  private Scanner scannerttt = new Scanner(System.in);

  //methods
  public void playGame() {
    System.out.println("Welcome. Let's start by determining our players.");
    this.getPlayers();
    System.out.println("Great! Let's get started.Player 1 will go first.");



  }

  public void getPlayers(){
    String name = "";
    char mark1;
    char mark2;
    int selection = 0;
    while (name.length() == 0) {
      System.out.println("Player 1, please enter your name:");
      name = scannerttt.next();
      if (name.length() == 0) System.out.println("No name entered. Please try again.");
    }
    while(selection != 1 && selection !=2) {
      System.out.println("Player 1, Enter 1 to use x or 2 to use o:");
      selection = scannerttt.nextInt();
      if (selection != 1 && selection !=2) System.out.println("That was not a valid selection. Please try again.");
    }
    if (selection == 1){
      mark1 = 'x';
      mark2 = 'o';
    }else{
      mark1 = 'o';
      mark2 = 'x';
    }

    Player player1 = new Player(name,mark1);

    name = "";

    while (name.length() == 0) {
      System.out.println("Player 2, please enter your name:");
      name = scannerttt.next();
      if (name.length() == 0) System.out.println("No name entered. Please try again.");
    }
    Player player2 = new Player(name,mark2);
  }
  public boolean validateSqrNum(int num){
    if (num < 1 || num > 9) return false;
  }

}
