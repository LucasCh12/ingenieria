package ar.edu.unrc.dc.model.game;

import ar.edu.unrc.dc.model.game.state.SetupStep;

public class LoadOut {
    private int weapon = 1;
    private int armour = 1;
    private int engine = 1;
    private int power = 1;

    public void setOption(SetupStep step, int option) {
        if (option < 1 || option > 5)
            throw new IllegalArgumentException("Option must be between 1 and 5");
        switch (step) {
            case WEAPON -> weapon = option;
            case ARMOUR -> {
                if (option < 1 || option > 4) {
                    throw new IllegalArgumentException("Armour option must be between 1 and 4");
                }
                armour = option;
            }
            case ENGINE -> {
                if( option < 1 || option > 3) {
                    throw new IllegalArgumentException("Engine option must be between 1 and 3");
                }
                engine = option;
            }
            case POWER -> power = option;
            default -> throw new IllegalStateException("Cannot select on SUMMARY");
        }
    }

    public int getWeapon() { return weapon; }
    public int getArmour() { return armour; }
    public int getEngine() { return engine; }
    public int getPower() { return power; }
    public String getSummary() {
        return """
        --- STARFIGHTER SETUP SUMMARY ---
        Weapon Selected : %d
        Armour Selected : %d
        Engine Selected : %d
        Power Selected  : %d
        ---------------------------------
        """.formatted(weapon, armour, engine, power);
    }

}
