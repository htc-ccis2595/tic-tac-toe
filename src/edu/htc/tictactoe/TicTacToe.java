package edu.htc.tictactoe;
import edu.htc.tictactoe.players.*;
import edu.htc.tictactoe.stratagem.*;

import java.util.Scanner;

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
        board = new GameBoard();

        //Player Init
        Player player1;
        Player player2;

        //Player 1 Set
        String name = askPlayerName("Player 1");
        player1 = new HumanPlayer(name, askPlayerMarker(name));

        //Player 2 Set
        boolean multiplayer = askIfMultiplayer();
        char comMarker = player1.getEnemyMarker();
        int difficulty = 0;

        if (multiplayer) {
            player2 = new HumanPlayer(askPlayer2Name("Player 2", player1.getName()), player1.getEnemyMarker());
        } else {
            difficulty = askDifficulty(player1.getName());
            player2 = initComp(difficulty, comMarker, initStrategy(difficulty, comMarker));
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

            if (player2 instanceof Ai) {
                ((Ai) player2).setStrategy(initStrategy(difficulty, comMarker));
            }

            board.display();

            //Turn Loop
            while (board.getOpenSquares().length > 0 && !win) {
                Player current = players[playerTurn(turn)];
                turn++;

                place = current.getMove();

                //While Loop if Invalid
                while (!board.isSquareOpen(place)) {
                    System.out.println(current.getName() + ", you must choose an  empty spot (numbered spots). Spot " + place + " is occupied by an " + board.getSquareValue(place));
                    board.display();
                    place = current.getMove();
                }
                board.updateSquare(place, current.getMarker());
                board.display();

                //Computer States Which Square it Took
                if (current instanceof Ai) {
                    ((Ai) current).Ai(place);
                }

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
            System.out.println(players[i].getName() + " finished with " + players[i].getWinCounter() + " wins.");
        }
    }

    Scanner ask = new Scanner(System.in);


    private String askPlayerName(String name) {
        System.out.println(name + " please enter a name for yourself: ");
        String username = ask.next();

        while (username.length() < 1) {
            System.out.println("Please enter a valid name.");
            System.out.println(name + " please enter a name for yourself: ");

            username = ask.next();
        }
        return username;
    }

    private String askPlayer2Name(String name, String opponentName) {
        System.out.println(name + " please enter a name for yourself: ");

        String username = ask.next();

        while (username.length() < 1 || username.equalsIgnoreCase(opponentName)) {
            if (username.length() < 1) {
                System.out.println("Please enter a valid name.");
            }
            if (username.equalsIgnoreCase(opponentName)) {
                System.out.println("Please enter a name different than your opponent. (" + opponentName + ")");
            }
            System.out.println(name + " please enter a name for yourself: ");

            username = ask.next();

        }
        return username;
    }

    private char askPlayerMarker(String name) {
        System.out.println(name + " would you like to play as X's or O's?");

        String markerRequest = ask.next();

        while (!markerRequest.equalsIgnoreCase("X") && !markerRequest.equalsIgnoreCase("O")) {
            System.out.println("You must choose either 'X' or 'O' for your marker.");
            System.out.println(name + " would you like to play as X's or O's?");

            markerRequest = ask.next();
        }
        if (markerRequest.equalsIgnoreCase("X")) {
            return 'X';
        } else if (markerRequest.equalsIgnoreCase("O")) {
            return 'O';
        } else {
            System.out.println("askPlayerMarker Error");
            return 'X';
        }
    }

    private boolean askIfMultiplayer() {
        System.out.println("Would you like to play with yourself?");
        String x = ask.next();

        while (!x.equalsIgnoreCase("No") && !x.equalsIgnoreCase("Yes")) {
            System.out.println("You must enter 'Yes' or 'No'.");
            System.out.println("Would you like to play against the computer?");
            x = ask.next();
        }
        if (x.equalsIgnoreCase("Yes")) {
            return false;
        } else if (x.equalsIgnoreCase("No")) {
            return true;
        } else {
            System.out.println("askIfMultiplayer Error");
            return false;
        }
    }

    public int askDifficulty(String name) {
        System.out.println(name + " what difficulty would you like to play at?");
        System.out.println("Dunce   Novice   Adept   Master");

        String response = ask.next();

        while (!response.equalsIgnoreCase("Dunce") && !response.equalsIgnoreCase("Novice") && !response.equalsIgnoreCase("Adept") && !response.equalsIgnoreCase("Master")) {
            System.out.println();
            System.out.println("You must enter one of: ");
            System.out.println("'Dunce' OR 'Novice' OR 'Adept' OR 'Master'");

            response = ask.next();

        }
        if (response.equalsIgnoreCase("Dunce")) {
            return 1;
        } else if (response.equalsIgnoreCase("Novice")) {
            return 2;
        } else if (response.equalsIgnoreCase("Adept")) {
            return 3;
        } else if (response.equalsIgnoreCase("Master")) {
            return 4;
        }
        System.out.println("askDifficulty Error");
        return 4;
    }

    public ComputerPlayer initComp(int level, char comMarker, TicTacToeStrategy strategy) {
        String[] names = new String[5];
        names[0] = "Snuffles";
        names[1] = "Furious Floffles";
        names[2] = "Treacherous Tickler Tiffles";
        names[3] = "Big, Bad, Boisterous Bloffles";
        names[4] = "InitComp Error";

        if (level > 0 && level < 5) {
            return new ComputerPlayer(names[level - 1], comMarker, strategy);
        } else {
            return new ComputerPlayer(names[4], comMarker, strategy);
        }
    }

    public TicTacToeStrategy initStrategy(int level, char comMarker) {
        if (level == 1) {
            return new RandomMoveStrategy(board, comMarker);
        } else if (level == 2) {
            return new BestOpenMove(board, comMarker);
        } else if (level == 3) {
            return new BlockWinStrategy(board, comMarker);
        } else if (level == 4) {
            return new GoForWinStrategy(board, comMarker);
        } else {
            System.out.println("initComp Error");
            return new GoForWinStrategy(board, comMarker);
        }
    }

    private void stalemate() {
        System.out.println("No one wins this time.");
    }

    private boolean playAgain() {
        String playAgain;
        System.out.println("Would you like to play again?");

        playAgain = ask.next();

        return !(playAgain.equalsIgnoreCase("No"));
    }


    private int playerTurn(int x) {
        if (x % 2 == 0) {
            return 0;
        }
        return 1;
    }

    public static void main(String args[]) {
        GameBoard board = new GameBoard();
        board.testGameBoard();

        HumanPlayer player1 = new HumanPlayer("Charles", 'X');
        player1.playerTest();

        ComputerPlayer player2 = new ComputerPlayer("Bart", player1.getEnemyMarker(), new GoForWinStrategy(board, player1.getEnemyMarker()));
        player2.playerTest();
    }
}