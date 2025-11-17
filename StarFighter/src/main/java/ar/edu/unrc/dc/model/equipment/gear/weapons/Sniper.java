package ar.edu.unrc.dc.model.equipment.gear.weapons;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.board.objects.projectiles.Projectile;

public class Sniper extends WeaponAbstract {
    
    int projectileSpeed;

    public Sniper() {
        super();
    }
    
    @Override
    public List<Projectile> fire(Position shooterPos){
        List<Projectile> projectiles = new ArrayList<>();

        int column = shooterPos.getColumn();
        int row = shooterPos.getRow();

        Position newPosition = new Position(row, column - 1);

        Projectile projectile = new Projectile(newPosition, getWeaponType());
        projectile.setDamage(20);
        projectile.setMoveSpeed(projectileSpeed);

        projectiles.add(projectile);

        return projectiles;
    }

    @Override
    public String getWeaponType() {
        return "Sniper";
    }

    @Override
    public int getProjectileSpeed(){
        return projectileSpeed;
    }
}
