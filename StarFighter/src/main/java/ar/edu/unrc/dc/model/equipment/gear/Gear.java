package ar.edu.unrc.dc.model.equipment.gear;

import ar.edu.unrc.dc.model.equipment.gear.armor.ArmorAbstract;
import ar.edu.unrc.dc.model.equipment.gear.engine.EngineAbstract;
import ar.edu.unrc.dc.model.equipment.gear.power.PowerAbstract;
import ar.edu.unrc.dc.model.equipment.gear.weapons.WeaponAbstract;

public class Gear {
    private WeaponAbstract weapon;
    private ArmorAbstract armor;
    private EngineAbstract engine;
    private PowerAbstract power;

    public Gear(WeaponAbstract weapon, ArmorAbstract armor, EngineAbstract engine, PowerAbstract power){
        this.weapon = weapon;
        this.armor = armor;
        this.engine = engine;
        this.power = power;
    }

    public void setWeapon(WeaponAbstract weapon){ this.weapon = weapon; }
    public void setArmor(ArmorAbstract armor){ this.armor = armor; }
    public void setEngine(EngineAbstract engine){ this.engine = engine; }
    public void setPower(PowerAbstract power){ this.power = power; }

    public WeaponAbstract getWeapon(){ return this.weapon; }
    public ArmorAbstract getArmor(){ return this.armor; }
    public EngineAbstract getEngine(){ return this.engine; }
    public PowerAbstract getPower(){ return this.power; }
}
