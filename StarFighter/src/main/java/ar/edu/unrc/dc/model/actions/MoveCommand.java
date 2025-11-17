package ar.edu.unrc.dc.model.actions;

import ar.edu.unrc.dc.model.board.Board;
import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.board.objects.entities.Entity;
import ar.edu.unrc.dc.model.game.StarfighterGameEngine;

public class MoveCommand implements GameCommand{
    private final Position position;
    private final StarfighterGameEngine engine;
    
    public MoveCommand(Position position, StarfighterGameEngine engine) {
        this.position = position;
        this.engine = engine;
    }
    
    @Override
    public void execute() {
        int verticalMove = position.getRow();
        int horizontalMove = position.getColumn();
        int moveCost = verticalMove + horizontalMove;
        Entity starFighter = engine.getStarFighter();
        Board board = engine.getBoard();

        if (moveCost > starFighter.getStatsEntities().getMoveSpeed()) {
            throw new IllegalArgumentException("Incorrect position for object in board");
        }
        
        Position actualStar = starFighter.getPosition();
        Position newPosStar = new Position(
            actualStar.getRow() + verticalMove, 
            actualStar.getColumn() + horizontalMove
        );

        if (!board.isValidPosition(newPosStar)) {
            throw new IllegalArgumentException("StarFighter out of limits");
        }
        
        starFighter.setPosition(newPosStar);

    }

    @Override
    public String commandIssued() {
        return "Command used is Move";
    }
    
    @Override
    public String getTypeTurn() {
        return "MOVE";
    }
    
    public Position getPosition() { return position; }
    public Entity getStarFighter() { return engine.getStarFighter(); }

    public int getVertical(){ return position.getRow();}
    
    public int getHorizontal(){ return position.getColumn();}
}
    

