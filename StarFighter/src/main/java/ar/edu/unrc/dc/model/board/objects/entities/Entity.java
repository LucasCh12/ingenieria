package ar.edu.unrc.dc.model.board.objects.entities;

import java.util.List;

import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.board.objects.AbstractBoardObject;
import ar.edu.unrc.dc.model.board.objects.projectiles.Projectile;
import ar.edu.unrc.dc.model.equipment.gear.weapons.WeaponAbstract;
import ar.edu.unrc.dc.model.equipment.gear.armor.ArmorAbstract;
import ar.edu.unrc.dc.model.equipment.gear.power.PowerAbstract;

public class Entity extends AbstractBoardObject {
    private WeaponAbstract weaponType;
    private ArmorAbstract armorType;
    public PowerAbstract powerType;
    private StatsEntities statsEntities;

    public Entity(WeaponAbstract weapon, ArmorAbstract armorType, PowerAbstract powerType, Position position,StatsEntities stats){
        super(position);
        this.weaponType = weapon;
        this.armorType = armorType;
        this.statsEntities = stats;
        this.powerType = powerType;
    }

    public WeaponAbstract getWeaponType(){ return  weaponType; }

    public ArmorAbstract getArmorType(){ return  armorType; }

    public PowerAbstract getPowerType(){ return  powerType; }

    public StatsEntities getStatsEntities(){ return this.statsEntities; }

    public List<Projectile> shootProjectile(){
        return this.weaponType.fire(getPosition());
    }

    public void setWeaponType(WeaponAbstract weaponType) {
        this.weaponType = weaponType;
    }

        public void setArmorType(ArmorAbstract armorType) {
        this.armorType = armorType;
    }

        public void setPowerType(PowerAbstract powerType) {
        this.powerType = powerType;
    }
}
