package ar.edu.unrc.dc.model.rules;

import ar.edu.unrc.dc.model.actions.AbortCommand;
import ar.edu.unrc.dc.model.actions.GameCommand;
import ar.edu.unrc.dc.model.actions.MoveCommand;
import ar.edu.unrc.dc.model.board.Board;
import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.board.objects.BoardObject;
import ar.edu.unrc.dc.model.board.objects.entities.Entity;
import ar.edu.unrc.dc.model.board.objects.entities.fighters.StarFighter;
import ar.edu.unrc.dc.model.game.StarfighterGameEngine;

public class RulesImplements implements Rules {
    private Position explosionPosition;

    @Override
    public Position getExplosionPosition(){ return this.explosionPosition; }
    
    @Override
    public Boolean collision(StarfighterGameEngine e, GameCommand command) {
        Board board = e.getBoard();
        Entity star = e.getStarFighter();
        Position posStar = star.getPosition();

        if (command instanceof MoveCommand move) {
            Position target = new Position(move.getVertical(), move.getHorizontal());

            int verticalMove = target.getRow() - posStar.getRow();
            int horizontalMove = target.getColumn() - posStar.getColumn();

            Position collisionPos = checkVerticalPath(board, posStar, posStar.getRow(), posStar.getColumn(), verticalMove);
            if (collisionPos != null) {
                explosionPosition = collisionPos;
                return true;
            }

            collisionPos = checkHorizontalPath(board, posStar, posStar.getRow() + verticalMove, posStar.getColumn(), horizontalMove);
            if (collisionPos != null) {
                explosionPosition = collisionPos;
                return true;
            }

        } else {
            BoardObject obj = board.getObjectAt(star.getPosition());
            if (obj != null && !(obj instanceof StarFighter)) {
                explosionPosition = star.getPosition();
                return true;
            }
        }
        explosionPosition = null;
        return false;
    }

    private Position checkVerticalPath(Board board, Position start, int row, int col, int verticalMove) {
        int movesVertical = Integer.compare(verticalMove, 0);
        while (row != start.getRow() + verticalMove) {
            row = row + movesVertical;
            Position newPos = new Position(row, col);
            if (board.isOccupied(newPos)) {
                return newPos;
            }
        }
        return null;
    }

    private Position checkHorizontalPath(Board board, Position start, int row, int col, int horizontalMove) {
        int movesHorizontal = Integer.compare(horizontalMove, 0);
        while (col != start.getColumn() + horizontalMove) {
            col = col + movesHorizontal;
            Position newPos = new Position(row, col);
            if (board.isOccupied(newPos)) {
                return newPos;
            }
        }
        return null;
    }
    @Override
    public Boolean gameOver(StarfighterGameEngine e, GameCommand command) {
        Entity star = e.getStarFighter();
        if (!star.getAlive()) {
            return true;
        }
        if (command instanceof AbortCommand) {
            return true;
        }
        if (collision(e, command)) {
            star.setAlive(false);
            return true;
        }
        return false;
    }
}
