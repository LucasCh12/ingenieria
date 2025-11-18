package ar.edu.unrc.dc;

import java.util.Scanner;

import ar.edu.unrc.dc.controller.GameController;
import ar.edu.unrc.dc.controller.GameInput;
import ar.edu.unrc.dc.model.game.StarfighterGameEngine;
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
        
         /*Main → Controller → Command → Engine → Model → View
 */
        gc.play();
        gc.move();
        gc.fire();
        gc.move();
        gc.pass();


    }
}