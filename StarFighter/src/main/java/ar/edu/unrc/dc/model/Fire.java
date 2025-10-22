package ar.edu.unrc.dc.model;

public class Fire  implements Turn {
    @Override
    public void makeTurn(StarfighterGameEngine engine){ engine.fire(); }  
    
    @Override
    public String commandIssued(){ return("Command issued: Fire"); }
}
