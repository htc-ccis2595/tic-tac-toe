package edu.htc.tictactoe;

import java.util.Scanner;
import edu.htc.tictactoe.player.*;
import edu.htc.tictactoe.strategy.*;


public class TicTacToe {

    Player player1;
    Player player2;
    GameBoard game;

    RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(game);

    TicTacToeStrategy strategy = new TicTacToeStrategy(game) {
        @Override
        public int getBestMove() {
            return 0;
        }
        public int getRandomMove(){
            return 0;
        }
    };






    Scanner scanner = new Scanner(System.in);

    public TicTacToe() {
        game = new GameBoard();

    }

    public void playGame() {

      System.out.println("How many players?");
      String playersInt = scanner.next();
      Integer players = Integer.parseInt(playersInt);
//        if (players > 0 && players < 3)
//            players = players;


///////////////////////2 PLAYER GAME////////////////////////////////////
        if (players.equals(2)) {
            //Player1


            System.out.print("Player1 Name: ");
            String Name = scanner.next();

            //System.out.print("Marker: x or o?");
            //String gameMarkerStr = scanner.next();
            //char gameMarker = gameMarkerStr.charAt(0);
            char gameMarker = 'X';
            player1 = new HumanPlayer(Name, gameMarker);

            //Player2
            System.out.print("Player2 Name: ");
            String Name2 = scanner.next();
            char gameMarker2 = 'O';
            player2 = new HumanPlayer(Name2, gameMarker2);




            while (game.isGameWon() == false)

            {
                /////////////////////////////PLAYER1 PROMPT
                game.display();
                int move = player1.getMove();
                game.isSquareOpen(move);
                if (game.isSquareOpen(move) == true) {
                    game.updateSquare(move, gameMarker);
                }

                if (game.isGameWon() == true) {
                    System.out.println(Name + " is the winner!");
                    game.display();
                    player1.addWin();
                    System.out.println(Name + " wins: " + player1.getWinCount());
                } else {

                    System.out.println("Updated Board");

                    /////////////////////////PLAYER2 PROMPT
                    game.display();
                    int move2 = player2.getMove();
                    game.isSquareOpen(move2);
                    if (game.isSquareOpen(move2) == true) {
                        game.updateSquare(move2, gameMarker2);
                    }

                    if (game.isGameWon() == true) {
                        System.out.println(Name2 + " is the winner!");
                        game.display();
                        player2.addWin();
                        System.out.println(Name2 + " wins: " + player2.getWinCount());
                    }
                    System.out.println("Updated Board");

                }
            }
        }

        else
        //////////////////////////////1 PLAYER GAME WITH COMPUTER/////////////////////////////
        {
            System.out.print("Player1 Name: ");
            String Name = scanner.next();
            char gameMarker = 'X';
            player1 = new HumanPlayer(Name, gameMarker);

            String Name2 = "Computer";
            char gameMarker2 = 'O';
            player2 = new ComputerPlayer(Name2, gameMarker2);
            //System.out.println(player2);

            while (game.isGameWon() == false)

            {
                //PLAYER1 PROMPT
                game.display();
                int move = player1.getMove();
                game.isSquareOpen(move);
                if (game.isSquareOpen(move) == true) {
                    game.updateSquare(move, gameMarker);
                }

                if (game.isGameWon() == true) {
                    System.out.println(Name + " is the winner!");
                    game.display();
                    player1.addWin();
                }

                else {

                    System.out.println("Updated Board");

                    //COMPUTER PLAYER
                    game.display();
                    int move2 = player2.getMove();
                    game.isSquareOpen(move2);
                    if (game.isSquareOpen(move2) == true) {
                        game.updateSquare(move2, gameMarker2);
                    }

                    if (game.isGameWon() == true) {
                        System.out.println(Name2 + " is the winner!");
                        game.display();
                        player2.addWin();
                    }
                    System.out.println("Updated Board");

                }
            }

        }
}





    public static void main(String[] args) {

        TicTacToe ticTac = new TicTacToe();

        ticTac.playGame();



    }



    }
