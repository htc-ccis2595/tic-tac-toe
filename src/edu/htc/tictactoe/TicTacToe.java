package edu.htc.tictactoe;

import edu.htc.tictactoe.player.ComputerPlayer;
import edu.htc.tictactoe.player.HumanPlayer;
import edu.htc.tictactoe.player.Player;

import java.util.Scanner;

public class TicTacToe {
    private GameBoard board;
    private Player player1;
    private Player player2;
    private Scanner scanner = new Scanner(System.in);

    public TicTacToe() {
        this.board = new GameBoard();
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public GameBoard getBoard() {
        return board;
    }

    public static void main(String args[]) {
        TicTacToe ticTacToe = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Will there be two players?(Y/N)");
        String isTwoPlayers = scanner.next();
        String player1Name = "";
        String player1Marker = " ";
        while (player1Name.length() <= 0) {
            System.out.println("Player 1 Please Enter your Name: ");
            player1Name = scanner.next();
            if (player1Name.length() > 0) {
                while (player1Marker.charAt(0) != 'X' && player1Marker.charAt(0) != 'O') {
                    System.out.println(player1Name + " Please Enter your Marker (X or O): ");
                    player1Marker = scanner.next();
                    if (player1Marker.charAt(0) == 'X' || player1Marker.charAt(0) == 'O') {
                        System.out.println(player1Name + " Your marker is " + player1Marker.charAt(0));
                    }
                }
            }
        }
        Player player1 = new HumanPlayer(player1Name, player1Marker.charAt(0));


        Player player2;
        String player2Marker = "O";
        if (player1Marker.charAt(0) == 'O') {
            player2Marker = "X";
        }
        if (isTwoPlayers.equalsIgnoreCase("Y")) {


            String player2Name = "";

            while (player2Name.length() <= 0) {
                System.out.println("Player 2 Please Enter your Name : ");
                player2Name = scanner.next();
                if (player2Name.length() > 0) {
                    System.out.println(player2Name + " Your Marker is " + player2Marker);
                }
            }
            player2 = new HumanPlayer(player2Name, player2Marker.charAt(0));
        } else {
            System.out.println("Please select your level");
            System.out.println("1:Simple");
            System.out.println("2:Easy");
            System.out.println("3:Medium");
            System.out.println("4:Hard");
            int gameLevel = scanner.nextInt();
            player2 = new ComputerPlayer("Computer", player2Marker.charAt(0), ticTacToe.getBoard(), gameLevel);

        }
        ticTacToe.playGame(player1, player2);
    }


    public void playGame(Player player1, Player player2) {

        while (!board.isGameWon() && board.getOpenSquares().length > 0) {
            board.display();
            int square = player1.getMove();
            while (!board.isSquareOpen(square)) {
                System.out.println("The square you picked is not available");
                System.out.println("The available squares are ");
                int openSquares[] = board.getOpenSquares();
                for (int i = 0; i < openSquares.length; i++) {
                    System.out.println(openSquares[i]);
                }
                square = player1.getMove();
            }
            try {
                board.updateSquare(square, player1.getMarker());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


            if (!board.isGameWon() && board.getOpenSquares().length > 0) {
                square = player2.getMove();
                while (!board.isSquareOpen(square)) {
                    System.out.println("The square you picked is not available");
                    System.out.println("The available squares are ");
                    int openSquares[] = board.getOpenSquares();
                    for (int i = 0; i < openSquares.length; i++) {
                        System.out.println(openSquares[i]);
                    }
                    square = player2.getMove();
                }

                try {
                    board.updateSquare(square, player2.getMarker());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                if (board.isGameWon()) {
                    System.out.println(player2.getName() + " Won!");

                    System.out.println("Win Count of " + player2.getName() + " is " + player2.addWin());
                    break;
                }
            } else if(board.isGameWon()) {
                System.out.println(player1.getName() + " Won!");
                System.out.println("Win Count of " + player1.getName() + " is " + player1.addWin());
                break;
            }
            else
            {
                System.out.println("Game tied!");
                break;
            }

        }
        String playAgain;
        System.out.println("Do you want to play again? (Yes/No) ");
        playAgain = scanner.next();
        if (playAgain.equalsIgnoreCase("Yes")) {
            TicTacToe gameAgain = new TicTacToe();
            gameAgain.playGame(player1, player2);
        }

    }

}
