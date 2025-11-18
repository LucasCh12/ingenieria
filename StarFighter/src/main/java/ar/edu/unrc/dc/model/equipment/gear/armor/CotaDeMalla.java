package ar.edu.unrc.dc.model.equipment.gear.armor;

import ar.edu.unrc.dc.model.board.objects.entities.StatsEntities;

public class CotaDeMalla extends ArmorAbstract {


    public CotaDeMalla(StatsEntities stats) {
        super(stats);
    }
    
    @Override
    public void applyModifiersStats() {
        statsStartFighter.setArmour(statsStartFighter.getArmour() + 50); 
    }

}
