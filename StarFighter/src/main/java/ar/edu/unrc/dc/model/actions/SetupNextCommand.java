package ar.edu.unrc.dc.model.actions;

import ar.edu.unrc.dc.model.game.StarfighterGameEngine;
import ar.edu.unrc.dc.model.game.state.SetupState;

public class SetupNextCommand implements GameCommand {
    private final int n;
    
    public SetupNextCommand(int n) { this.n = n; }
    
    @Override
    public void execute() {
        StarfighterGameEngine context = null;
        if (!(context.getState() instanceof SetupState state)) {
            throw new IllegalStateException("Not in setup stage");
        }
        state.setupNext(context, n);
    }

    @Override
    public String getTypeTurn() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTypeTurn'");
    }

    @Override
    public String commandIssued() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'commandIssued'");
    }
}