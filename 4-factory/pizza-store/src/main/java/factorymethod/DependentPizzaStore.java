package factorymethod;

public class DependentPizzaStore {
 
	public Pizza createPizza(String style, String type) {
		Pizza pizza = null;
		if (style.equals("NY")) {
			if (type.equals("cheese")) {
				pizza = new NYStyleCheesePizza();
			} else if (type.equals("veggie")) {
				pizza = new NYStyleVeggiePizza();
			} else if (type.equals("clam")) {
				pizza = new NYStyleClamPizza();
			} else if (type.equals("pepperoni")) {
				pizza = new NYStylePepperoniPizza();
			}
		} else if (style.equals("Chicago")) {
			if (type.equals("cheese")) {
				pizza = new ChicagoStyleCheesePizza();
			} else if (type.equals("veggie")) {
				pizza = new ChicagoStyleVeggiePizza();
			} else if (type.equals("clam")) {
				pizza = new ChicagoStyleClamPizza();
			} else if (type.equals("pepperoni")) {
				pizza = new ChicagoStylePepperoniPizza();
			}
		} else if(style.equals("Argentina")){
			if (type.equals("Pizza comun de queso")) {
				pizza = new ArgentinaStyleCheesePizza();
			} else if (type.equals("Pizza Vegana")) {
				pizza = new ArgentinaStyleVeggiePizza();
			} else if (type.equals("Pizza de almejas")) {
				pizza = new ArgentinaStyleClamPizza();
			} else if (type.equals("Pizza con salame")) {
				pizza = new ArgentinaStylePepperoniPizza();
			}
		}
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
