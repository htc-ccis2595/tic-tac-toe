package edu.htc.tictactoe.players;


import edu.htc.tictactoe.GameBoard;

/**
 * Created by Prince Roka on 2/8/2016.
 */
public abstract class Player {
    private String name;
    private char gameMarker;
    private int winCounter;

    public Player(String name, char gameMarker) {
        this.name = name;
        this.gameMarker = gameMarker;
        this.winCounter = 0;
    }

    //Testing
    public void playerTest(Player player) {
        int i;

        System.out.println(player.getName() + " of " + player.getMarker());
        System.out.println();
        System.out.println(player.getName() + " has " + player.getWinCounter() + " wins. Lets change that.");
        for (i = 1; i < 11; i++) {
            player.addWin();
        }
    }

    //Player and Marker Getter
    public String getName() {
        return name;
    }

    public char getMarker() {
        return gameMarker;
    }

    public int getWinCounter() {
        return winCounter;
    }

    public abstract int getMove();

    public boolean outsideRange(int x) {
        return (x < 1 || x > 9);
    }

    public void addWin() {
        winCounter++;
        System.out.println();
        System.out.println("Congrats on your victory " + name);
        if (winCounter < 10) {
            System.out.println("You're sitting at " + winCounter + " wins.");
        } else if (winCounter < 20) {
            System.out.println("You're sitting at an extravagant " + winCounter + " wins.");
        } else if (winCounter < 50) {
            System.out.println("Seriously, how long are you going to keep doing this? " + winCounter + " wins.");
        } else if (winCounter < 100) {
            System.out.println("Your computer looks at you. It is happy it doesn't have a brain that has it do such pointless things. " + winCounter + " wins.");
        } else {
            System.out.println("1%7" + winCounter + "]5l2 winz.");
        }
    }
}
