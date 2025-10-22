package ar.edu.unrc.dc.tdd;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import ar.edu.unrc.dc.model.StarfighterGameEngine;

public class StartFighterGameEngineTest {

    @Test
    public void testInitialState() {

       StarfighterGameEngine engine = new StarfighterGameEngine();

       assertFalse(engine.isGameActive());
       assertNull(engine.getBoard());
       
    }

    @Test
    public void testPlay () {

        StarfighterGameEngine engine = new StarfighterGameEngine();

        engine.play(5, 8, 4, 2);

        assertTrue(engine.isGameActive());
        assertNotNull(engine.getBoard());

    }

    @Test
    public void testPlayInvalidRows() {

        StarfighterGameEngine engine = new StarfighterGameEngine();

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> engine.play(2, 8, 4, 2)
        );

        assertEquals("Rows must be between 3 and 10", exception.getMessage());

    }

    @Test
    public void testPlayInvalidColumns() {

        StarfighterGameEngine engine = new StarfighterGameEngine();

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> engine.play(5, 40, 4, 2)
        );

        assertEquals("columns must be between 5 and 30", exception.getMessage());
        
    }

    @Test
    public void testInvalidFire () {

        StarfighterGameEngine engine = new StarfighterGameEngine();

         IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> engine.fire());

        assertEquals("Inactive game", exception.getMessage());
    }

    @Test
    public void testFire() {

        StarfighterGameEngine engine = new StarfighterGameEngine();

        engine.play(5, 8, 4, 2);

        assertDoesNotThrow(() -> engine.fire());

    }

    @Test
    public void testInvalidPass() {

        StarfighterGameEngine engine = new StarfighterGameEngine();

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> engine.pass()
        );

        assertEquals("Inactive game", exception.getMessage());

    }

    @Test
    public void testPass() {

        StarfighterGameEngine engine = new StarfighterGameEngine();

        engine.play(5, 8, 4, 2);

        assertDoesNotThrow(() -> engine.pass());

    }

    @Test
    public void testInvalidAbort() {

        StarfighterGameEngine engine = new StarfighterGameEngine();

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> engine.abort()
        );

        assertEquals("Inactive game", exception.getMessage());

    }

    @Test
    public void testAbort() {

        StarfighterGameEngine engine = new StarfighterGameEngine();

        engine.play(5, 8, 4, 2);

        assertDoesNotThrow(() -> engine.abort());

    }

     @Test
    public void testInvalidMove() {
        
        StarfighterGameEngine engine = new StarfighterGameEngine();

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> engine.move(1, 1)
        );

        assertEquals("Inactive game", exception.getMessage());

    }

     @Test
    public void testMoveToInvalidPosition() {

        StarfighterGameEngine engine = new StarfighterGameEngine();

        engine.play(5, 8, 4, 2);
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> engine.move(100, 100)
        );

        assertEquals("Incorrect position for object in board", exception.getMessage());

    }

    @Test
    public void testMove() {

        StarfighterGameEngine engine = new StarfighterGameEngine();
        engine.play(5, 8, 4, 2);
        assertDoesNotThrow(() -> engine.move(1, 0));

    }

}
