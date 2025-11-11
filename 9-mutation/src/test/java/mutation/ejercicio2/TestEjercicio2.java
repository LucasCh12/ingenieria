package mutation.ejercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

import mutation.ejercicio2.*;

public class TestEjercicio2 {
    
    /**
        A. Una entrada que alcance al mutante seria cualquier lista de numeros que no sea la vacia, 
        ya que se encuentra dentro del for, y entras al for cuando el tamaño de la lista es menor 
        estricto que 0, osea tamañoLista > 0.
            
        Ej: [1,2,3,4].
     */
    @Test
    public void testReachMutant(){
        int[] x = {1,2,3,4};
        assertNotEquals(0, SumVal.sumMutant(x));
    }

    /**
        B. Una entrada que alcanze al mutante pero no produzca infeccion seria por ej una lista con todos 0,
        ya que sumar y restar 0 siempre da el mismo resultado, el mutante no infecta nada.

        Ej: [0,0,0,0]
     */
    @Test
    public void testReachMutantNoInfection(){
        int[] x = {0,0,0,0};
        assertEquals(0, SumVal.sumMutant(x));
        assertEquals(0, SumVal.sum(x));
    }

    /**
        D. Una entrada que mate al mutante seria cualquier lista que no sea como en el caso B., 
        ya que la suma y la resta siempre dan valores distintos en lista de num.

        Ej: [1,2,3,4], expected : 10, mutant: -8.
     */
    @Test
    public void testKillMutant(){
        int[] x = {1,2,3,4};
        assertEquals(10, SumVal.sum(x));
        assertEquals(-10, SumVal.sumMutant(x));
        assertNotEquals(SumVal.sum(x), SumVal.sumMutant(x));
    }
}
