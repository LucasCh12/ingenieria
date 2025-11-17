package ar.edu.unrc.dc.model.equipment.gear.power;

public abstract class PowerGear {
    protected String name;
    protected int healthCost;
    protected int energyCost;
    
    public String getName() { return name; }
    public int getHealthCost() { return healthCost; }
    public int getEnergyCost() { return energyCost; }
    
}
