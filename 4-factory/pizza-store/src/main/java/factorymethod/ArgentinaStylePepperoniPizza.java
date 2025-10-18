package factorymethod;

public class ArgentinaStylePepperoniPizza extends Pizza {
    public ArgentinaStylePepperoniPizza() { 
		name = "Pizza con salame";
		dough = "Masa esponjosa tipo bizcochuelo";
		sauce = "Salsa de tomate con cebolla y oregano";
 
		toppings.add("Aceitunas verdes y salame picado grueso");
	}
 
	void cut() {
		System.out.println("Corta la pizza en triangulos (8 porciones)");
	}
}
