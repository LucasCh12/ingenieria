package ar.edu.unrc.dc.tdd;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import ar.edu.unrc.dc.model.board.Board;
import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.board.objects.BoardObject;
import ar.edu.unrc.dc.model.board.objects.entities.StatsEntities;
import ar.edu.unrc.dc.model.board.objects.entities.fighters.StarFighter;

//TODO: Los test ahora deberian tomar las stats y la energy especificas
public class BoardTest {
   /** @Test
    public void testConstructorValidRowAndcolumn() {

        int row = 3;
        int column = 5;

        Position starFighterPosition = new Position(row / 2, column / 2);
        StarFighter starFighter = new StarFighter(starFighterPosition,2,2,13);
        Board board = new Board(row,column, starFighter);

        assertEquals(3, board.getRow());
        assertEquals(5, board.getColumn());

    }

    @Test
    public void testConstructorIllegalArgumentForRow() {

        int row = 2;
        int column = 5;

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Board(row,column, null));

        assertEquals("Rows must be between 3 and 10", exception.getMessage());

    }

    @Test
    public void testConstructorIllegalArgumentForcolumn() {

        int row = 3;
        int column = 4;

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Board(row,column, null));
        
        assertEquals("columns must be between 5 and 30", exception.getMessage());

    }

    @Test
    public void testSetRowAndcolumnPass() {

        int row = 3;
        int column = 5;
        Position starFighterPosition = new Position(row / 2, column / 2);
        StarFighter starFighter = new StarFighter(starFighterPosition,2,2,13);
        Board board = new Board(row,column, starFighter);

        board.setRow(4);
        board.setColumn(6);

        assertEquals(4, board.getRow());
        assertEquals(6, board.getColumn());
        
    }

    @Test
    public void testAddStarFighterPass(){
        
        int row = 3;
        int column = 5;
        Position starFighterPosition = new Position(row / 2, column / 2);
        StarFighter starFighter = new StarFighter(starFighterPosition,2,2,13);
        Board board = new Board(row,column, starFighter);
        
        assertEquals(1,board.getObjectCount());
        assertTrue(board.isOccupied(starFighterPosition));
        
    }

    @Test
    public void testAddStarFighterIllegalPosition() {

        int row = 3;
        int column = 5;
        Position starFighterPosition = new Position(5, 2);
        StarFighter starFighter = new StarFighter(starFighterPosition,2,2,13);
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Board(row,column, starFighter));
        
        assertEquals("Invalid object position", exception.getMessage());

    }

    @Test
    public void testAddStarFighterOccupied() {

        int row = 3;
        int column = 5;
        Position starFighterPosition = new Position(row / 2, column / 2);
        BoardObject starFighter1 = new StarFighter(starFighterPosition,2,2,13);
        BoardObject starFighter2 = new StarFighter(starFighterPosition, 3, 3,13);
        StarFighter starFighter = new StarFighter(starFighterPosition,2,2,13);
        Board board = new Board(row,column, starFighter);
        
        board.addObjectToBoard(starFighter1);
        board.addObjectToBoard(starFighter2);
        
        assertEquals(1,board.getObjectCount());
        assertTrue(board.isOccupied(starFighterPosition));

    }

    @Test
    public void testAddProjectilePass(){
        
        int row = 3;
        int column = 5;
        Position projectilePosition = new Position(row / 2, column / 2);
        BoardObject projectile = new Projectile(projectilePosition,2);
        Position starFighterPosition = new Position(row / 2, column / 2);
        StarFighter starFighter = new StarFighter(starFighterPosition,2,2,13);
        Board board = new Board(row,column, starFighter);
        
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
        Position starFighterPosition = new Position(row / 2, column / 2);
        StarFighter starFighter = new StarFighter(starFighterPosition,2,2,13);
        Board board = new Board(row,column, starFighter);
        
        board.addObjectToBoard(projectile);


        assertEquals(1,board.getObjectCount());

    }

    @Test
    public void testAddStarProjectileOccupied() {

        int row = 3;
        int column = 5;
        Position projectilePosition = new Position(row / 2, column / 2);
        BoardObject projectile1 = new Projectile(projectilePosition,2);
        BoardObject projectile2 = new Projectile(projectilePosition,2);
        Position starFighterPosition = new Position(row / 2, column / 2);
        StarFighter starFighter = new StarFighter(starFighterPosition,2,2,13);
        Board board = new Board(row,column, starFighter);
        
        board.addObjectToBoard(projectile1);
        board.addObjectToBoard(projectile2);
        
        assertEquals(1,board.getObjectCount());
        assertTrue(board.isOccupied(projectilePosition));

    }
**/
    /* 
    @Test
    public void testSetRowAndcolumnPass() {

        int row = 3;
        int column = 5;
        Position starFighterPosition = new Position(row / 2, column / 2);
        StatsEntities stats = new StatsEntities(50, 5, 5, 4, "Grunt", 2);
        StarFighter starFighter = new StarFighter(starFighterPosition,2,stats,13);
        Board board = new Board(row,column, starFighter);

        board.setRow(4);
        board.setColumn(6);

        assertEquals(4, board.getRow());
        assertEquals(6, board.getColumn());
        
    }

    @Test
    public void getObjectsInBoard(){
        int row = 3;
        int column = 5;
        Position starFighterPosition = new Position(row / 2, column / 2);
        StatsEntities stats = new StatsEntities(50, 5, 5, 4, "Grunt", 2);
        StarFighter starFighter = new StarFighter(starFighterPosition,2,stats,13);
        Board board = new Board(row,column, starFighter);
        List<BoardObject> auxList = board.getObjects();
        assertEquals(1,auxList.size());
    }

    @Test
public void testEquals_SameObject() {
    int row = 3;
    int column = 5;
    Position starFighterPosition = new Position(row / 2, column / 2);
    StatsEntities stats = new StatsEntities(50, 5, 5, 4, "Grunt", 2);
    StarFighter starFighter = new StarFighter(starFighterPosition,2,stats,13);
    Board board = new Board(row, column, starFighter);
    
    assertTrue(board.equals(board)); // this == o
}

    @Test
    public void testEquals_NullObject() {
        int row = 3;
        int column = 5;
        Position starFighterPosition = new Position(row / 2, column / 2);
        StatsEntities stats = new StatsEntities(50, 5, 5, 4, "Grunt", 2);
        StarFighter starFighter = new StarFighter(starFighterPosition,2,stats,13);
        Board board = new Board(row, column, starFighter);
        
        assertFalse(board.equals(null));
    }

    @Test
    public void testEquals_DifferentClass() {
        int row = 3;
        int column = 5;
        Position starFighterPosition = new Position(row / 2, column / 2);
        StatsEntities stats = new StatsEntities(50, 5, 5, 4, "Grunt", 2);
        StarFighter starFighter = new StarFighter(starFighterPosition,2,stats,13);
        Board board = new Board(row, column, starFighter);
        
        assertFalse(board.equals(""));
    }

    @Test
    public void testEquals_DifferentRows() {
        int row = 3;
        int column = 5;
        Position starFighterPosition = new Position(row / 2, column / 2);
        StatsEntities stats = new StatsEntities(50, 5, 5, 4, "Grunt", 2);
        StarFighter starFighter = new StarFighter(starFighterPosition,2,stats,13);
        Board board1 = new Board(row, column, starFighter);
        Board board2 = new Board(4, column, starFighter); 
        
        assertFalse(board1.equals(board2)); 
    }

    @Test
    public void testEquals_DifferentColumns() {
        int row = 3;
        int column = 5;
        Position starFighterPosition = new Position(row / 2, column / 2);
        StatsEntities stats = new StatsEntities(50, 5, 5, 4, "Grunt", 2);
        StarFighter starFighter = new StarFighter(starFighterPosition,2,stats,13);
        Board board1 = new Board(row, column, starFighter);
        Board board2 = new Board(row, 6, starFighter); 
        
        assertFalse(board1.equals(board2));
    }

    @Test
    public void testEquals_SameDimensions() {
        int row = 3;
        int column = 5;
        Position starFighterPosition = new Position(row / 2, column / 2);
        StatsEntities stats = new StatsEntities(50, 5, 5, 4, "Grunt", 2);
        StarFighter starFighter = new StarFighter(starFighterPosition,2,stats,13);
        Board board1 = new Board(row, column, starFighter);
        Board board2 = new Board(row, column, starFighter);
        
        assertTrue(board1.equals(board2)); 
    }
    */
}
