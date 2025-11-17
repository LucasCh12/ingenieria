package ar.edu.unrc.dc.model.factories;

import java.util.List;

import ar.edu.unrc.dc.model.equipment.gear.weapons.Rocket;
import ar.edu.unrc.dc.model.equipment.gear.weapons.Sniper;
import ar.edu.unrc.dc.model.equipment.gear.weapons.Splitter;
import ar.edu.unrc.dc.model.equipment.gear.weapons.Spread;
import ar.edu.unrc.dc.model.equipment.gear.weapons.Standard;
import ar.edu.unrc.dc.model.equipment.gear.weapons.WeaponAbstract;

public class WeaponFactory {

    private List<WeaponAbstract> weaponsDisponibles = List.of(
        new Rocket(),
        new Sniper(),
        new Splitter(),
        new Spread(),
        new Standard(3)
    );

    public WeaponAbstract createRandomWeapon() {
        int r = (int)(Math.random() * weaponsDisponibles.size());
        return weaponsDisponibles.get(r);
    }
}