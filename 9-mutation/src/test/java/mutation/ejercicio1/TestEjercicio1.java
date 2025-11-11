package mutation.ejercicio1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import mutation.ejercicio1.FindVal;

public class TestEjercicio1 {
    
    /**
        Las entradas que alcanzan al mutante serian todas las listas distintas de la lista vacia,
        ej: [5,2]. Son estas entradas porque si das lista vacia  numbers = [], numbers.length va a ser
        menor que i = 1, 1 < 0 ?, false no entro al for, osea no entro al mutante.

        Ej: val = 2, [1,2,3].
     */
    @Test
    public void testReachMutant(){
        int val = 2;
        int numbers[] = {2,2,3};
        
        assertEquals(1,FindVal.findVal(numbers, val));
        assertEquals(1,FindVal.findValMutant(numbers, val));
    }

    /*+
        Una entrada que alcanza al mutante pero no produzca infeccion seria que el elem
        buscado en la lista aparezca despues de la primera posicion, se alcanzaria al mutante
        (se ejecutaria el for), pero no haria infeccion porque si encontraria al elem en la lista,
        haciendo que el resultado del metodo sea verdadero y correcto.

        Ej: val = 1, [0,1].
     */
    @Test
    public void testReachMutantNoInfection(){
        int val = 1;
        int numbers[] = {0,1};
        
        assertEquals(1,FindVal.findValMutant(numbers, val));
        assertEquals(1, FindVal.findVal(numbers, val));
    }

    /**
        Un ejemplo en este caso de una entrada que produzca infeccion y no propagacion es imposible,
        ya que no hay forma del codigo de fixear esa "infeccion" y tratarla y que siempre de el valor esperado,
        osea seria que hubiera una parte del codigo donde se salve el resultado incorrecto hecho por la 
        infeccion, en este caso seria que el elem este en la primera posicion.
            
        Ej: val = 1, numbers = [1,2]. 
     */
    @Test
    public void testInfectionNoPropagationImposible(){
        int val = 1;
        int[] numbers = {1,2};

        assertEquals(0,FindVal.findVal(numbers, val));
        assertEquals(-1,FindVal.findValMutant(numbers, val));
    }

    /**
        Un test que mate al mutante seria el caso en donde sabiendo que por ej el elem si se encuentra
        en la lista, que al ejecutar el codigo el mutante de como resultado distinto al esperado,
        osea que diga que no se encuentra, en este caso seria haciendo que el val buscado en la lista
        este en la primera posicion de la misma, en donde se esperaria true porque si esta el elem,
        pero devolveria false el resultado.

        Ej: val = 1, numbers = [1,0]. Expected = true, actual = false.
     */
    @Test 
    public void testKillMutant(){
        int val = 1;
        int[] numbers = {1,0};

        assertEquals(0,FindVal.findVal(numbers, val));
        assertEquals(-1,FindVal.findValMutant(numbers, val));
    }

    @Test
    public void testEmptyArray() {
        int[] empty = {};
        assertEquals(-1, FindVal.findVal(empty, 5));
        assertEquals(-1, FindVal.findValMutant(empty, 5)); // Mismo comportamiento
    }
    
    @Test
    public void testSingleElementFound() {
        int[] single = {5};
        assertEquals(0, FindVal.findVal(single, 5));        // Original: encuentra
        assertEquals(-1, FindVal.findValMutant(single, 5)); // Mutante: NO encuentra (i=1 >= length)
    }
    
    @Test
    public void testSingleElementNotFound() {
        int[] single = {3};
        assertEquals(-1, FindVal.findVal(single, 5));       // Original: no encuentra
        assertEquals(-1, FindVal.findValMutant(single, 5)); // Mutante: no encuentra
    }
    
    @Test
    public void testElementAtFirstPosition() {
        int[] array = {1, 2, 3, 4};
        assertEquals(0, FindVal.findVal(array, 1));         // Original: encuentra en 0
        assertEquals(-1, FindVal.findValMutant(array, 1));  // Mutante: NO encuentra (salta posición 0)
    }
    
    @Test
    public void testElementAtLastPosition() {
        int[] array = {1, 2, 3, 4};
        assertEquals(3, FindVal.findVal(array, 4));         // Original: encuentra en 3
        assertEquals(3, FindVal.findValMutant(array, 4));   // Mutante: encuentra en 3
    }
    
    @Test
    public void testElementAtMiddlePosition() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(2, FindVal.findVal(array, 3));         // Original: encuentra en 2
        assertEquals(2, FindVal.findValMutant(array, 3));   // Mutante: encuentra en 2
    }
    
    @Test
    public void testMultipleOccurrences() {
        int[] array = {1, 2, 1, 2, 1};
        assertEquals(3, FindVal.findVal(array, 2));         // Original: última en posición 3
        assertEquals(3, FindVal.findValMutant(array, 2));   // Mutante: última en posición 3
    }
    
    @Test
    public void testAllSameElements() {
        int[] array = {5, 5, 5, 5, 5};
        assertEquals(4, FindVal.findVal(array, 5));         // Original: última en posición 4
        assertEquals(4, FindVal.findValMutant(array, 5));   // Mutante: última en posición 4
    }
    
    @Test
    public void testElementNotFoundInNonEmpty() {
        int[] array = {1, 2, 3, 4};
        assertEquals(-1, FindVal.findVal(array, 10));       // Original: no encuentra
        assertEquals(-1, FindVal.findValMutant(array, 10)); // Mutante: no encuentra
    }

    @Test
    public void testTwoElementArray_FindFirst() {
        int[] array = {1, 2};
        assertEquals(0, FindVal.findVal(array, 1));         // Original: encuentra
        assertEquals(-1, FindVal.findValMutant(array, 1));  // Mutante: NO encuentra
    }

    @Test
    public void testTwoElementArray_FindSecond() {
        int[] array = {1, 2};
        assertEquals(1, FindVal.findVal(array, 2));         // Original: encuentra
        assertEquals(1, FindVal.findValMutant(array, 2)); 
    }

}
