package ar.edu.unrc.dc.model.actions;

import ar.edu.unrc.dc.model.board.objects.entities.Entity;
import ar.edu.unrc.dc.model.board.objects.entities.StatsEntities;
import ar.edu.unrc.dc.model.equipment.gear.armor.ArmorAbstract;
import ar.edu.unrc.dc.model.game.LoadOut;
import ar.edu.unrc.dc.model.equipment.gear.armor.ArmorAbstract;
import ar.edu.unrc.dc.model.equipment.gear.armor.CotaDeMalla;
import ar.edu.unrc.dc.model.equipment.gear.weapons.*;
import ar.edu.unrc.dc.model.equipment.gear.weapons.WeaponAbstract;

public class SetLoadOutCommand implements GameCommand{

    private StatsEntities statsEntities;
    private LoadOut loadOut;
    private Entity entity;

    public SetLoadOutCommand(LoadOut loadOut, Entity entity){
        this.loadOut = loadOut;
        this.entity = entity;
    }

    @Override
    public void execute() {
        StatsEntities statsEntities = this.entity.getStatsEntities();
        switch (loadOut.getArmour()) {
            case 1 -> {
                // armor = new ArmorCreada1(stats);
                //armor.applyModifiersStats();
                }
            case 2 -> {
                ArmorAbstract armor = new CotaDeMalla(statsEntities);
                entity.setArmorType(armor);
                }
            case 3 -> {
                // armor = new ArmorCreada3(stats);
                //armor.applyModifiersStats();
                }
            case 4 -> {
                //ArmorAbstract armor = new ArmorCreada4(stats);
                //armor.applyModifiersStats();
                }
            default -> throw new IllegalArgumentException("Invalid armour option");
            }
        switch (loadOut.getWeapon()) {
            case 1 -> { 
                return;
            }
            case 2 -> {
                WeaponAbstract weapon = new Spread();
                entity.setWeaponType(weapon);
                //weapon.applyModifiersStats();
            }
            case 3 -> {
                WeaponAbstract weapon = new Splitter();
                entity.setWeaponType(weapon);
                //weapon.applyModifiersStats();
            }
            case 4 -> {
                WeaponAbstract weapon = new Sniper();
                entity.setWeaponType(weapon);
                //weapon.applyModifiersStats();
            }
            case 5 -> {
                WeaponAbstract weapon = new Rocket();
                entity.setWeaponType(weapon);
                //weapon.applyModifiersStats();
            }
            default -> throw new IllegalArgumentException("Invalid weapon option");
        }
        switch (loadOut.getPower()) {
            case 1 ->  {
                //PowerAbstract power = new RecallPower(stats);
                //power.applyModifiersStats();
            }
            case 2 ->  {
                //PowerAbstract power = new RepairPower(stats);
                //power.applyModifiersStats();
            }
            case 3 ->  {
                //PowerAbstract power = new OverchargePower(stats);
                //power.applyModifiersStats();
            }
            case 4 ->  {
                //PowerAbstract power = new DeployDronesPower(stats);
                //power.applyModifiersStats();
            }
            case 5 ->  {
                //PowerAbstract power = new OrbitalStrikePower(stats);
                //power.applyModifiersStats();
            }
            default -> throw new IllegalArgumentException("Invalid power option");
        }
        
        switch (loadOut.getEngine()) {
            case 1 -> {
                //EngineAbstract engine = new EngineCreada(stats);
                //engine.applyModifiersStats();
            }
            case 2 -> {
                //EngineAbstract engine = new EngineCreada2(stats);
                //engine.applyModifiersStats();
            }
            case 3 -> {
                //EngineAbstract engine = new EngineCreada3(stats);
                //engine.applyModifiersStats();
            }
            default -> throw new IllegalArgumentException("Invalid engine option");
        }
    }

    @Override
    public String getTypeTurn() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTypeTurn'");
    }

    @Override
    public String commandIssued() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'commandIssued'");
    }
    


}
