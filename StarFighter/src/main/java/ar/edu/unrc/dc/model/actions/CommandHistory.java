package ar.edu.unrc.dc.model.actions;


import java.util.ArrayList;
import java.util.List;

import ar.edu.unrc.dc.model.game.StarfighterGameEngine;

public class CommandHistory {
    private List<GameCommand> history = new ArrayList<>();
    private StarfighterGameEngine engine;

    public CommandHistory (StarfighterGameEngine engine){
        this.engine = engine;
    }

    public void executeCommand(GameCommand command) {
        history.add(command);
    }

    public List getHistory() {
        return history;
    }
    
    public void clear() {
        history.clear();
    }
}
