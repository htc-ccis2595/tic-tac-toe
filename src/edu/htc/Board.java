package edu.htc;



public class Board {

public static void createBoard(){
    Main.boardVals.add("0");
    Main.boardVals.add("1");
    Main.boardVals.add("2");
    Main.boardVals.add("3");
    Main.boardVals.add("4");
    Main.boardVals.add("5");
    Main.boardVals.add("6");
    Main.boardVals.add("7");
    Main.boardVals.add("8");



}
public static void showBoard(){
    System.out.println("*****************************************************************");
    System.out.println(Main.boardVals.get(0) + " " + Main.boardVals.get(1) + " " + Main.boardVals.get(2));
    System.out.println(Main.boardVals.get(3) + " " + Main.boardVals.get(4) + " " + Main.boardVals.get(5));
    System.out.println(Main.boardVals.get(6) + " " + Main.boardVals.get(7) + " " + Main.boardVals.get(8));
    System.out.println("*****************************************************************");
}

public static boolean isGameOver(){

    String s1 = Main.boardVals.get(0);
    String s2 = Main.boardVals.get(1);
    String s3 = Main.boardVals.get(2);
    String s4 = Main.boardVals.get(3);
    String s5 = Main.boardVals.get(4);
    String s6 = Main.boardVals.get(5);
    String s7= Main.boardVals.get(6);
    String s8 = Main.boardVals.get(7);
    String s9 = Main.boardVals.get(8);
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

