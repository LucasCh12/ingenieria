package ar.edu.unrc.dc.model.board.objects.projectiles;

import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.board.objects.AbstractBoardObject;

public class Projectile extends AbstractBoardObject {
    private int horizontalSpeed;
    private int verticalSpeed;
    private int damage; 
    private final int id;
    private static int nextId = 0;
    private static String weaponType;


    public Projectile(Position position, String weaponType){
        super(position);
        this.horizontalSpeed = 0;
        this.verticalSpeed = 0;
        this.damage = 0;
        this.id = nextId++;
        this.weaponType = weaponType;
    }
    
    public int getId() { return this.id; }
    public int getDamage() { return this.damage; }
    public int getHorizontalSpeed() { return this.horizontalSpeed; }
    public int getVerticalSpeed() { return this.verticalSpeed; }
    public String getWeaponType() { return  this.weaponType; }

    public void setDamage(int damage) { this.damage = damage; }
    public void setHorizontalSpeed(int horizontalSpeed) { this.horizontalSpeed = horizontalSpeed; }
    public void setVerticalSpeed(int verticalSpeed) { this.verticalSpeed = verticalSpeed; }
    public void setMoveSpeed(int moveSpeed){ this.horizontalSpeed = moveSpeed;}

    @Override
    public String toString(){
        return "*";
    }
}   


