package ar.edu.unrc.dc.model;

public class StarFighter extends AbstractBoardObject {

    private int projectileMoveSpeed;

    public StarFighter(Position position, int starFighterMoveSpeed, int projectileMoveSpeed) {
        super(position);
        if (starFighterMoveSpeed < 1 || starFighterMoveSpeed > 40) 
            throw new IllegalArgumentException("Starfighter moves must be between 1 and 40");
        if (projectileMoveSpeed< 1 || projectileMoveSpeed> 5) 
            throw new IllegalArgumentException("Projectile MoveSpeed must be between 1 and 5");
        super.setMoveSpeed(starFighterMoveSpeed);
        this.projectileMoveSpeed = projectileMoveSpeed;
    }
    
    public Projectile createProjectile() {
        Position current = this.getPosition();
        Position projectilePosition = new Position(
            current.getRow(),
            current.getColumn() + 1
        );
        return new Projectile(projectilePosition, projectileMoveSpeed);
    }

    public int getProjectileMoveSpeed() { return this.projectileMoveSpeed; }

}
