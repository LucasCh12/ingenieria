package ar.edu.unrc.dc.model.equipment.gear.weapons;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.board.objects.projectiles.Projectile;

public class Splitter extends WeaponAbstract {

    int projectileSpeed = 0;

    public Splitter() {
        super();
    }

    @Override
    public List<Projectile> fire(Position shooterPos) {
        List<Projectile> projectiles = new ArrayList<>();

        // dispara sin moverse del lugar
        Position newPosition = new Position(
            shooterPos.getRow(),
            shooterPos.getColumn()
        );

        Projectile projectile = new Projectile(newPosition, getWeaponType());
        projectile.setDamage(10);
        projectile.setMoveSpeed(projectileSpeed);

        projectiles.add(projectile);

        return projectiles;
    }

    @Override
    public String getWeaponType() {
        return "Splitter";
    }

    @Override
    public int getProjectileSpeed(){
        return projectileSpeed;
    }
}
