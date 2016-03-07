package edu.htc.tictactoe;

import java.util.Scanner;

import edu.htc.tictactoe.players.*;
import edu.htc.tictactoe.stratagem.RandomMoveStrategy;
import edu.htc.tictactoe.stratagem.TicTacToeStrategy;

public class TicTacToe {
    int i = 0;
    GameBoard board;

    public TicTacToe() {
        super();
    }

    public void playGame() {
        boolean again = true;
        boolean win;
        int turn;
        int place;

        //Player Setup
        Player player1 = new HumanPlayer(getPlayerName("Player 1"), getCharMaker("Player 1"));
        Player player2;

        if (multiplayer()) {
            player2 = new HumanPlayer(getPlayerName("Player 2"), otherMarker(player1.getMarker()));
        } else {
            player2 = new ComputerPlayer("Angry Floffles", otherMarker(player1.getMarker()), new RandomMoveStrategy(board));
        }

        //Player Array Setup
        Player[] players = new Player[2];
        players[0] = player1;
        players[1] = player2;

        //playAgain Loop
        while (again) {
            turn = 0;
            win = false;

            board = new GameBoard();
            board.display();

            //Turn Loop
            while (board.getOpenSquares().length > 0 && !win) {
                Player current = players[playerTurn(turn)];
                turn++;


                place = current.getMove();

                //While Loop if Invalid
                while (!board.isSquareOpen(place)) {
                    System.out.println(current.getName() + ", you must choose a numbered empty spot. That one is occupied by an " + board.getSquareValue(place));
                    place = current.getMove();
                }
                board.updateSquare(place, current.getMarker());
                board.display();

                //Win Check
                if (board.gameWon()) {
                    win = true;
                    current.addWin();
                }
            }
            //Stalemate if the Loop Ends Without a Win
            if (!win) {
                stalemate();
            }
            //playAgain Loop Boolean
            again = playAgain();
        }
        //End of Game Win Report
        for (i = 0; i < 2; i++) {
            System.out.println(players[i].getName() + " had " + players[i].getWinCounter() + " wins.");
        }
    }

    Scanner ask = new Scanner(System.in);


    private String getPlayerName(String name) {
        String username = null;
        System.out.println();
        while (username == null) {
            System.out.println(name + " please enter a name for yourself: ");
            String maybe = ask.next();
            if (maybe.length() >= 1) {
                username = maybe;
            } else {
                System.out.println();
                System.out.println("You can't play until you enter a name.");
            }
        }
        return username;
    }

    private char getCharMaker(String name) {
        char marker = 't';
        String maybe;
        System.out.println();
        while (marker == 't') {
            System.out.println(name + " please enter X or O for your game marker: ");
            maybe = ask.next();
            if (maybe.equalsIgnoreCase("X")) {
                marker = 'X';
            } else if (maybe.equalsIgnoreCase("O")) {
                marker = 'O';
            } else {
                System.out.println();
                System.out.println("You must choose either 'X' or 'O'.");
            }
        }
        return marker;
    }

    private boolean multiplayer() {
        String x = "Waffles";
        while (!x.equalsIgnoreCase("No") && !x.equalsIgnoreCase("Yes")) {
            System.out.println("Would you like to play with yourself: ");
            x = ask.next();
            if (x.equalsIgnoreCase("Yes")) {
                return false;
            } else if (x.equalsIgnoreCase("No")) {
                return true;
            } else {
                System.out.println();
                System.out.println("You must enter Yes or No.");
            }
        }
        return false;
    }

    public char otherMarker(char m) {
        if (m == 'X') {
            return 'O';
        } else return 'X';
    }

    private void stalemate() {
        System.out.println();
        System.out.println("No one wins this time.");
    }

    private boolean playAgain() {
        String x;
        System.out.println("Would you like to play again?");
        x = ask.next();
        return !(x.equalsIgnoreCase("no"));
    }


    private int playerTurn(int x) {
        if (x % 2 == 0) {
            return 0;
        }
        return 1;
    }

    public static void main(String args[]) {

        GameBoard board = new GameBoard();
        TicTacToe ttt = new TicTacToe();

        Player tom = new HumanPlayer("Jimmy", 'O');
        Player dude = new ComputerPlayer("Happy", ttt.otherMarker(tom.getMarker()), new RandomMoveStrategy(board));

        GameBoard yolo = new GameBoard(new char[]{'X', '2', 'O', '4', 'X', 'O', '7', 'O', 'X'});

        System.out.println("Testing Game Board");
        yolo.testGameBoard();

        System.out.println("Testing Player");
        tom.playerTest(tom);
        dude.playerTest(dude);
    }
}