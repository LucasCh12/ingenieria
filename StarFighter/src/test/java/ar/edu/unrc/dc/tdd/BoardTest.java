package ar.edu.unrc.dc.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import ar.edu.unrc.dc.model.Board;
import ar.edu.unrc.dc.model.BoardObject;
import ar.edu.unrc.dc.model.Position;
import ar.edu.unrc.dc.model.Projectile;
import ar.edu.unrc.dc.model.StarFighter;

public class BoardTest {

    @Test
    public void testConstructorValidRowAndcolumn() {

        int row = 3;
        int column = 5;

        Board board = new Board(row,column);

        assertEquals(3, board.getRow());
        assertEquals(5, board.getColumn());

    }

    @Test
    public void testConstructorIllegalArgumentForRow() {

        int row = 2;
        int column = 5;

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Board(row,column));

        assertEquals("Rows must be between 3 and 10", exception.getMessage());

    }

    @Test
    public void testConstructorIllegalArgumentForcolumn() {

        int row = 3;
        int column = 4;

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Board(row,column));
        
        assertEquals("columns must be between 5 and 30", exception.getMessage());

    }

    @Test
    public void testSetRowAndcolumnPass() {

        int row = 3;
        int column = 5;
        Board board = new Board(row,column);

        board.setRow(4);
        board.setColumn(6);

        assertEquals(4, board.getRow());
        assertEquals(6, board.getColumn());
        
    }

    @Test
    public void testAddStarFighterPass(){
        
        int row = 3;
        int column = 5;
        Position startFighterPosition = new Position(row / 2, column / 2);
        BoardObject starFighter = new StarFighter(startFighterPosition, 2, 2);
        Board board = new Board(row,column);
        
        board.addObjectToBoard(starFighter);

        assertEquals(1,board.getObjectCount());
        assertTrue(board.isOccupied(startFighterPosition));
        
    }

    @Test
    public void testAddStarFighterIllegalPosition() {

        int row = 3;
        int column = 5;
        Position startFighterPosition = new Position(5, 2);
        BoardObject starFighter = new StarFighter(startFighterPosition, 2, 2);
        Board board = new Board(row,column);

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> board.addObjectToBoard(starFighter));
        
        assertEquals("Invalid object position", exception.getMessage());

    }

    @Test
    public void testAddStarFighterOccupied() {

        int row = 3;
        int column = 5;
        Position startFighterPosition = new Position(row / 2, column / 2);
        BoardObject starFighter1 = new StarFighter(startFighterPosition, 2, 2);
        BoardObject starFighter2 = new StarFighter(startFighterPosition, 3, 3);
        Board board = new Board(row,column);
        
        board.addObjectToBoard(starFighter1);
        board.addObjectToBoard(starFighter2);
        
        assertEquals(1,board.getObjectCount());
        assertTrue(board.isOccupied(startFighterPosition));

    }

    @Test
    public void testAddProjectilePass(){
        
        int row = 3;
        int column = 5;
        Position projectilePosition = new Position(row / 2, column / 2);
        BoardObject projectile = new Projectile(projectilePosition,2);
        Board board = new Board(row,column);
        
        board.addObjectToBoard(projectile);

        assertEquals(1,board.getObjectCount());
        assertTrue(board.isOccupied(projectilePosition));
        
    }

    @Test
    public void testAddProjectileOffGrid() {

        int row = 3;
        int column = 5;
        Position projectilePosition = new Position(3, 5);
        BoardObject projectile = new Projectile(projectilePosition,2);
        Board board = new Board(row,column);
        
        board.addObjectToBoard(projectile);

        assertEquals(0,board.getObjectCount());

    }

    @Test
    public void testAddStarProjectileOccupied() {

        int row = 3;
        int column = 5;
        Position projectilePosition = new Position(row / 2, column / 2);
        BoardObject projectile1 = new Projectile(projectilePosition,2);
        BoardObject projectile2 = new Projectile(projectilePosition,2);
        Board board = new Board(row,column);
        
        board.addObjectToBoard(projectile1);
        board.addObjectToBoard(projectile2);
        
        assertEquals(1,board.getObjectCount());
        assertTrue(board.isOccupied(projectilePosition));

    }
    
}
