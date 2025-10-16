package gameLife;

public interface Rules {

    boolean survive(int cantNeighbors);
    boolean birth(int cantNeighbors);
    
}
