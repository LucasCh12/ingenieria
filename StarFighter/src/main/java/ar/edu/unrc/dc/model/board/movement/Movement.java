package ar.edu.unrc.dc.model.board.movement;

public class Movement {
    private final int vertical;
    private final int horizontal;
    private final int maxMovement;
    
    public Movement(int vertical, int horizontal, int starfighterSpeed) {
        this.maxMovement = starfighterSpeed; 
        validateMovement(vertical, horizontal);
        this.vertical = vertical;
        this.horizontal = horizontal;
    }
    
    private void validateMovement(int vertical, int horizontal) {
        if (Math.abs(vertical) > maxMovement || Math.abs(horizontal) > maxMovement) {
            throw new IllegalArgumentException(
                "Movement cannot exceed " + maxMovement + " in any direction");
        }
    }

    public int getVertical() { return this.vertical; }

    public int getHorizontal() { return this.horizontal; }
}