package ar.edu.unrc.dc.model.rules;

import ar.edu.unrc.dc.model.actions.GameCommand;
import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.game.StarfighterGameEngine;

public interface Rules {
    Boolean collision(StarfighterGameEngine e, GameCommand command);
    Boolean gameOver(StarfighterGameEngine e, GameCommand command);
    Position getExplosionPosition();
} 
