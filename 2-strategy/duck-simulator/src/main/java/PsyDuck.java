// Subclase nueva para Duck. Ejercicio 1) a)

public class PsyDuck extends Duck {
    public PsyDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyNoWay();
	}

	public void display() {
		System.out.println("Psyduck Psyduck");
	}    
}
