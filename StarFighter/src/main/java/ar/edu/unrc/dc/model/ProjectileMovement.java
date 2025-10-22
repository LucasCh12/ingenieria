package ar.edu.unrc.dc.model;

public class ProjectileMovement {
    private final Projectile projectile;
    private final boolean collided;
    private final boolean outOfBounds;
    
    public ProjectileMovement(Projectile projectile) {
        this.projectile = projectile;
        // Lógica para determinar collided y outOfBounds
        this.collided = false; // calcular basado en tu juego
        this.outOfBounds = false; // calcular basado en posición
    }
    
    public String getDescription() {
        Position pos = projectile.getPosition();
        // Lógica para generar descripción
        return "A projectile moves to (" + pos.getRow() + "," + pos.getColumn() + ")";
    }
}
