package ar.edu.unrc.dc.model.actions;


public class AbortCommand implements GameCommand{

    @Override
    public void execute(){ }  
    
    @Override
    public String commandIssued(){ return("Command issued: Abort"); }

    @Override
    public String getTypeTurn() {
        return "ABORT";
    }
    
}
