package gameLife;

public class Cell {

    private boolean alive;

    public Cell(boolean alive){
        this.alive = alive;
    }

    public boolean isAlive(){
        return alive;
    }

    public void setAlive(boolean alive){
        this.alive = alive;
    }

    public void changeState(){
        this.alive = !this.alive;
    }

    public String getColor(Colors colors) {
        return alive ? colors.colorForLiveCell() : colors.colorForDeathCell();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cell other = (Cell) obj;
        return this.isAlive() == other.isAlive();
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(alive);
    }

    
}
