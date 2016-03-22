package edu.htc.tictactoe;
import java.util.Scanner;

public class TicTacToe {

  private GameBoard board;
  private Player playerOne;
  private Player playerTwo;

  public TicTacToe() {
    this.board = new GameBoard();
  }

  Scanner scanner = new Scanner(System.in);

  public void playGame() {

    System.out.println("Please enter the number of the player: ");

    String playerNumber = scanner.next();
    while (!playerNumber.equals("1") && !playerNumber.equals("2")) {
      System.out.println("Please enter 1 or 2 players");
      playerNumber = scanner.next();
    }

    Integer players = Integer.parseInt(playerNumber);
    if (players == 1 || players == 2) {
      String playAgain;

      if (players.equals(1)) {
        System.out.println("Please enter Player1 name: ");
        String name = scanner.next();

        char gameMarker = 'X';
        playerOne = new HumanPlayer(name, gameMarker);


        String name2 = "Computer";
        char gameMarker2 = 'O';
        playerTwo = new ComputerPlayer(name2, gameMarker2, board);

        do {
          while (board.isGameWon() == false) {

            board.display();
            int square = playerOne.getMove();
            board.isSquareOpen(square);
            if (board.isSquareOpen(square) == true) {
              board.updateSquare(square, gameMarker);
            }

            if (board.isGameWon() == true) {
              board.display();
              System.out.println(name + " is the Winner!");
              playerOne.addWin();
              System.out.println(name + " win count is: " + playerOne.getWinCounter());
            } else if (board.getOpenSquares().length == 0) {
              System.out.println("Game is tied");
              break;
            }

            //Computer player
            else {
              int square2 = playerTwo.getMove();
              if (board.isSquareOpen(square2) == true) {
                board.updateSquare(square2, gameMarker2);
              }

              if (board.isGameWon() == true) {
                board.display();
                System.out.println(name2 + " is the Winner!");
                board.display();
                playerTwo.addWin();
                System.out.println(name2 + " win count is: " + playerTwo.getWinCounter());
              } else if (board.getOpenSquares().length == 0) {
                System.out.println("Game is tied.");
                break;
              }
            }
          }

          System.out.println("Do you want to play again?");
          playAgain = scanner.next();
        } while (!playAgain.equalsIgnoreCase("Yes") && !playAgain.equalsIgnoreCase("No"));
        if (playAgain.equalsIgnoreCase("Yes")) {
          TicTacToe ticTacToeReplay = new TicTacToe();
          ticTacToeReplay.playGame();
        } else {
          System.out.println("Thank you! GoodBye!");
        }
      } else if (players.equals(2)) {
        System.out.println("Player 1, enter your Name: ");
        String inputName = scanner.next();
        String name = inputName.toUpperCase();
        System.out.println(name + ", please choose your Marker: ");
        char gameMarker = scanner.next().charAt(0);
        Character.toUpperCase(gameMarker);
        playerOne = new HumanPlayer(name, gameMarker);
        while (gameMarker != 'X' && gameMarker != 'O') {
          System.out.println("Invalid Marker, Please choose either X or O");
          gameMarker = scanner.next().charAt(0);
          Character.toUpperCase(gameMarker);
        }

        System.out.println("Player 2, enter your Name: ");
        String inputName2 = scanner.next();
        String name2 = inputName2.toUpperCase();

        char gameMarker2;
        if (gameMarker == 'X') {
          gameMarker2 = 'O';
        } else {
          gameMarker2 = 'X';
        }
        playerTwo = new HumanPlayer(name2, gameMarker2);


        do {
          while (board.isGameWon() == false) {
            board.display();
            int square = playerOne.getMove();
            board.isSquareOpen(square);
            if (board.isSquareOpen(square) == true) {
              board.updateSquare(square, gameMarker);
            }
            if (board.isGameWon() == true) {
              board.display();
              System.out.println(name + " is the Winner!");
              playerOne.addWin();
              System.out.println(name + " win count is: " + playerOne.getWinCounter());
            } else if (board.getOpenSquares().length == 0) {
              System.out.println("Game is tied!");
              break;

            } else {
              board.display();
              int square2 = playerTwo.getMove();
              if (board.isSquareOpen(square2) == true) {
                board.updateSquare(square2, gameMarker2);
              }

              if (board.isGameWon() == true) {
                board.display();
                System.out.println(name2 + " is the Winner");
                board.display();
                playerTwo.addWin();
                System.out.println(name2 + ", win count is: " + playerTwo.getWinCounter());
              } else if (board.getOpenSquares().length == 0) {
                System.out.println("Game is tied!");
                break;
              }
            }

          }
          System.out.println("Do you want ot play again?");
          playAgain = scanner.next();
        } while (!playAgain.equalsIgnoreCase("Yes") && !playAgain.equalsIgnoreCase("No"));
        if (playAgain.equalsIgnoreCase("Yes")) {
          TicTacToe ticTacToeReplay = new TicTacToe();
          ticTacToeReplay.playGame();
        } else {
          System.out.println("Thank you! GoodBye!!");
        }
      }
    }
  }
}


