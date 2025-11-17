package ar.edu.unrc.dc.model.board.objects.entities.fighters;

import java.util.List;

import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.board.objects.entities.Entity;
import ar.edu.unrc.dc.model.board.objects.entities.StatsEntities;
import ar.edu.unrc.dc.model.board.objects.projectiles.Projectile;
import ar.edu.unrc.dc.model.equipment.gear.armor.ArmorAbstract;
import ar.edu.unrc.dc.model.equipment.gear.armor.CotaDeMalla;
import ar.edu.unrc.dc.model.equipment.gear.engine.EngineAbstract;
import ar.edu.unrc.dc.model.equipment.gear.power.PowerAbstract;
import ar.edu.unrc.dc.model.equipment.gear.weapons.*;
import ar.edu.unrc.dc.model.game.LoadOut;

public class StarFighter extends Entity{
    public StatsEntities stats;
    private int energy;
    private int projectileMoveSpeed;
    private WeaponAbstract weapon;
    private PowerAbstract power;
    private EngineAbstract engine;
    private ArmorAbstract armor;

    public StarFighter(Position position, WeaponAbstract weaponType, ArmorAbstract armor, PowerAbstract power, StatsEntities stats, int energy, int projectileMoveSpeed) {
        super(weaponType, armor, power, position, stats);
        setWeapon(weaponType);
        if (stats.getMoveSpeed() < 1 || stats.getMoveSpeed() > 40) 
            throw new IllegalArgumentException("Starfighter moves must be between 1 and 40");
        if (projectileMoveSpeed < 1 || projectileMoveSpeed > 5) 
            throw new IllegalArgumentException("Projectile MoveSpeed must be between 1 and 5");
        this.projectileMoveSpeed = projectileMoveSpeed; 
        this.stats = stats;
        this.energy = energy;
    }
    public int getStarFighterVision() { return stats.getVision(); }

    @Override
    public String toString(){
        return "S";
    }
    public void setWeapon(WeaponAbstract weapon){
        this.weapon = weapon;
        super.setWeaponType(weapon);
    }
    public void setPower(PowerAbstract power){
        this.power = power;
    }

    public StatsEntities getStats () {
        return stats;
    }

    public void setEngine(EngineAbstract engine){
        this.engine = engine;
    }
    public void setArmor(ArmorAbstract armor){
        this.armor = armor;
        // Si da extra o etc
        this.armor.applyModifiersStats();
    }

    public void setLoadOut(LoadOut loadOut) {
        
    }
    public WeaponAbstract getWeapon() { return this.weapon; }
}
