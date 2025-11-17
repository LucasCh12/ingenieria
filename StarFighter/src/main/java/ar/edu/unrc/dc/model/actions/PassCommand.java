package ar.edu.unrc.dc.model.actions;

public class PassCommand implements GameCommand {
    
    @Override
    public String commandIssued(){
        return("Command issued: Pass");
    }

    @Override
    public String getTypeTurn() {
        return "PASS";
    }

    @Override
    public void execute() {}

}
