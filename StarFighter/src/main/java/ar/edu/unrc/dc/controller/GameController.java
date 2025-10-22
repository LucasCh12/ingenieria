package ar.edu.unrc.dc.controller;

import ar.edu.unrc.dc.model.StarfighterGameEngine;
import ar.edu.unrc.dc.view.GameView;
import ar.edu.unrc.dc.model.Abort;
import ar.edu.unrc.dc.model.Fire;
import ar.edu.unrc.dc.model.GameConfiguration;
import ar.edu.unrc.dc.model.Move;
import ar.edu.unrc.dc.model.Movement;
import ar.edu.unrc.dc.model.Pass;

public class GameController implements GameControllerInterface {
    private StarfighterGameEngine engine;
    private GameView view;
    private GameInput input;

    public GameController(StarfighterGameEngine engine, GameView view, GameInput input) {
        this.engine = engine;
        this.view = view;
        this.input = input;
    }

    @Override
    public void play() {
        try {
            GameConfiguration config = input.getGameConfiguration();
            this.engine.play(config.getRows(), config.getColumns(), 
                           config.getStarFighterSpeed(), config.getProjectileSpeed());
            
            // Actualizar vista después de iniciar juego
            view.displayBoard(engine.getBoard(), engine.isGameActive());
            view.displayOptions();
            
        } catch (Exception e) {
            view.displayError("Error initializing game: " + e.getMessage());
        }
    }

    @Override
    public void fire() {
        try {
            engine.fire();
            view.displayTurn(new Fire());
            
            // Actualizar vista después de disparar
            view.displayBoard(engine.getBoard(), engine.isGameActive());
            
            if (engine.isGameActive()) {
                view.displayOptions();
            }
        } catch (Exception e) {
            view.displayError("Error firing: " + e.getMessage());
        }
    }
    
    @Override
    public void move() {
        try {
            int starfighterSpeed = engine.getStarFighter().getmoveSpeed();
            Movement movement = input.getMovementInput(starfighterSpeed);
            
            engine.move(movement.getVertical(), movement.getHorizontal());
            view.displayTurn(new Move(movement.getVertical(), movement.getHorizontal()));
            
            // Actualizar vista después de mover
            view.displayBoard(engine.getBoard(), engine.isGameActive());
            
            if (engine.isGameActive()) {
                view.displayOptions();
            }
        } catch (Exception e) {
            view.displayError("Error moving: " + e.getMessage());
        }
    }

    @Override
    public void pass() {
        try {
            engine.pass();
            view.displayTurn(new Pass());
            
            // Actualizar vista después de pasar turno
            view.displayBoard(engine.getBoard(), engine.isGameActive());
            
            if (engine.isGameActive()) {
                view.displayOptions();
            }
        } catch (Exception e) {
            view.displayError("Error passing turn: " + e.getMessage());
        }
    }

    @Override
    public void abort() {
        try {
            engine.abort();
            view.displayTurn(new Abort());
            
            // Actualizar vista después de abortar
            view.displayBoard(engine.getBoard(), engine.isGameActive());
            
            // No mostrar opciones porque el juego terminó
        } catch (Exception e) {
            view.displayError("Error aborting game: " + e.getMessage());
        }
    }
}