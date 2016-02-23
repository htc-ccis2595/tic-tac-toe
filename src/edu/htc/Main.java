package edu.htc;
import java.util.ArrayList;

public class Main {
    public static ArrayList<String> boardVals = new ArrayList<>();
     static Player player1 = new Player();
     static Player player2 = new Player();
     public static int turnCounter = 0;



    public static void main(String[] args) {




        Board.createBoard();

        player1.setPlayerTolken();
        if(player1.playerTolken == "X"){
            player2.playerTolken = "O";
        }
        else{player2.playerTolken = "X";}

        Board.showBoard();
      while(Board.isGameOver() == false) {
         if(turnCounter % 2 == 0) {
             System.out.println("Player 1, Take a Turn");
             player1.takeTurn();
             turnCounter = turnCounter + 1;
         }
          else{
             System.out.println("Player 2, Take a Turn");
             player2.takeTurn();
             turnCounter = turnCounter + 1;
         }

          Board.showBoard();
      }



    }


}
