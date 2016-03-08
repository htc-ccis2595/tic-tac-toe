package edu.htc.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import edu.htc.tictactoe.*;

/**
 * Created by Student on 3/7/2016.
 */

public class PlayerTest {
    @Test
    public void getName(){
        Player testPlayer = new Player("Tester",'x');
        assertEquals("Tester",'x');
    }

}
