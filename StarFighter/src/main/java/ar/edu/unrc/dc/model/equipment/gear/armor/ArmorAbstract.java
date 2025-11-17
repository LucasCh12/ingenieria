package ar.edu.unrc.dc.model.equipment.gear.armor;

import ar.edu.unrc.dc.model.board.objects.entities.StatsEntities;

public abstract class ArmorAbstract {
    protected StatsEntities statsStartFighter; 
    public ArmorAbstract(StatsEntities stats) {
        this.statsStartFighter = stats;
    }
    public abstract void applyModifiersStats();

}   
