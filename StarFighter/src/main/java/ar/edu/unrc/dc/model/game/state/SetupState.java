package ar.edu.unrc.dc.model.game.state;

import ar.edu.unrc.dc.model.game.GameConfiguration;
import ar.edu.unrc.dc.model.game.StarfighterGameEngine;

public class SetupState implements GameState {

    private SetupStep currentStep = SetupStep.WEAPON;

    @Override
    public void enterState(StarfighterGameEngine engine) {
        engine.setActive(false); // not yet
    }

    @Override
    public void startSetup(StarfighterGameEngine engine) { 
        throw new IllegalStateException("Setup already started");
    }



    @Override
    public void completeSetup(StarfighterGameEngine engine, GameConfiguration config) {
        throw new IllegalStateException("Use setupNext to finish setup");
    }

    public void setupNext(StarfighterGameEngine engine, int n) {
        int nextIndex = currentStep.ordinal() + n;
        if (nextIndex > SetupStep.SUMMARY.ordinal()) {
            engine.setState(new InGameState());
        } else {
            currentStep = SetupStep.values()[nextIndex];
        }
    }

    public void setupBack(StarfighterGameEngine engine, int n) {
        int nextIndex = currentStep.ordinal() - n;
        if (nextIndex < 0) {
            engine.setState(new NotStartedState());
        } else {
            currentStep = SetupStep.values()[nextIndex];
        }
    }

    public void setupSelect(StarfighterGameEngine engine, int option) {
        if (currentStep == SetupStep.SUMMARY)
            throw new IllegalStateException("No selection possible in SUMMARY step.");
        engine.getLoadOut().setOption(currentStep, option);
    }

    public SetupStep getCurrentStep() {
        return currentStep;
    }

    @Override
    public String getName() {
        return "Setup" + currentStep.name();
    }

}
