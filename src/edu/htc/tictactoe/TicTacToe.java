package edu.htc.tictactoe;


public class TicTacToe {
   static Player player1 = new Player();
  static Player player2 = new Player();
  public static int turnCounter = 0;
  public void playGame() {

    configureGame();

    GameBoard.showBoard();



      while (turnCounter != 9 && GameBoard.isGameOver() == false) {
        if (turnCounter % 2 == 0) {
          System.out.println("Player 1, Take a Turn");
          player1.humanTakeTurn();
          turnCounter = turnCounter + 1;
        } else {
          System.out.println("Player 2, Take a Turn");
          if (player2.playerType == "Human") {
            player2.humanTakeTurn();
            turnCounter = turnCounter + 1;
          }

          if (player2.playerType == "Computer") {
            player2.computerTakeTurn();
            turnCounter = turnCounter + 1;
          }
        }

        GameBoard.showBoard();
        System.out.println("Turn - " + turnCounter);


      }
    if(turnCounter == 9 && GameBoard.isGameOver() == false){
      System.out.println("Draw Game");
    }
  }


  public void configureGame(){
    GameBoard.createBoard();
    player2.setPlayerType();

    player1.setPlayerTolken();
    setPlayer2Tolken();
    if(player2.playerType == "Computer"){
      player2.ComputerLevel = player2.setCompStratagy();

    }


  }


  public void setPlayer2Tolken(){
    if(player1.playerTolken == "X"){
      player2.playerTolken ="O";
    }
    if(player1.playerTolken == "O"){
      player2.playerTolken ="X";
    }

  }



}
