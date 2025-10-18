package gameLife;

public class B36S23Rules implements Rules {
    @Override
    public boolean survive(int cantNeighbors){
        return cantNeighbors == 3 || cantNeighbors == 2;
    }

    @Override
    public boolean birth(int cantNeighbors){
        return cantNeighbors == 3 || cantNeighbors == 6;
    }
}
