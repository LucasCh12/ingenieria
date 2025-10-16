// Esta clase agrega un nuevo tipo de Duck. Ejercicio 1) c) 

public class ImaginaryDuck extends Duck {

    public ImaginaryDuck(){
        quackBehavior = new Quack();
		flyBehavior = new FlyNoWay();
    }

    public void display(){
        System.out.println("I'm a Imaginary Duck, i only live in your mind");
    }

}
