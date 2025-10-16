import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

public class TestGame {
    
    @Test
    public void testrollNegative(){
        Game g = new Game();
        assertThrows(IllegalArgumentException.class, () -> {
            g.roll(-1);
        });
    }

    @Test
    public void testStrike(){
        Game g = new Game();
        g.roll(10);
        assertTrue(g.strike(0));
    }

    @Test
    public void testSpare(){
        Game g = new Game();
        g.roll(7);
        g.roll(3);
        assertTrue(g.spare(0));
    }

    @Test
    public void testScoreSpare(){
        Game g = new Game();
        g.roll(7);
        g.roll(3);


        g.roll(4);
        g.roll(2);

        g.roll(5);
        g.roll(3);

        g.roll(6);
        g.roll(2);

        g.roll(8);
        g.roll(1);

        g.roll(9);
        g.roll(0);

        g.roll(4);
        g.roll(4);

        g.roll(2);
        g.roll(7);

        g.roll(1);
        g.roll(8);

        g.roll(3);
        g.roll(5);

        assertEquals(88, g.score());
    }

     @Test
    public void testStrikeInMiddle() {
        Game g = new Game();

        // Frame 1: 4 + 3
        g.roll(4);
        g.roll(3);

        // Frame 2: 5 + 2
        g.roll(5);
        g.roll(2);

        // Frame 3: 10 (strike)
        g.roll(10);

        // Frame 4: 3 + 4
        g.roll(3);
        g.roll(4);

        // Frame 5: 2 + 6
        g.roll(2);
        g.roll(6);

        // Frame 6: 1 + 7
        g.roll(1);
        g.roll(7);

        // Frame 7: 4 + 3
        g.roll(4);
        g.roll(3);

        // Frame 8: 5 + 2
        g.roll(5);
        g.roll(2);

        // Frame 9: 3 + 4
        g.roll(3);
        g.roll(4);

        // Frame 10: 2 + 6
        g.roll(2);
        g.roll(6);

        /*
        Cálculo de score:
        Frame 1: 4+3 = 7          → total 7
        Frame 2: 5+2 = 7          → total 14
        Frame 3: strike 10 + 3+4 = 17 → total 31
        Frame 4: 3+4 = 7          → total 38
        Frame 5: 2+6 = 8          → total 46
        Frame 6: 1+7 = 8          → total 54
        Frame 7: 4+3 = 7          → total 61
        Frame 8: 5+2 = 7          → total 68
        Frame 9: 3+4 = 7          → total 75
        Frame 10: 2+6 = 8         → total 83
        */

        assertEquals(83, g.score());
    }

}




