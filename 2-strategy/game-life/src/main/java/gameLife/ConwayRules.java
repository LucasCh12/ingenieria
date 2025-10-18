package gameLife;

public class ConwayRules implements Rules {
    
    @Override
    public boolean survive(int cantNeighbors){
        return cantNeighbors == 3 || cantNeighbors == 2;
    }

    @Override
    public boolean birth(int cantNeighbors){
        return cantNeighbors == 3;
    }

}
