package edu.htc.tictactoe;
import edu.htc.tictactoe.player.HumanPlayer;
import edu.htc.tictactoe.player.Player;

import java.util.Scanner;


public class TicTacToe {
    private Scanner scanner = new Scanner(System.in);
    private Player player1;
    private Player player2;
    private GameBoard board;

    public Player setUpPlayer(char marker){
        System.out.println("What is your name? ");
        String name=scanner.next();
        validateName(name);
        while (validateName(name)== false){
            System.out.println("Not a valid name, What is your name?");
            name=scanner.next();
        }
        System.out.println(name + " your marker will be " + marker);
        Player newPlayer=new HumanPlayer(name,marker);
        return newPlayer;
    }
    public boolean validateName(String name){
        name=name.trim();
        if(name.length()>1){
            return true;
        }
        else{
            return false;
        }
    }
    public void playGame() {
        player1=setUpPlayer('X');
        player2=setUpPlayer('O');
        boolean playAgain=true;
        while(playAgain==true) {
            board = new GameBoard();
            while (board.isGameWon() == false && board.getOpenSquares().length > 0) {
                doPlayerMove(player1);

                if (board.isGameWon() == false && board.getOpenSquares().length>0) {
                    doPlayerMove(player2);
                }
            }
            board.display();
            System.out.println("would you like to play again? answer Y or N");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("n")) {
                playAgain=false;
            }
        }



    }

    private void doPlayerMove(Player player) {
        board.display();
        int move1=player.getMove();
        while (board.isSquareOpen(move1)==false){
            System.out.println("that square is not open. pick another square.");
            move1=player.getMove();
        }
        board.updateSquare(move1,player.getMarker());
        if( board.isGameWon()==true){
            System.out.println("Congrats "+player.getPlayerName()+ " you have won the game!");
        }
    }

    public static void main(String[] args){
        TicTacToe ttt=new TicTacToe();
        System.out.println("testing create player");
        Player newPlayer=ttt.setUpPlayer('X');
        System.out.println("testing play game");
        ttt.playGame();

  }
}
