package edu.htc.tictactoe;
import java.util.Scanner;

/**
 * Created by Gyan on 2/14/2016.
 */
public class Player {

    private String name;
    private char gameMarker;
    private int winCounter=0;

    public Player(String name, char gameMarker){
       this.name = name;
        this.gameMarker = gameMarker;
    }

    public int addWin(){
        winCounter++;
        return winCounter;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public char getGameMarker() {
        return gameMarker;
    }

    public void setGameMarker(char gameMarker) {
        this.gameMarker = gameMarker;
    }

    public int getMove(){
        Scanner scanner = new Scanner(System.in);
        int square = 0;
        while(true){
            System.out.println("Choose the box you want to play? ");
            square = scanner.nextInt();
            if(square >=1 && square <= 9){
                return square;
            }else {
                System.out.println("Entry is not Valid! choose between (1-9)");
            }
        }



    }


}
