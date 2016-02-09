package edu.htc.tictactoe;

public class TicTacToe {

  public void playGame()
  {
      Player player1 = new Player("Brian", 'x');
      System.out.println(player1.getName());
      System.out.println(player1.getMarker());
      System.out.println(player1.getWinCount());
      player1.addWin();
      System.out.println(player1.getWinCount());
      int test = player1.getMove();
      System.out.print(test);
  }

}
