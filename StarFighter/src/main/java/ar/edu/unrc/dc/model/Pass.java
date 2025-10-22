package ar.edu.unrc.dc.model;

public class Pass implements Turn {
    @Override
    public void makeTurn(StarfighterGameEngine engine){ engine.pass(); }
    
    @Override
    public String commandIssued(){
        return("Command issued: Pass");
    }
}
