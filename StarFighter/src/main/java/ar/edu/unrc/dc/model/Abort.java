package ar.edu.unrc.dc.model;

public class Abort  implements Turn{

    @Override
    public void makeTurn(StarfighterGameEngine engine){ engine.abort(); }  
    
    @Override
    public String commandIssued(){ return("Command issued: Abort"); }
    
}
