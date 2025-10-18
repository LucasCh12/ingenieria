package abstractfactory.ny;

import abstractfactory.ingridients.*;
import abstractfactory.ingridients.dough.*;
import abstractfactory.ingridients.sauce.*;
import abstractfactory.ingridients.cheese.*;
import abstractfactory.ingridients.pepperoni.*;
import abstractfactory.ingridients.veggie.*;
import abstractfactory.ingridients.clams.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
 
	public Dough createDough() {
		return new ThinCrustDough();
	}
 
	public Sauce createSauce() {
		return new MarinaraSauce();
	}
 
	public Cheese createCheese() {
		return new ReggianoCheese();
	}
 
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}
 
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FreshClams();
	}
}
