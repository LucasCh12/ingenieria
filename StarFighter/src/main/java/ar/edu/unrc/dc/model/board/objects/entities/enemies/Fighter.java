package ar.edu.unrc.dc.model.board.objects.entities.enemies;

import ar.edu.unrc.dc.model.actions.GameCommand;
import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.board.objects.entities.StatsEntities;
import ar.edu.unrc.dc.model.equipment.gear.armor.ArmorAbstract;
import ar.edu.unrc.dc.model.equipment.gear.power.PowerAbstract;
import ar.edu.unrc.dc.model.equipment.gear.weapons.WeaponAbstract;
import ar.edu.unrc.dc.model.game.StarfighterGameEngine;
/* */
public class Fighter extends Enemy{
     private int PROJECTILE_SPEED = -10;
    private int PROJECTILE_DAMAGE = 100;
    
    public Fighter(WeaponAbstract weapon, ArmorAbstract armorType, PowerAbstract powerType, Position position,StatsEntities stats) {
        super(weapon, armorType, powerType, position, stats); 
        this.seenByStarfighter = false;
        this.canSeeStarfighter = false;
    }

    @Override
    public void performPreemptiveAction(GameCommand playerTurn, StarfighterGameEngine engine) {
        /*Board board = engine.getBoard();
        if(playerTurn.getTypeTourn() == "FIRE"){
            this.stats.setArmour(this.stats.getArmour() + 1);
        }else if(playerTurn.getTypeTourn() == "PASS"){
            Position currentPos = this.getPosition();
            Position newPos = new Position(currentPos.getRow() + -6, currentPos.getColumn());
            StarFighter startfighter = engine.getStarFighter();
            //checkear si es valida la pos o qe? 
            startfighter.setPosition(newPos);
            if(this.getAlive()){
                Position projectilePosition = new Position(currentPos.getRow(), currentPos.getColumn()-1);
                if(engine.getBoard().isValidPosition(projectilePosition)){
                    Projectile projectile = new Projectile(projectilePosition);
                    projectile.setMoveSpeed(PROJECTILE_SPEED);
                    projectile.setDamage(PROJECTILE_DAMAGE);
                    engine.getBoard().addObjectToBoard(projectile);
                }                    
                }
            }


        */
        }

    
    @Override
    public void performAction(StarfighterGameEngine engine) {
        if(this.isCanSeeStarfighter()){

        }
    }

    @Override
    public boolean onPlayerTurn(GameCommand playerTurn, StarfighterGameEngine engine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onPlayerTurn'");
    }
    

    
}