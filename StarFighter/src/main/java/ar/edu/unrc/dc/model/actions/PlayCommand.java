package ar.edu.unrc.dc.model.actions;

import ar.edu.unrc.dc.model.game.StarfighterGameEngine;

public class PlayCommand implements GameCommand {
    private StarfighterGameEngine engine;
    
    
    public PlayCommand(StarfighterGameEngine engine){
        this.engine = engine;
    }
    
    @Override
    public void execute() {
    }
    
    @Override
    public String commandIssued() {
        return "Command used is Play";
    }

    @Override
    public String getTypeTurn() {
        return "PLAY";
    }

}
