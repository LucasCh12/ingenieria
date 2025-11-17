package ar.edu.unrc.dc.model.equipment.gear.armor;

import ar.edu.unrc.dc.model.board.objects.entities.StatsEntities;

public class Warmog extends ArmorAbstract {


    public Warmog(StatsEntities stats) {
        super(stats);
    }
    
    @Override
    public void applyModifiersStats() {
        statsStartFighter.setTotalHealth(statsStartFighter.getTotalHealth() + 20);
        statsStartFighter.setCurrentHealth(statsStartFighter.getCurrentHealth() + 20);
        statsStartFighter.setRegen(statsStartFighter.getRegen() + 2);
    }

}
