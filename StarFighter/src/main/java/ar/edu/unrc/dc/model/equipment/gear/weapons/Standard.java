package ar.edu.unrc.dc.model.equipment.gear.weapons;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.board.objects.projectiles.Projectile;

public class Standard extends WeaponAbstract {

    private final int projectileSpeed;

    public Standard(int projectileSpeed) {
        super();
        this.projectileSpeed = projectileSpeed; 
    }

    @Override
    public List<Projectile> fire(Position shooterPos) {
        List<Projectile> projectiles = new ArrayList<>();

        int row = shooterPos.getRow();
        int col = shooterPos.getColumn();

        Position spawn = new Position(row, col + 1);

        Projectile p = new Projectile(spawn, getWeaponType());
        p.setDamage(2);

        int speed = (this.projectileSpeed <= 0) ? 5 : this.projectileSpeed;
        p.setDirection(speed, 0);

        projectiles.add(p);
        return projectiles;
    }

    @Override
    public String getWeaponType() {
        return "Standard";
    }

    @Override
    public int getProjectileSpeed() {
        return projectileSpeed;
    }
}
