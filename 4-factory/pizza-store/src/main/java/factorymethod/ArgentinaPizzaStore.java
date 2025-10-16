package factorymethod;

public class ArgentinaPizzaStore extends PizzaStore {

    Pizza createPizza(String item) {
        if (item.equals("Pizza Comun de queso")) {
                        return new ArgentinaStyleCheesePizza();
                } else if (item.equals("Pizza Vegana")) {
                        return new ArgentinaStyleVeggiePizza();
                } else if (item.equals("Pizza de almejas")) {
                        return new ArgentinaStyleClamPizza();
                } else if (item.equals("Pizza con salame")) {
                        return new ArgentinaStylePepperoniPizza();
                } else return null;
    
    }
}
