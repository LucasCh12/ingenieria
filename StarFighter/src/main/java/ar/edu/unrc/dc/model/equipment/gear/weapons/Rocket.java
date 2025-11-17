package ar.edu.unrc.dc.model.equipment.gear.weapons;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.board.objects.projectiles.Projectile;

public class Rocket extends WeaponAbstract {
    
    int projectileSpeed = 1;

    @Override
    public List<Projectile> fire(Position shooterPos){
        return getProjectiles(shooterPos);
    }

    private List<Projectile> getProjectiles(Position pos) {

        List<Projectile> projectiles = new ArrayList<>();
        int column = pos.getColumn();
        int row = pos.getRow();
        
        for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {

            Position newPosition = new Position(row + rowOffset, column - 1);

            Projectile projectile = new Projectile(newPosition, getWeaponType());
            projectile.setDamage(4);
            projectile.setMoveSpeed(projectileSpeed);
            projectiles.add(projectile);
        }
        return projectiles;
    }

    @Override
    public String getWeaponType() {
        return "Rocket";
    }

    @Override
    public int getProjectileSpeed(){
        return projectileSpeed;
    }
}