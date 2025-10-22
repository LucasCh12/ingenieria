
package ar.edu.unrc.dc.view;

import java.util.List;

import ar.edu.unrc.dc.model.*;

public class GameView {

    public GameView(){ }

    public void displayBoard(Board board, boolean isGameActive) {
        int rows = board.getRow();
        int cols = board.getColumn();

        System.out.print("  ");
        for (int col = 0; col < cols; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int row = 0; row < rows; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < cols; col++) {
                Position pos = new Position(row, col);
                BoardObject obj = board.getObjectAt(pos);

                if (obj == null) {
                    System.out.print("_ ");
                } else if (obj instanceof StarFighter) {
                    System.out.print(isGameActive ? "S " : "X ");
                } else if (obj instanceof Projectile) {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        
        if (!isGameActive) {
            System.out.print("Game over.");
        }
    }

    public void displayProjectileMovements(List<ProjectileMovement> movements) {
        for (ProjectileMovement movement : movements) {
            System.out.println(movement.getDescription());
        }
    }

    public void displayError(String errorMessage) {
        System.out.println("ERROR: " + errorMessage);
    }

     public void displayOptions() {
        System.out.println("\n=== OPTIONS ===");
        System.out.println("1: Move");
        System.out.println("2: Fire"); 
        System.out.println("3: Pass");
        System.out.println("4: Abort");
        System.out.print("Choose an option: ");
    }

    public void displayTurn(Turn turn) {
        System.out.println("\n=== TURN EXECUTED ===");
        
        if (turn instanceof Fire) {
            System.out.println("Action: FIRE - Starfighter fired a projectile");
        } 
        else if (turn instanceof Move) {
            Move move = (Move) turn;
            System.out.println("Action: MOVE - Starfighter moved " + 
                move.getVertical() + " vertically, " + move.getHorizontal() + " horizontally");
        }
        else if (turn instanceof Pass) {
            System.out.println("Action: PASS - Starfighter passed the turn");
        }
        else if (turn instanceof Abort) {
            System.out.println("Action: ABORT - Game aborted");
        }
        else {
            System.out.println("Action: " + turn.getClass().getSimpleName());
        }
    }

    // Método adicional útil para mostrar mensajes generales
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
