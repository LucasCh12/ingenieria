package ar.edu.unrc.dc.model;

public interface Rules {
    Boolean collision(StarfighterGameEngine e, Turn t);
    Boolean gameOver(StarfighterGameEngine e, Turn t);
    Position getExplosionPosition();
} 
