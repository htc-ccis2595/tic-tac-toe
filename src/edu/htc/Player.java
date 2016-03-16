package edu.htc;
import java.util.Scanner;
import java.util.Random;

public class Player {
     public String playerTolken = "";


    public void setPlayerTolken(){
        String input = "";
        Boolean check = true;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Does Player 1 Want To Be X or O?");
        System.out.println("1 for x 2 for o");

         while(check == true) {
             int num = myScanner.nextInt();
             if(num > 0 && num < 3) {
                 if (num == 1) {
                     playerTolken = "X";
                     check = false;
             }
                 if (num == 2) {
                     playerTolken = "O";
                     check = false;
                 }
             }
         }


    }

    public void takeTurn(){
        boolean check = true;
        Scanner turnScanner = new Scanner(System.in);
        System.out.println("Enter the nubmer of the square you want to take");
        int num = -5;


        while(check == true){
            num = 0;
        num = turnScanner.nextInt();
        if(num > -1 && num < 10 && Main.boardVals.get(num) != "X" && Main.boardVals.get(num) != "O"){
            Main.boardVals.set(num, playerTolken );
            check = false;
        }}


    }


    public void takeRandomSquare(){
        System.out.println("FUNCTION RAN");
    Random myRandom = new Random();
        int val;
        boolean stop = false;
        do {
            val = myRandom.nextInt(9);
            System.out.println(val);
            if(Main.boardVals.get(val) != "X" && Main.boardVals.get(val) != "O"){
                Main.boardVals.set(val, playerTolken);
                stop = true;
        }
        }
        while(stop == false);
    }


}

