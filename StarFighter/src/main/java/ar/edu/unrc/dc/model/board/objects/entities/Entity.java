package ar.edu.unrc.dc.model.board.objects.entities;

import java.util.List;

import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.board.objects.AbstractBoardObject;
import ar.edu.unrc.dc.model.board.objects.projectiles.Projectile;
import ar.edu.unrc.dc.model.equipment.gear.Gear;

public class Entity extends AbstractBoardObject {
    private Gear gear;
    private StatsEntities statsEntities;

    public Entity(Gear gear, Position position,StatsEntities stats){
        super(position);
        this.gear = gear;
        this.statsEntities = stats;
    }

    public StatsEntities getStatsEntities(){ return this.statsEntities; }

    public Gear getGear(){ return this.gear; }

    public List<Projectile> shootProjectile(){
        return gear.getWeapon().fire(getPosition());
    }
}
