package ar.edu.unrc.dc.controller;

import ar.edu.unrc.dc.model.actions.GameCommand;
import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.game.StarfighterGameEngine;
import ar.edu.unrc.dc.model.game.state.SetupState;
import ar.edu.unrc.dc.view.GameView;

public class GameController implements GameControllerInterface {
    private GameView view;
    private GameInput input;
    private GameCommand command;
    private StarfighterGameEngine engine;

    public GameController(StarfighterGameEngine engine, GameView view, GameInput input) {
        this.engine = engine;
        this.view = view;
        this.input = input;

    }
    private int readRows() {
        view.displayRowPrompt();
        return input.readInt();
    }

    private int readColumns() {
        view.displayColumnPrompt();
        return input.readInt();
    }
    
    private int readStarfighterSpeed() {
        view.displayStarfighterSpeedPrompt();
        return input.readInt();
    }
    
    private int readProjectileSpeed() {
        view.displayProjectileSpeedPrompt();
        return input.readInt();
    }

    private int readVerticalMove() {
        view.displayVerticalMovePrompt();
        return input.readInt();
    }

    private int readHorizontalMove() {
        view.displayHorizontalMovePrompt();
        return input.readInt();
    }
    
    @Override
    public void play() {
        try {
            int rows = readRows();
            int columns = readColumns();
            int starfighterSpeed = readStarfighterSpeed();
            int projectileSpeed = readProjectileSpeed();
            view.displayMessage("Entering setup stage...");
            engine.startSetup();
            view.displayConfigSetUp();
            String step;
            while(engine.getState() instanceof SetupState) {
                SetupState setupState = (SetupState) engine.getState();
                if(setupState.getCurrentStep().name()=="SUMMARY") {
                    step = engine.getLoadOut().getSummary();
                } else {
                    step = setupState.getCurrentStep().name();
                }
                view.displayMessage("Current Setup Step: " + step);
                view.displayMenuSetUp();
                view.displayMessage("Enter command number:");
                int command = input.readInt();
                switch (command) {
                    case 1 -> {
                        view.displayMessage("Enter number of steps to go back:");
                        int n = input.readInt();
                        engine.setupBack(n);
                    }
                    case 2 -> {
                        view.displayMessage("Enter option number to select:");
                        if(step.equals("ARMOUR")) {
                            view.armorOption();
                        } else if(step.equals("WEAPON")) {
                            view.weaponOptions();
                        } else if(step.equals("ENGINE")) {
                            view.engineOptions();
                        } else if(step.equals("POWER")) {
                            view.powerOptions();
                        }
                        int n = input.readInt();
                        engine.setupSelect(n);
                    }
                    case 3 -> {
                        view.displayMessage("Enter number of steps to advance:");
                        int n = input.readInt();
                        engine.setupNext(n);
                    }
                    case 4 -> {
                        engine.abort();
                        view.displayMessage("Game aborted during setup.");
                        return;
                    }
                    default -> view.displayMessage("Invalid command");
                }
            }
            engine.play(rows, columns, starfighterSpeed, projectileSpeed);
            view.displayMessage("Game successfully initialized!");
            view.displayBoard(engine.getBoard(), true);
            
        } catch (Exception e) {
            view.displayError("Error initializing game: " + e.getMessage());
        }
    }

    @Override
    public void fire() {
        try {
            engine.fire();
             view.displayBoard(engine.getBoard(), true);
        } catch (Exception e) {
            view.displayError("Error firing: " + e.getMessage());
        }
    }
    
    @Override
    public void move() {
        try {
            int vertical = readVerticalMove();
            int horizontal = readHorizontalMove();
            Position movePosition = new Position(vertical, horizontal);
            engine.move(movePosition);
            view.displayMessage("Move executed successfully!");
            view.displayBoard(engine.getBoard(), true);
        } catch (Exception e) {
            view.displayError("Error moving: " + e.getMessage());
        }
    }

    @Override
    public void pass() {
        try {
            engine.pass();
            view.displayMessage("Turn passed successfully!");
            view.displayBoard(engine.getBoard(), true);
        } catch (Exception e) {
            view.displayError("Error passing turn: " + e.getMessage());
        }
    }

    @Override
    public void abort() {
        try {
            engine.abort();
            view.displayMessage("Game aborted successfully!");
        } catch (Exception e) {
            view.displayError("Error aborting game: " + e.getMessage());
        }
    }


}