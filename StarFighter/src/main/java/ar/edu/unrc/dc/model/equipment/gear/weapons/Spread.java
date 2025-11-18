package ar.edu.unrc.dc.model.equipment.gear.weapons;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.board.objects.projectiles.Projectile;

public class Spread extends WeaponAbstract {

    int projectileSpeed = 1;

    public Spread() {
        super();
    }

    public List<Projectile> fire(Position shooterPos) {
    List<Projectile> projectiles = new ArrayList<>();
    int column = shooterPos.getColumn();
    int row = shooterPos.getRow();

    for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {

        Position newPosition = new Position(
            row + rowOffset,
            column + 1
        );

        Projectile projectile = new Projectile(newPosition, getWeaponType());
        projectile.setDamage(4);

        // dx = 1 constante a la derecha, dy según el offset
        projectile.setDirection(1, rowOffset);
        // NO LLAMAR MÁS setMoveSpeed

        projectiles.add(projectile);
    }

    return projectiles;
}

    @Override
    public String getWeaponType() {
        return "Spread";
    }

    @Override
    public int getProjectileSpeed(){
        return projectileSpeed;
    }
}
