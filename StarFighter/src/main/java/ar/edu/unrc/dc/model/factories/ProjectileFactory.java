package ar.edu.unrc.dc.model.factories;

import java.util.List;

import ar.edu.unrc.dc.model.board.Board;
import ar.edu.unrc.dc.model.board.objects.projectiles.Projectile;

public class ProjectileFactory {
    private static Board board;

    public ProjectileFactory(Board board){
        this.board = board;
    }
    
    public static void createProjectile(Projectile projectile) {
        board.addObjectToBoard(projectile);
    }

    public static void createProjectiles(List<Projectile> projectiles){
        for (Projectile projectile : projectiles) {
            board.addObjectToBoard(projectile);
        }
    }
}
