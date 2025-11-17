package ar.edu.unrc.dc.model.actions;


import java.util.List;

import ar.edu.unrc.dc.model.board.Board;
import ar.edu.unrc.dc.model.board.objects.entities.Entity;
import ar.edu.unrc.dc.model.board.objects.projectiles.Projectile;
import ar.edu.unrc.dc.model.game.StarfighterGameEngine;

public class FireCommand implements GameCommand {

    private StarfighterGameEngine engine;

    public FireCommand(StarfighterGameEngine engine) {
        this.engine = engine;
    }
    
    @Override
    public void execute() {
        Entity starFighter = engine.getStarFighter();
        Board board = engine.getBoard();
        List<Projectile> projectiles = starFighter.shootProjectile();
        if (projectiles != null && !projectiles.isEmpty()) {
            for(Projectile projectile: projectiles){
                board.addObjectToBoard(projectile);
            }
        }
    }
    
    @Override
    public String commandIssued() {
        return "Command used is Fire";
    }

    @Override
    public String getTypeTurn() {
        return "Fire";
    }
}
