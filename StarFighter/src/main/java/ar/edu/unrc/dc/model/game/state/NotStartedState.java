package ar.edu.unrc.dc.model.game.state;

import ar.edu.unrc.dc.model.game.GameConfiguration;
import ar.edu.unrc.dc.model.game.StarfighterGameEngine;

public class NotStartedState implements GameState {

    @Override
    public void enterState(StarfighterGameEngine engine) {
        engine.setActive(false);
    }

    @Override
    public void startSetup(StarfighterGameEngine engine) {
        engine.setState(new SetupState());
    }

    @Override
    public void completeSetup(StarfighterGameEngine engine, GameConfiguration config) {
        throw new IllegalStateException("Cannot complete setup in NotStarted. Use play() first.");
    }

    @Override
    public String getName() { 
        return "NotStarted";
    }
}