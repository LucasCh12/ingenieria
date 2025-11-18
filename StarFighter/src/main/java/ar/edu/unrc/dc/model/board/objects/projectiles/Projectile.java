package ar.edu.unrc.dc.model.board.objects.projectiles;

import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.board.objects.AbstractBoardObject;

public class Projectile extends AbstractBoardObject {
    private int damage;

    private int baseDx = 0;
    private int baseDy = 0;

    private int multiplier = 1;

    private boolean sniper = false;
    private boolean splitter = false;
    private boolean rocket = false;

    private boolean rocketFirstStep = true;

    private final int id;
    private static int nextId = 0;
    private String weaponType;

    public Projectile(Position position, String weaponType){
        super(position);
        this.damage = 0;
        this.id = nextId++;
        this.weaponType = weaponType;
        this.multiplier = 1;
        this.rocketFirstStep = true;
    }

    public int getId() { return this.id; }
    public int getDamage() { return this.damage; }

    public int getHorizontalSpeed() {
        if (sniper) return baseDx; // sniper teleporta la distancia base
        return baseDx * multiplier;
    }

    public int getVerticalSpeed() {
        // Para rockets: vertical solo en el primer movimiento.
        if (rocket) {
            return rocketFirstStep ? baseDy : 0;
        }
        // Para proyectiles normales: vertical se escala con multiplier (ej: diagonales para spread)
        return baseDy * multiplier;
    }

    public String getWeaponType() { return this.weaponType; }

    public void setDamage(int damage) { this.damage = damage; }

    public void setDirection(int dx, int dy) {
        this.baseDx = dx;
        this.baseDy = dy;
        this.multiplier = 1;
        // resetear estado de FIRST STEP (importante al spawnear)
        this.rocketFirstStep = true;
    }

    public void setMoveSpeed(int speed) {
        this.baseDx = speed;
        this.multiplier = 1;
    }

    public void setSniper(boolean sniper) { this.sniper = sniper; }
    public boolean isSniper() { return sniper; }

    public void setSplitter(boolean splitter) { this.splitter = splitter; }
    public boolean isSplitter() { return splitter; }

    public void setRocket(boolean rocket) { 
        this.rocket = rocket;
        // si marcamos rocket, asegurarnos de que el primer paso vertical ocurra
        if (rocket) this.rocketFirstStep = true;
    }
    public boolean isRocket() { return rocket; }

    // Marca que ya hizo el primer paso vertical (para rockets)
    public void markRocketFirstStepDone() {
        if (rocket) rocketFirstStep = false;
    }

    // Dobla el multiplicador para el siguiente turno (1 -> 2 -> 4 ...)
    public void doubleRocketMultiplier() {
        if (!rocket) return;
        // si multiplier es 1 -> lo dejamos como 2 para el NEXT move
        if (multiplier <= 1) multiplier = 2;
        else multiplier *= 2;
    }

    @Override
    public String toString(){
        return "*";
    }
}
