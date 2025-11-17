package ar.edu.unrc.dc.model.board.objects.entities.enemies;

import ar.edu.unrc.dc.model.actions.GameCommand;
import ar.edu.unrc.dc.model.board.Board;
import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.board.objects.entities.StatsEntities;
import ar.edu.unrc.dc.model.equipment.gear.armor.ArmorAbstract;
import ar.edu.unrc.dc.model.equipment.gear.power.PowerAbstract;
import ar.edu.unrc.dc.model.equipment.gear.weapons.WeaponAbstract;
import ar.edu.unrc.dc.model.game.StarfighterGameEngine;

public class Grunt extends Enemy{
    public Grunt(WeaponAbstract weapon, ArmorAbstract armorType, PowerAbstract powerType, Position position,StatsEntities stats) {
        super(weapon, armorType, powerType, position, stats); 
        this.seenByStarfighter = false;
        this.canSeeStarfighter = false;
    }
    
    @Override
    public void performPreemptiveAction(GameCommand playerTurn, StarfighterGameEngine engine) {
        int healthIncrease = 0;
        int currentHealth = this.getStatsEntities().getCurrentHealth();
        
        if("PASS".equals(playerTurn.getTypeTurn())){
            healthIncrease= 10;
        }   

        //TODO: en la ronda especial meter otro if
        if(healthIncrease > 0){
            this.getStatsEntities().setCurrentHealth(currentHealth + healthIncrease);
            this.getStatsEntities().setTotalHealth(this.getStatsEntities().getTotalHealth() + healthIncrease);
        }
    }
    @Override
    public void performAction(StarfighterGameEngine engine) {
        if (this.isCanSeeStarfighter()) {
            performActionWhenCanSeeStarfighter(engine);
        } else {
            performActionWhenCantSeeStarfighter(engine);
        }
    }
    
    private void performActionWhenCanSeeStarfighter(StarfighterGameEngine engine) {
        moveAndFire(engine, -4);
    }

    private void performActionWhenCantSeeStarfighter(StarfighterGameEngine engine) {
        moveAndFire(engine, -2);
    }
    @Override
    public boolean onPlayerTurn(GameCommand playerTurn, StarfighterGameEngine engine) {
        return false;
    }
    

    private void moveAndFire(StarfighterGameEngine engine, int moveDistance) {
        if (!this.getAlive()) return;

        Board board = engine.getBoard();
        Position currentPos = this.getPosition();
        Position newPos = new Position(currentPos.getRow(), currentPos.getColumn() + moveDistance);

        if (board.isValidPosition(newPos)) {
            this.setPosition(newPos);
        } else {
            this.setAlive(false); 
        }
    }
}