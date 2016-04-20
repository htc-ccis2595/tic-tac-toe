package edu.htc.tictactoe;

import java.util.Scanner;
import edu.htc.tictactoe.player.*;
import edu.htc.tictactoe.strategy.*;


public class TicTacToe {

    private Player player1;
    private Player player2;
    private GameBoard game;


    Scanner scanner = new Scanner(System.in);

    public TicTacToe() {
        game = new GameBoard();
    }

    public void playGame() {

        System.out.println("Lets play some good ol' Tic Tac Toe!\n");

        System.out.println("How many players are playing?");
        String playersInt = scanner.next();

        while (!playersInt.equals("1") && !playersInt.equals("2")) {
            System.out.println("Please enter '1' or '2' players.");
            playersInt = scanner.next();}

        Integer players = Integer.parseInt(playersInt);

            if (players == 1 || players == 2) {
                String playAgain;

                if (players.equals(1))
                //////////////////////////////1 PLAYER GAME WITH COMPUTER/////////////////////////////
                {
                    System.out.print("Player1 Name: ");
                    String Name = scanner.next();

                    while(Name.length() < 3){
                        System.out.println("Please enter a name more than three(3) characters long.");
                        Name = scanner.next();
                    }

                    char gameMarker = 'X';
                    player1 = new HumanPlayer(Name, gameMarker);

                    System.out.print("Computer player difficulty:\n" +
                            "Lv1[Easy] - Lv4[Hard]:");
                    String compLevelInt = scanner.next();
                    Integer compLevel = Integer.parseInt(compLevelInt);

                    while(compLevel > 4 || compLevel < 1){
                        System.out.println("Please enter 1 through 4");
                        compLevelInt = scanner.next();
                        compLevel = Integer.parseInt(compLevelInt);
                    }

                    String Name2 = "Computer";
                    char gameMarker2 = 'O';

                    if (compLevel.equals(1)) {
                        TicTacToeStrategy strategy = new RandomMoveStrategy(game);
                        player2 = new ComputerPlayer(Name2, gameMarker2, strategy);
                    } else if (compLevel.equals(2)) {
                        TicTacToeStrategy strategy1 = new BestOpenMoveStrategy(game);
                        player2 = new ComputerPlayer(Name2, gameMarker2, strategy1);
                    } else if (compLevel.equals(3)) {
                        TicTacToeStrategy strategy2 = new BlockWinStrategy(game);
                        player2 = new ComputerPlayer(Name2, gameMarker2, strategy2);
                    } else if (compLevel.equals(4)) {
                        TicTacToeStrategy strategy3 = new GoForWinStrategy(game);
                        player2 = new ComputerPlayer(Name2, gameMarker2, strategy3);
                    }

                    do {
                    while (game.isGameWon() == false) {



                            //PLAYER1 PROMPT
                            game.display();
                            int move = player1.getMove();
                            game.isSquareOpen(move);
                            if (game.isSquareOpen(move) == true) {
                                game.updateSquare(move, gameMarker);
                            }

                            if (game.isGameWon() == true) {
                                game.display();
                                System.out.println(Name + " is the winner!");
                                player1.addWin();
                                System.out.println(Name + "'s win count is: " + player1.getWinCount() + " win(s).\n");

                            } else if (game.getOpenSquares().length == 0) {
                                System.out.println("Tied Game.\n");
                                break;

                            }

                            //COMPUTER PLAYER
                            else {
                                int move2 = player2.getMove();
                                if (game.isSquareOpen(move2) == true) {
                                    game.updateSquare(move2, gameMarker2);
                                }

                                if (game.isGameWon() == true) {
                                    game.display();
                                    System.out.println(Name2 + " is the winner!");
                                    game.display();
                                    player2.addWin();
                                    System.out.println(Name2 + "'s win count is: " + player2.getWinCount() + " win(s).\n");
                                } else if (game.getOpenSquares().length == 0) {
                                    System.out.println("Tied Game.\n");
                                    break;
                                }
                            }


                        }
                        System.out.println("Play Again?");
                        playAgain = scanner.next();
                    } while (!playAgain.equalsIgnoreCase("Yes") && !playAgain.equalsIgnoreCase("No")) ;
                    if (playAgain.equalsIgnoreCase("Yes")) {
                        TicTacToe ticTac2 = new TicTacToe();

                        ticTac2.playGame();

                    } else {
                        System.out.println("Thanks for playing!\n");

                    }


                }


///////////////////////2 PLAYER GAME////////////////////////////////////
                else if (players.equals(2)) {
                    //Player1
                    System.out.print("Player1 Name: ");
                    String Name = scanner.next();
                    while(Name.length() < 3){
                        System.out.println("Please enter a name more than three(3) characters long.");
                        Name = scanner.next();
                    }
                    char gameMarker = 'X';
                    player1 = new HumanPlayer(Name, gameMarker);

                    //Player2
                    System.out.print("Player2 Name: ");
                    String Name2 = scanner.next();
                    while(Name2.length() < 3){
                        System.out.println("Please enter a name more than three(3) characters long.");
                        Name2 = scanner.next();
                    }
                    char gameMarker2 = 'O';
                    player2 = new HumanPlayer(Name2, gameMarker2);

                    do {

                        while (game.isGameWon() == false)

                        {
                            /////////////////////////////PLAYER1 PROMPT/////////////////////////////
                            game.display();
                            int move = player1.getMove();
                            game.isSquareOpen(move);
                            if (game.isSquareOpen(move) == true) {
                                game.updateSquare(move, gameMarker);
                            }

                            if (game.isGameWon() == true) {
                                game.display();
                                System.out.println(Name + " is the winner!");
                                player1.addWin();
                                System.out.println(Name + "'s win count is: " + player1.getWinCount() + " win(s).\n");

                            } else if (game.getOpenSquares().length == 0) {
                                System.out.println("Tied Game.\n");
                                break;


                                /////////////////////////////PLAYER2 PROMPT/////////////////////////////
                            } else {
                                game.display();
                                int move2 = player2.getMove();
                                if (game.isSquareOpen(move2) == true) {
                                    game.updateSquare(move2, gameMarker2);
                                }

                                if (game.isGameWon() == true) {
                                    game.display();
                                    System.out.println(Name2 + " is the winner!");
                                    game.display();
                                    player2.addWin();
                                    System.out.println(Name2 + "'s win count is: " + player2.getWinCount() + " win(s).\n");
                                } else if (game.getOpenSquares().length == 0) {
                                    System.out.println("Tied Game.\n");
                                    break;
                                }
                            }
                        }

                        System.out.println("Play Again?");
                        playAgain = scanner.next();
                    } while (!playAgain.equalsIgnoreCase("Yes") && !playAgain.equalsIgnoreCase("No"));

                    if (playAgain.equalsIgnoreCase("Yes")) {
                        TicTacToe ticTac2 = new TicTacToe();

                        ticTac2.playGame();
                    }
                    else {
                        System.out.println("Thanks for playing!\n");

                    }
                }
            }
}





    public static void main(String[] args) {

        TicTacToe ticTac = new TicTacToe();

        ticTac.playGame();



    }



    }
