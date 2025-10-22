package ar.edu.unrc.dc.tdd;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import ar.edu.unrc.dc.model.Abort;
import ar.edu.unrc.dc.model.Board;
import ar.edu.unrc.dc.model.Move;
import ar.edu.unrc.dc.model.Position;
import ar.edu.unrc.dc.model.Projectile;
import ar.edu.unrc.dc.model.RulesImplements;
import ar.edu.unrc.dc.model.StarFighter;
import ar.edu.unrc.dc.model.StarfighterGameEngine;

public class RulesImplementsTest {

    @Test
    public void testCollisionMoveNoObstacles() {
        Board board = new Board(5, 5);
        StarFighter star = new StarFighter(new Position(2, 1), 5, 1);
        board.addObjectToBoard(star);

        StarfighterGameEngine engine = new StarfighterGameEngine();
        engine.play(5, 5, 5, 1);

        RulesImplements rules = new RulesImplements();
        Move move = new Move(1, 0); 
        assertFalse(rules.collision(engine, move));
    }


    @Test
    public void testCollisionVerticalObstacle() {
        StarfighterGameEngine engine = new StarfighterGameEngine();
        engine.play(5, 5, 5, 1);

        StarFighter star = engine.getStarFighter();
        star.setPosition(new Position(1, 1));

        Projectile proj = new Projectile(new Position(2, 1), 1);
        engine.getBoard().addObjectToBoard(proj);

        RulesImplements rules = new RulesImplements();
        Move move = new Move(2, 0); 

            assertTrue(rules.collision(engine, move));
    }



    @Test
    public void testCollisionHorizontalObstacle() {
        Board board = new Board(5, 5);
        Position starPos = new Position(2, 1);
        StarFighter star = new StarFighter(starPos, 5, 1);
        Projectile proj = new Projectile(new Position(2, 3), 1);

        board.addObjectToBoard(star);
        board.addObjectToBoard(proj);

        StarfighterGameEngine engine = new StarfighterGameEngine();
        engine.play(5, 5, 5, 1);
        engine.getBoard().addObjectToBoard(star);
        engine.getBoard().addObjectToBoard(proj);

        RulesImplements rules = new RulesImplements();
        Move move = new Move(0, 3); 
        assertTrue(rules.collision(engine, move));
    }


    @Test
    public void testGameOverWhenStarfighterDead() {
        StarfighterGameEngine engine = new StarfighterGameEngine();
        engine.play(5, 5, 5, 1);
        engine.getStarFighter().setAlive(false);

        RulesImplements rules = new RulesImplements();
        Move move = new Move(0, 1);
        assertTrue(rules.gameOver(engine, move));
    }

    @Test
    public void testGameOverByAbort() {
        StarfighterGameEngine engine = new StarfighterGameEngine();
        engine.play(5, 5, 5, 1);

        RulesImplements rules = new RulesImplements();
        Abort abort = new Abort();
        assertTrue(rules.gameOver(engine, abort));
    }

    @Test
    public void testGameOverNormalNoCollision() {
        StarfighterGameEngine engine = new StarfighterGameEngine();
        engine.play(5, 5, 5, 1);

        RulesImplements rules = new RulesImplements();
        Move move = new Move(1, 0);
        assertFalse(rules.gameOver(engine, move));
    }
}
