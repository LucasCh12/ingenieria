package ar.edu.unrc.dc.model;

public class Projectile extends AbstractBoardObject {

    public Projectile(Position position, int projectileSpeed) {
        super(position);
        super.setMoveSpeed(projectileSpeed);
    }
}
