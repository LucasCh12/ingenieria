package factorymethod;

public class ArgentinaStyleVeggiePizza extends Pizza {
      public ArgentinaStyleVeggiePizza() { 
		name = "Pizza Vegana";
		dough = "Masa esponjosa tipo bizcochuelo, hecha con harina de arroz";
		sauce = "Salsa de tomate con cebolla y oregano";
 
		toppings.add("Aceitunas verdes y pepino");
	}
 
	void cut() {
		System.out.println("Corta la pizza en triangulos (8 porciones)");
	}
}
