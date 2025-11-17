package ar.edu.unrc.dc.model.game.state;

import ar.edu.unrc.dc.model.game.GameConfiguration;
import ar.edu.unrc.dc.model.game.StarfighterGameEngine;
import ar.edu.unrc.dc.view.GameView;

public class InGameState implements GameState{

    @Override
    public void enterState(StarfighterGameEngine engine) {
        engine.setActive(true);
    }
    
    @Override
    public void startSetup(StarfighterGameEngine engine) {
        
    }

    @Override
    public void completeSetup(StarfighterGameEngine engine, GameConfiguration config) {
        
    }
    @Override
    public String getName() {
        return "InGame";
    }

}
