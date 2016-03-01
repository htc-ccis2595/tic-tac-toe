package edu.htc.tictactoe.player;
import java.util.Scanner;
/**
 * Created by Manimal on 2/28/2016.
 */
public class HumanPlayer extends Player {
    public HumanPlayer(String playerName, char marker){
        super(playerName, marker);
    }
    private Scanner scanner=new Scanner(System.in);
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
        Player player1=new HumanPlayer("Karen",'X');
        System.out.println(player1);
        player1.addWin();
        System.out.println(player1);
        System.out.println("testing get move method");
        int move=player1.getMove();
        System.out.println("the move was " + move);
    }
}
