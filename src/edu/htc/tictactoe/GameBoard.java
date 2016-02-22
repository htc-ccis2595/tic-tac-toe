package edu.htc.tictactoe;

import java.util.ArrayList;
import java.util.function.ToIntFunction;


/**
 * Created by cheey on 2/9/2016.
 */
public class GameBoard {


    char[] board =  {'1','2','3','4','5','6','7','8','9'};
    private int[] [] winCombination = {{1,2,3}, {1,5,9},{1,4,7},{2,5,8},{3,6,9},{3,5,7},{4,5,6},{7,8,9}};
    ArrayList <Integer>openSquares;

    public GameBoard ()
    {
        openSquares = new ArrayList <Integer>(9);
        openSquares.add(1);
        openSquares.add(2);
        openSquares.add(3);
        openSquares.add(4);
        openSquares.add(5);
        openSquares.add(6);
        openSquares.add(7);
        openSquares.add(8);
        openSquares.add(9);
    }

    public GameBoard(char testBoard[])
    {
        openSquares = new ArrayList <Integer>(9);
        board = testBoard;
        for ( int p = 0; p < 9; p++)
        {
            char squareValue = board[p];
            if (squareValue != 'x' && squareValue != 'o')
            {
                openSquares.add(p + 1);
            }
        }
    }



    public void display()
    {
        System.out.println("_____________");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("_____________");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("_____________");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("_____________ \n ");
    }

    public boolean isGameWon()
    {
        for (int win []: winCombination)
        {
            int pos1 = win[0];
            int pos2 = win[1];
            int pos3 = win[2];

            char marker1 = board[pos1 - 1];
            char marker2 = board[pos2 - 1];
            char marker3 = board[pos3 - 1];

            if (marker1 == 'x' && marker2 == 'x' && marker3 == 'x')
            {
                return true;
            }

            else if (marker1 == 'o' && marker2 == 'o' && marker3 == 'o')
            {
                return true;
            }


        }
        return false;
    }

    public int []  getOpenSquares()
    {return openSquares.stream().mapToInt(Integer::intValue).toArray();
    }

   public boolean isSquareOpen(int updateSquare)
   {

           if (board[updateSquare -1] != 'x' && board[updateSquare -1] != 'o')
           {

               return true;

           }
           else
           {
               return false;

           }


   }

    public void updateSquare(int [] update, char board)
    {

    }

    public void getSquareValue(int square)
    {

    }

    public static void main(String[] args)

    {
        //EMPTY BOARD//
        GameBoard empty = new GameBoard();
        empty.display();
        int [] open = empty.getOpenSquares();
        System.out.println("Empty Board. All 9 squares open.\n");
        for ( int p = 0; p < open.length; p++)
        {
            int square = open[p];
            System.out.println(square + "\n");
        }


        //TEST BOARD//
        char[] board =  {'x','2','x','o','5','6','7','8','o'};
        GameBoard test = new GameBoard(board);
        test.display();
        open = test.getOpenSquares();

        System.out.println("Updated Board. Squares: 2,5,6,7,8 are still open.\n");

        for ( int p = 0; p < open.length; p++)
        {
            int square = open[p];
            System.out.println(square + "\n");
        }


        if(test.isSquareOpen(4) == true)
        {
            System.out.println("Square is open.\n");
        }
         else
        {
            System.out.println("Square is NOT open.\n");
        }

        if (test.isGameWon() == true)
        {
            System.out.println("You win!\n");
        }
        else
        {
            System.out.println("Game not won yet.\n");
        }

    }


}


