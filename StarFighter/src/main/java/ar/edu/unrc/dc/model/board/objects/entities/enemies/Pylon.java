package ar.edu.unrc.dc.model.board.objects.entities.enemies;

import ar.edu.unrc.dc.model.actions.GameCommand;
import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.board.objects.entities.StatsEntities;
import ar.edu.unrc.dc.model.equipment.gear.Gear;
import ar.edu.unrc.dc.model.game.StarfighterGameEngine;

public class Pylon extends Enemy{
    
    public Pylon(Gear gear, Position position,StatsEntities stats) {
        super(gear, position, stats); 
        this.seenByStarfighter = false;
        this.canSeeStarfighter = false;
    }

    @Override
    public void performAction(StarfighterGameEngine engine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'performAction'");
    }

    @Override
    public boolean onPlayerTurn(GameCommand playerTurn, StarfighterGameEngine engine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onPlayerTurn'");
    }

    @Override
    public void performPreemptiveAction(GameCommand playerTurn, StarfighterGameEngine engine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'performPreemptiveAction'");
    }

}