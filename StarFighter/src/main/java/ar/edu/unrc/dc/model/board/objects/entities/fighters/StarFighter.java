package ar.edu.unrc.dc.model.board.objects.entities.fighters;

import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.board.objects.entities.Entity;
import ar.edu.unrc.dc.model.board.objects.entities.StatsEntities;
import ar.edu.unrc.dc.model.equipment.gear.Gear;
import ar.edu.unrc.dc.model.game.LoadOut;

public class StarFighter extends Entity{
    public StatsEntities stats;
    private int energy;
    private Gear gear;

    public StarFighter(Position position, Gear gear, StatsEntities stats, int energy, int projectileMoveSpeed) {
        super(gear, position, stats);
        if (stats.getMoveSpeed() < 1 || stats.getMoveSpeed() > 40) 
            throw new IllegalArgumentException("Starfighter moves must be between 1 and 40");
        this.stats = stats;
        this.energy = energy;
    }
    public int getStarFighterVision() { return stats.getVision(); }

    @Override
    public String toString(){
        return "S";
    }
    
    public StatsEntities getStats () {
        return stats;
    }
}
