package ar.edu.unrc.dc.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import ar.edu.unrc.dc.model.Position;
import ar.edu.unrc.dc.model.Projectile;
import ar.edu.unrc.dc.model.StarFighter;


public class StarFighterTest {
    
    @Test
    public void starFighterConstructorPass() {

        int row = 2;
        int column = 3;
        Position starFighterPosition = new Position(row,column);
        int starFighterMoveSpeed = 3;
        int projectileMoveSpeed = 2;
        
        StarFighter starFighter = new StarFighter(starFighterPosition, starFighterMoveSpeed, projectileMoveSpeed);

        assertEquals(2,starFighter.getProjectileMoveSpeed());
        assertEquals(3, starFighter.getmoveSpeed());
        assertEquals(starFighterPosition, starFighter.getPosition());

    }

    @Test
    public void starFighterConstructorFailIllegalMoveSpeed() {
        
        int row = 2;
        int column = 3;
        Position starFighterPosition = new Position(row,column);
        int starFighterMoveSpeed = -1;
        int projectileMoveSpeed = 2;

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new StarFighter(starFighterPosition, starFighterMoveSpeed, projectileMoveSpeed));
        
        assertEquals("Starfighter moves must be between 1 and 40", exception.getMessage());

    }

    @Test
    public void starFighterConstructorFailIllegalProjectileMoveSpeed() {
        
        int row = 2;
        int column = 3;
        Position starFighterPosition = new Position(row,column);
        int starFighterMoveSpeed = 3;
        int projectileMoveSpeed = -1;

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new StarFighter(starFighterPosition, starFighterMoveSpeed, projectileMoveSpeed));
        
        assertEquals("Projectile MoveSpeed must be between 1 and 5", exception.getMessage());

    }

    @Test
    public void projectileConstructorPass() {

        int row = 2;
        int column = 3;
        Position starFighterPosition = new Position(2,3);
        int starFighterMoveSpeed = 3;
        int projectileMoveSpeed = 2;
        Position projectilePosition = new Position(row, column+1);
        StarFighter starFighter = new StarFighter(starFighterPosition, starFighterMoveSpeed, projectileMoveSpeed);

        Projectile projectile = starFighter.createProjectile();

        assertEquals(projectileMoveSpeed, projectile.getmoveSpeed());
        assertEquals(projectilePosition, projectile.getPosition());

    }

}
