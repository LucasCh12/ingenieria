package factorymethod;

import org.junit.jupiter.api.Test;

public class TestFactoryMethod {

    @Test
    public void testOrderNYPizza() {
        PizzaStore nyStore = new NYPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = nyStore.orderPizza("clam");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = nyStore.orderPizza("pepperoni");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = nyStore.orderPizza("veggie");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");
    }

    @Test
    public void testOrderChicagoPizza() {
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("clam");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("pepperoni");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("veggie");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }

    @Test
    public void testOrderArgentinaPizza() {
        PizzaStore argentinaStore = new ArgentinaPizzaStore();

        Pizza pizza = argentinaStore.orderPizza("Pizza comun de queso");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");

        pizza = argentinaStore.orderPizza("Pizza de almejas");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");

        pizza = argentinaStore.orderPizza("Pizza con salame");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");

        pizza = argentinaStore.orderPizza("Pizza Vegana");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }

}
