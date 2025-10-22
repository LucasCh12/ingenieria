package ar.edu.unrc.dc;

import java.util.Scanner;

import ar.edu.unrc.dc.controller.GameController;
import ar.edu.unrc.dc.controller.GameInput;
import ar.edu.unrc.dc.model.StarfighterGameEngine;
import ar.edu.unrc.dc.view.GameView;

/**
 * Main class to run the Starfighter game engine.
 */
public class Main {

    // --- Main method for testing ---
    public static void main(String[] args) {
    
        StarfighterGameEngine engine = new StarfighterGameEngine();
        GameView view = new GameView();
        Scanner scanner = new Scanner(System.in);
        GameInput input = new GameInput(scanner);
        
        GameController gc = new GameController(engine, view, input);
        
        try {
            gc.play();
            gc.fire();
            gc.move();
        } catch (Exception e) {
            System.out.println("Error in game: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}


