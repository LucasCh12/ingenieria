package ar.edu.unrc.dc.model.board.objects.entities.enemies;

import ar.edu.unrc.dc.model.actions.GameCommand;
import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.board.objects.entities.Entity;
import ar.edu.unrc.dc.model.board.objects.entities.StatsEntities;
import ar.edu.unrc.dc.model.equipment.gear.armor.ArmorAbstract;
import ar.edu.unrc.dc.model.equipment.gear.power.PowerAbstract;
import ar.edu.unrc.dc.model.equipment.gear.weapons.WeaponAbstract;
import ar.edu.unrc.dc.model.game.StarfighterGameEngine;

public abstract class Enemy extends Entity { 
    protected boolean seenByStarfighter; 
    protected boolean canSeeStarfighter; 
    protected int id;

    public Enemy(WeaponAbstract weapon, ArmorAbstract armorType, PowerAbstract powerType, Position position,StatsEntities stats) {
        super(weapon, armorType, powerType, position, stats); 
        this.seenByStarfighter = false;
        this.canSeeStarfighter = false;
    }


    //antes del turno del jugador
    public abstract void performPreemptiveAction(GameCommand playerTurn, StarfighterGameEngine engine);
    // turno del enemigo
    public abstract void performAction(StarfighterGameEngine engine);
    // durante el turno del jugador
    public abstract boolean onPlayerTurn(GameCommand playerTurn, StarfighterGameEngine engine);

    public void setId(int id){
        this.id=id;
    }

    
    protected void applyRegeneration() {
       getStatsEntities().applyRegeneration();
    }
    
    public int takeDamage(int damage) {
        int mitigatedDamage = Math.max(0, damage - getStatsEntities().getArmour());
        int newHealth = getStatsEntities().getCurrentHealth() - mitigatedDamage;
        getStatsEntities().setCurrentHealth(newHealth);
        
        if (newHealth <= 0) {
            super.setAlive(false);
        }
        return mitigatedDamage;
    }


    //setters y getters

    public int getRegen() { return getStatsEntities().getRegen(); }
    public int getArmour() { return getStatsEntities().getArmour(); }
    public int getVision() { return getStatsEntities().getVision(); }
    public String getName() { return getStatsEntities().getName(); }
    public WeaponAbstract getWeapon() { return getWeaponType(); }
    public int getId() { return this.id; }
    public int getCurrentHealth() { return getStatsEntities().getCurrentHealth(); }
    public int getTotalHealth() { return getStatsEntities().getTotalHealth(); }
    
    public void setCurrentHealth(int currentHealth) { getStatsEntities().setCurrentHealth(currentHealth); }
    public boolean isSeenByStarfighter() { return this.seenByStarfighter; }
    public void setSeenByStarfighter(boolean seenByStarfighter) { 
        this.seenByStarfighter = seenByStarfighter; 
    }
    public boolean isCanSeeStarfighter() { return this.canSeeStarfighter; }
    public void setCanSeeStarfighter(boolean canSeeStarfighter) { 
        this.canSeeStarfighter = canSeeStarfighter; 
    }
    @Override
    public String toString() {
        return  "E";
    }

}