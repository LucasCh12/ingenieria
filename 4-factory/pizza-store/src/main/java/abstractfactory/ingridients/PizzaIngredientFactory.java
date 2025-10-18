package abstractfactory.ingridients;

import abstractfactory.ingridients.dough.*;
import abstractfactory.ingridients.sauce.*;
import abstractfactory.ingridients.cheese.*;
import abstractfactory.ingridients.pepperoni.*;
import abstractfactory.ingridients.veggie.*;
import abstractfactory.ingridients.clams.*;

public interface PizzaIngredientFactory {
 
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
 
}
