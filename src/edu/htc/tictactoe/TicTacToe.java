package edu.htc.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    private GameBoard board;
    private Player player1;
    private Player player2;

    public TicTacToe(){
        this.board = new GameBoard();
    }

    public static void main(String args[]){
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.playGame();
    }



    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player 1 Please Enter your Name: ");
        String player1Name = scanner.next();
        System.out.println("Player 1 Please Enter your Marker (X or O): ");
        String player1Marker = scanner.next();
        player1 = new Player(player1Name, player1Marker.charAt(0));

        System.out.println("Player 2 Please Enter your Name: ");
        String player2Name = scanner.next();
        System.out.println("Player 2 Please Enter your Marker (X or O): ");
        String player2Marker = scanner.next();
        player2 = new Player(player2Name, player2Marker.charAt(0));
        int counter = 0;
        //while (true)
        //{
            Player firstPlayer;
            Player secondPlayer;
            if(counter%2 == 0) {
                firstPlayer = player1;
                secondPlayer = player2;
            }
            else {
                firstPlayer = player2;
                secondPlayer = player1;
            }
            counter++;


            //start the game
            while (!board.isGameWon())
            {
                board.display();
                board.updateSquare(firstPlayer.getMove(), firstPlayer.getMarker());

                if(!board.isGameWon()) {
                    board.updateSquare(secondPlayer.getMove(), secondPlayer.getMarker());
                    if(board.isGameWon()) {
                        System.out.println(secondPlayer.getName() + " Won!");

                        System.out.println("Win Count = " + secondPlayer.addWin());
                        break;
                    }
                }
                else
                {
                    System.out.println(firstPlayer.getName() + " Won!");
                    System.out.println("Win Count = " + firstPlayer.addWin());
                    break;
                }
            }
        //}
    }

}
