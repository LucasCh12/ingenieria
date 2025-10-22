package ar.edu.unrc.dc.model;

public class GameConfiguration {
    private final int rows;
    private final int columns;
    private final int starfighterSpeed;
    private final int projectileSpeed;
    

    public GameConfiguration(int rows, int columns, int starfighterSpeed, int projectileSpeed) {
        this.rows = rows;
        this.columns = columns;
        this.starfighterSpeed = starfighterSpeed;
        this.projectileSpeed = projectileSpeed;
    }

    public int getRows() { return this.rows; }

    public int getColumns() { return this.columns; }

    public int getStarFighterSpeed() { return this.starfighterSpeed; }

    public int getProjectileSpeed() { return this.projectileSpeed; }
}
