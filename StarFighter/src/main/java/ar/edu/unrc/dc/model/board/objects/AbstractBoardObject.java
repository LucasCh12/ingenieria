package ar.edu.unrc.dc.model.board.objects;

import ar.edu.unrc.dc.model.board.Position;

public abstract class AbstractBoardObject implements BoardObject {
    protected Position position;
    protected boolean alive;

    public AbstractBoardObject(Position position) {
        this.position = position;
        this.alive = true; 
    }

    @Override
    public Position getPosition() { return this.position; }

    public void setPosition(Position position) { this.position = position; }

    public boolean getAlive() { return this.alive; }

    public void setAlive(boolean alive) { this.alive = alive; }

    public boolean isAt(Position position) { return this.position.equals(position); }

}
