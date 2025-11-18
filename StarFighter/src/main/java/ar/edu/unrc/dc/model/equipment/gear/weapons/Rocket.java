package ar.edu.unrc.dc.model.equipment.gear.weapons;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.board.objects.projectiles.Projectile;

public class Rocket extends WeaponAbstract {
    
    int projectileBase = 1; 

    @Override
    public List<Projectile> fire(Position shooterPos){
        List<Projectile> projectiles = new ArrayList<>();
        int col = shooterPos.getColumn();
        int row = shooterPos.getRow();

        Position pUp = new Position(row - 1, col - 1);
        Projectile up = new Projectile(pUp, getWeaponType());
        up.setDamage(4);
        up.setRocket(true);
        up.setDirection(1, 0);        
        projectiles.add(up);

        Position pDown = new Position(row + 1, col - 1);
        Projectile down = new Projectile(pDown, getWeaponType());
        down.setDamage(4);
        down.setRocket(true);
        down.setDirection(1, 0);        
        projectiles.add(down);

        return projectiles;
    }

    @Override
    public String getWeaponType() {
        return "Rocket";
    }

    @Override
    public int getProjectileSpeed(){
        return projectileBase;
    }
}
