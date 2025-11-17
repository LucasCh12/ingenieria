package ar.edu.unrc.dc.controller;

import java.util.Scanner;

import ar.edu.unrc.dc.model.board.movement.Movement;
import ar.edu.unrc.dc.model.game.GameConfiguration;

public class GameInput {
    private Scanner scanner;

    public GameInput(Scanner scanner) {
        this.scanner = scanner;
    }
    public int readInt(){
        return scanner.nextInt();
    }

    public GameConfiguration getGameConfiguration() {
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int starfighterSpeed = scanner.nextInt();
        int projectileSpeed = scanner.nextInt();
        
        return new GameConfiguration(rows, columns, starfighterSpeed, projectileSpeed);
    }

     public Movement getMovementInput(int maxMovement) {
        int vertical = scanner.nextInt();
        int horizontal = scanner.nextInt();
        
        return new Movement(vertical, horizontal, maxMovement);
    }
}