
package ar.edu.unrc.dc.view;

import java.util.List;

import ar.edu.unrc.dc.model.actions.AbortCommand;
import ar.edu.unrc.dc.model.actions.FireCommand;
import ar.edu.unrc.dc.model.actions.GameCommand;
import ar.edu.unrc.dc.model.actions.MoveCommand;
import ar.edu.unrc.dc.model.actions.PassCommand;
import ar.edu.unrc.dc.model.actions.PlayCommand;
import ar.edu.unrc.dc.model.board.Board;
import ar.edu.unrc.dc.model.board.movement.ProjectileMovement;
import ar.edu.unrc.dc.model.game.StarfighterGameEngine;
import ar.edu.unrc.dc.utils.Observer;

public class GameView implements Observer{

    public GameView(){ }

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

    public void displayCommand(GameCommand command) {
        System.out.println("\n=== TURN EXECUTED ===");
        
        if (command instanceof FireCommand) {
            System.out.println("Action: FIRE - Starfighter fired a projectile");
        } 
        else if (command instanceof MoveCommand) {
            MoveCommand move = (MoveCommand) command;
            System.out.println("Action: MOVE - Starfighter moved " + 
                move.getVertical() + " vertically, " + move.getHorizontal() + " horizontally");
        }
        else if (command instanceof PassCommand) {
            System.out.println("Action: PASS - Starfighter passed the turn");
        }
        else if (command instanceof AbortCommand) {
            System.out.println("Action: ABORT - Game aborted");
        }
        else if (command instanceof PlayCommand) {
            System.out.println("Action: PLAY - Game started");
        }else {System.out.println(" - Game started"); }
    }

    
    @Override
    public void update(StarfighterGameEngine engine) {
        GameCommand executedCommand = engine.getCurrentcCommand();
        if(executedCommand != null){
            displayCommand(executedCommand);
        }else{
            displayMessage("Game initialized.");
        }

        displayBoard(engine.getBoard(), engine.isGameActive());

        if(engine.isGameActive()){
            displayOptions();
        }
    
    }

    public void displayBoard(Board board, boolean isGameActive){
        if (!isGameActive) {
            System.out.print("Game over.");
        }
        System.out.println(board.toString());
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
    
    public void displayConfigHeader() {
        System.out.println("\n--- INITIAL CONFIGURATION ---");
    }

    public void displayConfigSetUp() {
        System.out.println("\n--- EQUIPMENT CONFIGURATION ---");
    }

    public void displayMenuSetUp() {
        System.out.println("\n Input:"+"\n [1] Previous Step "+"\n [2] Select Option" +"\n [3] Next Step"+"\n [4] abort: ");
    }

    // flush obliga escribir el print sirve para que se ejecute uno a uno y no todos juntos
    public void displayRowPrompt() {
        System.out.print("Input number of rows of the grid: ");
        System.out.flush();
    }
    public void displayColumnPrompt() {
        System.out.print("Input number of columns of the grid: ");
        System.out.flush();
    }
    public void displayStarfighterSpeedPrompt() {
        System.out.print("Input maximum movement of Starfighter: ");
        System.out.flush();
    }
    public void displayProjectileSpeedPrompt() {
        System.out.print("Input speed of projectiles: ");
        System.out.flush();
    }

    public void displayWeaponPrompt(){
        System.out.print("Input weapon: ");
        System.out.flush();
    }

    public void displayArmorPrompt(){
        System.out.print("Input armor: ");
        System.out.flush();
    }
    public void displayEnginePrompt(){
        System.out.print("Input engine: ");
        System.out.flush();
    }
    public void displayPowerPrompt(){
        System.out.print("Input power: ");
        System.out.flush();
    }
    
    public void displayMoveHeader(int maxMovement) {
        System.out.println("\n=== MOVE COMMAND ===");
        System.out.println("Where do you want to move?");
        System.out.println("Max movement allowed: " + maxMovement);
    }
    public void displayVerticalMovePrompt() {
        System.out.print("Input vertical distance (negative=up, positive=down): ");
        System.out.flush();
    }
    public void displayHorizontalMovePrompt() {
        System.out.print("Input horizontal distance (negative=left, positive=right): ");
        System.out.flush();
    }

    public void displayCommandHistory(List<GameCommand> history) {
        System.out.println("=== Command History ===");
        for (int i = 0; i < history.size(); i++) {
            GameCommand cmd = history.get(i);
            System.out.println((i + 1) + ". " + cmd.getClass().getSimpleName());
        }
    }
    
    public void displayLastCommand(GameCommand command) {
        System.out.println("Last command: " + command.getClass().getSimpleName());
    }

    public void displayGetNumber() {
        System.out.println("Ingrese cuanto");
    }

    public void armorOption(String string) {
        System.out.println("[1] Cota de Malla"+"n[2] Coraza Plasmatica"+"\n[3] Escudo de Energia"+"\n[4] Campo de Fuerza");
    }

    public void weaponOptions(String string) {
        System.out.println("[1] Standard"+"\n[2] Spread"+"\n[3] Laser"+"\n[4] Rocket Launcher"+"\n[5] Plasma Cannon");
    }

    public void powerOptions(String string) {
        System.out.println("[1] Recall"+"\n[2] Overdrive"+"\n[3] Shield Boost"+"\n[4] Energy Surge");
    }
    public void engineOptions(String string) {
        System.out.println("[1] Standard Engine"+"\n[2] Turbo Engine"+"\n[3] Hyperdrive Engine");
    }
}

