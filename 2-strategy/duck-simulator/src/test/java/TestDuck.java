import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestDuck {

    @Test
    public void testMallardDuck() {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();
    }

    @Test
    public void testModelDuck() {
        Duck model = new ModelDuck();
        model.performQuack();
        model.performFly();
    }

    @Test
    public void testModelDuckChangeFlyBehavior() {
        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }

    // Ej 1) a) Defina tests que creen varios objetos distintos de las subclases de Duck.

    // Crea un test muy basico (como los dos primeros en la clase) para pato criollo que no tenia.
    @Test
    public void testPatoCriollo(){
        Duck criollo = new PatoCriollo();
        criollo.performQuack();
        criollo.performFly();
    } 

    // Este test lo que hace es hacer volar normal al pato criollo y luego hacer que vuele con cohete.
    // Se cambia su comportamiento (FlyBehavior) en tiempo de ejecucion.

    @Test
    public void testPatoCriolloFlyNormalAndLaterWithRocket(){
        Duck criollo = new PatoCriollo();
        criollo.performFly();
        criollo.setFlyBehavior(new FlyRocketPowered());
    } 

    // Ej 1) b) Desarrolle algunos tests para DucksFlock.

    // Este test verifica el constructor.
    @Test
    public void testDuckFlockConstructor(){
        DuckFlock bandada = new DuckFlock();
        assertEquals(0,bandada.duckCant());
        assertEquals(0,bandada.getFlyTimes());
        assertEquals(0,bandada.getQuackTimes());
    }

    // Este test verifica agregar patos del mismo tipo a la bandada.
    @Test
    public void testDuckFlockAddDucksSameType(){
        DuckFlock bandada = new DuckFlock();
        Duck criollo1 = new PatoCriollo();
        Duck criollo2 = new PatoCriollo();
        bandada.addDuck(criollo1);
        bandada.addDuck(criollo2);
        assertEquals(2,bandada.duckCant());
    }

    // Este test verifica agregar patos de diferente tipo a la bandada.
    @Test
    public void testDuckFlockAddDucksDiffType(){
        DuckFlock bandada = new DuckFlock();
        Duck criollo = new PatoCriollo();
        Duck psyduck = new PsyDuck();
        Duck mallard = new MallardDuck();
        bandada.addDuck(criollo);
        bandada.addDuck(psyduck);
        bandada.addDuck(mallard);
        assertEquals(3,bandada.duckCant());
    }

    // Este test verifica que todos los patos de un mismo tipo en la bandada hagan quack.
    @Test
    public void testDuckFlockDucksSameTypeQuack(){
        DuckFlock bandada = new DuckFlock();
        Duck criollo1 = new PatoCriollo();
        Duck criollo2 = new PatoCriollo();
        bandada.addDuck(criollo1);
        bandada.addDuck(criollo2);
        bandada.makeAllQuack();
        bandada.makeAllQuack();
        assertEquals(4,bandada.getQuackTimes());      
    }

    // Este test verifica que todos los patos de un mismo tipo en la bandada vuelen.
    @Test
    public void testDuckFlockDucksSameTypeFly(){
        DuckFlock bandada = new DuckFlock();
        Duck criollo1 = new PatoCriollo();
        Duck criollo2 = new PatoCriollo();
        bandada.addDuck(criollo1);
        bandada.addDuck(criollo2);
        bandada.makeAllFly();
        bandada.makeAllFly();
        assertEquals(4,bandada.getFlyTimes());    
    }

    // Este test verifica que todos los patos de distinto tipo en la bandada hagan quack.
    @Test
    public void testDuckFlockDucksDiffTypeQuack(){
        DuckFlock bandada = new DuckFlock();
        Duck criollo = new PatoCriollo();
        Duck psyduck = new PsyDuck();
        Duck mallard = new MallardDuck();
        bandada.addDuck(criollo);
        bandada.addDuck(psyduck);
        bandada.addDuck(mallard);
        bandada.makeAllQuack();
        bandada.makeAllQuack();
        assertEquals(6,bandada.getQuackTimes());  
    }

    // Este test verifica que todos los patos de distinto tipo en la bandada vuelen.
    @Test
    public void testDuckFlockDucksDiffTypeFly(){
        DuckFlock bandada = new DuckFlock();
        Duck criollo = new PatoCriollo();
        Duck psyduck = new PsyDuck();
        Duck mallard = new MallardDuck();
        bandada.addDuck(criollo);
        bandada.addDuck(psyduck);
        bandada.addDuck(mallard);
        bandada.makeAllFly();
        bandada.makeAllFly();
        assertEquals(6,bandada.getFlyTimes());   
    }

    // Ejercicio 1) c) Agregue un nuevo tipo de pato, y cree una bandada que contenga instancias de este tipo.
    // No hizo falta modificar ni la clase Duck ni la FlyBehavior ni la QuackBehavior, ni la DuckFlock.

    // Este test verifica que la bandada sigue funcionando con un nuevo tipo de Duck. Ejercicio 1)
    @Test
    public void testDuckFlockNewDuck(){
        DuckFlock bandada = new DuckFlock();
        Duck imaginary1 = new ImaginaryDuck();
        Duck imaginary2 = new ImaginaryDuck();
        Duck imaginary3 = new ImaginaryDuck();
        bandada.addDuck(imaginary1);
        bandada.addDuck(imaginary2);
        bandada.addDuck(imaginary3);
        bandada.makeAllFly();
        bandada.makeAllFly();
        bandada.makeAllQuack();
        bandada.makeAllQuack();
        assertEquals(6,bandada.getFlyTimes());    
        assertEquals(6,bandada.getQuackTimes());    
    }
    
}



