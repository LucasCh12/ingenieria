// Ejercicio 1) d) Defina la clase DuckSimulator, que tenga un método simulate que primero pone a volar a todos.
// y luego hacer cuac a todos.  

public class DuckSimulator {
	
	private DuckFlock flock;

	public DuckSimulator(){
		flock = new DuckFlock();
	}

	public void addDuckSimulator(Duck duck){
		flock.addDuck(duck);
	}

	public void simulate(){
		flock.makeAllFly();
		flock.makeAllQuack();
	}



	public static void main(String[] args) {
		DuckSimulator simulador = new DuckSimulator();
		PsyDuck psy = new PsyDuck();
		PatoCriollo crio = new PatoCriollo();
		MallardDuck mall = new MallardDuck();
		ModelDuck mod = new ModelDuck();
		simulador.addDuckSimulator(psy);
		simulador.addDuckSimulator(crio);
		simulador.addDuckSimulator(mall);
		simulador.addDuckSimulator(mod);
		simulador.simulate();
	}

}
