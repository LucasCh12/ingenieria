package ar.edu.unrc.dc.model.game.state;

import ar.edu.unrc.dc.model.game.StarfighterGameEngine;
import ar.edu.unrc.dc.model.game.GameConfiguration;

public interface GameState {
    void enterState(StarfighterGameEngine engine);

    void startSetup(StarfighterGameEngine engine);

    void completeSetup(StarfighterGameEngine engine, GameConfiguration config);

    String getName();
}

