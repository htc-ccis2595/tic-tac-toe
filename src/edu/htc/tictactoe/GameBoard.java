package edu.htc.tictactoe;

import java.util.ArrayList;

/**
 * Created by joe on 3/16/2016.
 */
public class GameBoard {
    public static ArrayList<String> boardVals = new ArrayList<>();

    public static void createBoard(){
        boardVals.add("0");
        boardVals.add("1");
        boardVals.add("2");
        boardVals.add("3");
        boardVals.add("4");
        boardVals.add("5");
        boardVals.add("6");
        boardVals.add("7");
        boardVals.add("8");



    }
    public static void showBoard(){
        System.out.println("*****************************************************************");
        System.out.println(boardVals.get(0) + " " + boardVals.get(1) + " " + boardVals.get(2));
        System.out.println(boardVals.get(3) + " " + boardVals.get(4) + " " + boardVals.get(5));
        System.out.println(boardVals.get(6) + " " + boardVals.get(7) + " " + boardVals.get(8));
        System.out.println("*****************************************************************");
    }

    public static boolean isGameOver(){

        String s1 = boardVals.get(0);
        String s2 = boardVals.get(1);
        String s3 = boardVals.get(2);
        String s4 = boardVals.get(3);
        String s5 = boardVals.get(4);
        String s6 = boardVals.get(5);
        String s7= boardVals.get(6);
        String s8 = boardVals.get(7);
        String s9 = boardVals.get(8);
        if(s1 == s2 && s1 == s3){return true;}
        if(s4 == s5 && s4 == s6){return true;}
        if(s7 == s8 && s7 == s9){return true;}
        if(s1 == s4 && s1 == s7){return true;}
        if(s2 == s5 && s2 == s8){return true;}
        if(s3 == s6 && s3 == s9){return true;}
        if(s1 == s5 && s1 == s9){return true;}
        if(s3 == s5 && s3 == s7){return true;}
        else{
            return false;
        }}



}

