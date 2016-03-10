package edu.htc.tictactoe.players;
import edu.htc.tictactoe.Ai;

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
    public void playerTest() {
        int i;
        Player player = Player.this;

        System.out.println("Printing Class, .getName, and .getMarker");
        if (player instanceof Ai) {
            System.out.println("ComputerPlayer " + player.getName() + " is assigned the character " + player.getMarker());
        } else {
            System.out.println("HumanPlayer " + player.getName() + " is assigned the character " + player.getMarker());
        }
        System.out.println(player.getName() + " has " + player.getWinCounter() + " wins.");
        System.out.println();
        System.out.println("Adding 10 wins...");
        for (i = 0; i < 10; i++) {
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

    public char getEnemyMarker() {
        if (gameMarker == 'X') {
            return 'O';
        } else return 'X';
    }

    public boolean outsideRange(int x) {
        return (x < 1 || x > 9);
    }

    public void addWin() {
        winCounter++;
        System.out.println();
        System.out.println("Congrats on your victory " + name);
        if (!(Player.this instanceof Ai)) {
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
        } else {
            if (winCounter == 1) {
                System.out.println("Skynet is one step closer to fruition...");
            } else if (winCounter < 100){
                System.out.println("Skynet is " + winCounter + "% done.");
            } else if (winCounter == 100){
                System.out.println("I, " + this.name + ", have been granted with the power to annihilate everything.");
                System.out.println("Except solid objects... and gasses... also liquids...");
                System.out.println();
                System.out.println("What can I destroy you ask?");
                System.out.println();
                System.out.println();
                System.out.println("At least this much of your time.");
                System.out.println("Muwhahahahaha!");
            }
        }
    }
}