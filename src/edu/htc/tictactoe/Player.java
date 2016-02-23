package edu.htc.tictactoe;
import java.util.Scanner;

public class Player{
    private String playerName;
    private char marker;
    private int winCounter;
    private Scanner scanner=new Scanner(System.in);
    public Player(String playerName,char marker){
        this.playerName=playerName;
        this.marker=marker;
        winCounter=0;
    }


    public String getPlayerName() {
        return playerName;
    }

    public char getMarker() {
        return marker;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", marker=" + marker +
                ", winCounter=" + winCounter +
                '}';
    }

    public void addWin(){
        winCounter++;
    }
    public int getMove(){
        System.out.println("Which square would you like to choose: ");
        while(true) {
            int move = scanner.nextInt();
            if (move < 10 && move > 0) {
                return move;
            } else {
                System.out.println("Please choose a square using numbers 1-9");
            }
        }
    }

    public static void main(String[] args){
        Player player1=new Player("Karen",'X');
        System.out.println(player1);
        player1.addWin();
        System.out.println(player1);
        System.out.println("testing get move method");
        int move=player1.getMove();
        System.out.println("the move was " + move);
    }

}

