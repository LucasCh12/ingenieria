package ar.edu.unrc.dc.model.board.objects.entities;

public class StatsEntities {
    private int totalHealth;
    private int currentHealth;
    private int regen;
    private int armour;
    private final int vision;
    private final String name;
    private int moveSpeed;
    
    public StatsEntities(int totalHealth, int regen, int armour, int vision, String name, int moveSpeed) {
        if (totalHealth <= 0) throw new IllegalArgumentException("Health must be positive");
        if (regen < 0) throw new IllegalArgumentException("Regen must be >= 0");
        if (armour < 0) throw new IllegalArgumentException("Armour must be >= 0");
        if (vision <= 0) throw new IllegalArgumentException("Vision must be >= 1");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name required");
        if (moveSpeed < 1 || moveSpeed > 40) throw new IllegalArgumentException("Speed must be 1<= speed <= 40");

        this.totalHealth = totalHealth;
        this.currentHealth = totalHealth;
        this.regen = regen;
        this.armour = armour;
        this.vision = vision;
        this.name = name;
        this.moveSpeed = moveSpeed;
    }
    
    public int getTotalHealth() { return totalHealth; }
    public int getCurrentHealth() { return currentHealth; }
    public int getRegen() { return regen; }
    public int getArmour() { return armour; }
    public int getVision() { return vision; }
    public int getMoveSpeed() { return moveSpeed; }
    public String getName() { return name; }
    
    public void setCurrentHealth(int health) { this.currentHealth = health; }
    public void setTotalHealth(int healt){this.totalHealth = healt;}
    public void setArmour(int armour){this.armour = armour;}
    public void setRegen(int regen){this.regen = regen;}
    public void setMoveSpeed(int moveSpeed){
        if(moveSpeed >= this.getMoveSpeed()){
            this.moveSpeed = 1;
        }else{
            this.moveSpeed = this.moveSpeed - moveSpeed;
        }
    }



    public void applyRegeneration() {
        if (this.currentHealth < this.totalHealth) {
            this.currentHealth = Math.min(this.currentHealth + this.regen, this.totalHealth);
        }
    }
}