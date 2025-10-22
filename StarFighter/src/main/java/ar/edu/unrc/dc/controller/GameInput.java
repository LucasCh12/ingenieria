package ar.edu.unrc.dc.controller;

import java.util.Scanner;

import ar.edu.unrc.dc.model.GameConfiguration;
import ar.edu.unrc.dc.model.Movement;

public class GameInput {
    private Scanner scanner;

    public GameInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public GameConfiguration getGameConfiguration() {
        System.out.println("Input number of rows of the grid:");
        int rows = scanner.nextInt();
        System.out.println("Input number of columns of the grid:");
        int columns = scanner.nextInt();
        System.out.println("Input maximum movement of Starfighter:");
        int starfighterSpeed = scanner.nextInt();
        System.out.println("Input speed of projectiles:");
        int projectileSpeed = scanner.nextInt();
        
        return new GameConfiguration(rows, columns, starfighterSpeed, projectileSpeed);
    }

     public Movement getMovementInput(int maxMovement) {
        System.out.println("\n=== MOVE COMMAND ===");
        System.out.println("Where do you want to move?");
        System.out.println("Max movement allowed: " + maxMovement);
        
        System.out.print("Input vertical distance (negative=up, positive=down): ");
        int vertical = scanner.nextInt();
        
        System.out.print("Input horizontal distance (negative=left, positive=right): ");
        int horizontal = scanner.nextInt();
        
        return new Movement(vertical, horizontal, maxMovement);
    }
}