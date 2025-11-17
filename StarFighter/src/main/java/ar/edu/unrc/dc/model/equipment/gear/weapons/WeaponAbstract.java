package ar.edu.unrc.dc.model.equipment.gear.weapons;

import java.util.List;

import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.board.objects.projectiles.Projectile;

public abstract class WeaponAbstract {
    
    public abstract List<Projectile> fire(Position position);

    public abstract String getWeaponType();

    public abstract int getProjectileSpeed();

}