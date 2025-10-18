package abstractfactory.chicago;

import abstractfactory.ingridients.*;
import abstractfactory.ingridients.dough.*;
import abstractfactory.ingridients.sauce.*;
import abstractfactory.ingridients.cheese.*;
import abstractfactory.ingridients.pepperoni.*;
import abstractfactory.ingridients.veggie.*;
import abstractfactory.ingridients.clams.*;


public class ChicagoPizzaIngredientFactory 
	implements PizzaIngredientFactory 
{

	public Dough createDough() {
		return new ThickCrustDough();
	}

	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	public Veggies[] createVeggies() {
		Veggies veggies[] = { new BlackOlives(), 
		                      new Spinach(), 
		                      new Eggplant() };
		return veggies;
	}

	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FrozenClams();
	}
}
