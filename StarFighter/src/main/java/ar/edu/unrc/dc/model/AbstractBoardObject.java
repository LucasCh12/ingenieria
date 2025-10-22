package ar.edu.unrc.dc.model;

public abstract class AbstractBoardObject implements BoardObject {
    protected Position position;
    protected int moveSpeed;
    protected boolean alive;

    public AbstractBoardObject(Position position) {
        this.position = position;
        this.alive = true; 
        this.moveSpeed = 0; 
    }

    @Override
    public Position getPosition() { return this.position; }

    public void setPosition(Position position) { this.position = position; }

    public int getmoveSpeed() { return moveSpeed; }

    public void setMoveSpeed(int moveSpeed) { this.moveSpeed = moveSpeed; }

    public boolean getAlive() { return this.alive; }

    public void setAlive(boolean alive) { this.alive = alive; }

    public boolean isAt(Position position) { return this.position.equals(position); }

}
