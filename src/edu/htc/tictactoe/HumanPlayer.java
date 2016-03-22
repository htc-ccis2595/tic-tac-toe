package edu.htc.tictactoe;
import java.util.Scanner;

/**
 * Created by Gyan on 02/21/2016.
 */
public class HumanPlayer extends Player{
    public HumanPlayer(String name, char gameMarker){
        super(name,gameMarker);
    }

    public int getMove(){
        Scanner scanner = new Scanner(System.in);
        int square =0;
        while(true){
            System.out.println();
            System.out.println("Select the square you want to play " + getName()+ "?");
            square = scanner.nextInt();
            if(square>0 && square <10){
                return square;
            }else{
                System.out.println("Choose the number between 1-9!");
            }
        }
    }

}
