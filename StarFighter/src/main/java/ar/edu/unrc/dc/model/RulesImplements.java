package ar.edu.unrc.dc.model;

public class RulesImplements implements Rules {
    private Position explosionPosition;

    public Position getExplosionPosition(){ return this.explosionPosition; }
    
    @Override
      public Boolean collision(StarfighterGameEngine e, Turn t) {
        Board board = e.getBoard();
        StarFighter star = e.getStarFighter();
        Position posStar = star.getPosition();

        if (t instanceof Move move) {
            int verticalMove = move.getVertical();
            int horizontalMove = move.getHorizontal();
            int row = posStar.getRow();
            int col = posStar.getColumn();

            Position collisionPos = checkVerticalPath(board, posStar, row, col, verticalMove);
            if (collisionPos != null) {
                explosionPosition = collisionPos; 
                return true;
            }

            collisionPos = checkHorizontalPath(board, posStar, row + verticalMove, col, horizontalMove);
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
    public Boolean gameOver(StarfighterGameEngine e, Turn t) {
        StarFighter star = e.getStarFighter();
        if (!star.getAlive()) {
            return true;
        }
        if (t instanceof Abort) {
            return true;
        }
        if (collision(e, t)) {
            star.setAlive(false);
            return true;
        }
        return false;
    }
}
