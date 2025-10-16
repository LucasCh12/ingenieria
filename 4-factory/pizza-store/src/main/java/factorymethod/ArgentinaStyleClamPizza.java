package factorymethod;

public class ArgentinaStyleClamPizza extends Pizza {
    public ArgentinaStyleClamPizza() { 
		name = "Pizza de almejas";
		dough = "Masa esponjosa tipo bizcochuelo";
		sauce = "Salsa de tomate con cebolla y oregano";
 
		toppings.add("Aceitunas verdes y almejas");
	}
 
	void cut() {
		System.out.println("Corta la pizza en triangulos (8 porciones)");
	}
}
