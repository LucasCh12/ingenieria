// Clase concreta que implementa la interfaz DuckFlockBehavior. Ejercicio 1) b).

import java.util.ArrayList;

// Esta clase implementa la idea de tener una bandada de patos, donde cada pato puede ser de distinto tipo.
public class DuckFlock implements DuckFlockBehavior {
    
    private ArrayList<Duck> flock;

    private int quackTimes;

    private int flyTimes;

    public DuckFlock() {
        flock = new ArrayList<>();
        quackTimes = 0;
        flyTimes = 0;
    }

    public void addDuck(Duck duck){
        flock.add(duck);
    }

    public void makeAllFly(){
        for(Duck duck: flock){
            duck.performFly();
            flyTimes++;
        }
    }

    public void makeAllQuack(){
        for(Duck duck: flock){
            duck.performQuack();
            quackTimes++;
        }
    }

    public int duckCant(){
        return flock.size();
    }

    public int getQuackTimes(){
        return quackTimes;
    }

    public int getFlyTimes(){
        return flyTimes;
    }

}
