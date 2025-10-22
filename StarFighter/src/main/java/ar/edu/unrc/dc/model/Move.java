package ar.edu.unrc.dc.model;

public class Move implements Turn{
    private int vertical;
    private int horizontal;

    public Move(int vertical, int horizontal) {
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    public int getVertical(){ return this.vertical;}
    
    public int getHorizontal(){ return this.horizontal;}
    
    @Override
    public void makeTurn(StarfighterGameEngine engine) { engine.move(vertical, horizontal); }

    @Override
    public String commandIssued(){ return("Command issued: Move"); }
}
    

