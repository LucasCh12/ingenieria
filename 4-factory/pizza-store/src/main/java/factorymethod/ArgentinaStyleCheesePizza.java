package factorymethod;

public class ArgentinaStyleCheesePizza extends Pizza {
    public ArgentinaStyleCheesePizza() { 
		name = "Pizza Comun de queso";
		dough = "Masa esponjosa tipo bizcochuelo";
		sauce = "Salsa de tomate con cebolla y oregano";
 
		toppings.add("Aceitunas verdes");
	}
 
	void cut() {
		System.out.println("Corta la pizza en triangulos (8 porciones)");
	}
}
