package ejercicio2;

import testing.partition.practico.ejercicio2.Ejercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/** 
 Caracteristica: C1 = Ubicación del elemento en la lista:

    Bloque 1: element está en la primera posición de la lista.
    Bloque 2: element está en la última posición de la lista.
    Bloque 3: element está en alguna posición de la lista que no es la primera ni la última.

    Resolver los siguientes problemas:

    a) C1 no cumple con la propiedad de no solapamiento (disjointness). De un ejemplo que
    ilustre esta situación.

    b) C1 no cumple con la propiedad de completitud (completeness). De un ejemplo que ilustre
    esta situación.
    
    c) Defina un nuevo modelo del espacio de entradas que capture el propósito de C1 y que
    satisfaga las propiedades de completitud y no solapamiento.

    a) C1 no cumple con la propiedad de no solapamiento ya que en el caso de dar la lista unitaria [4],
    entraria tanto en el bloque 1 como en el bloque 2. (hay solapamiento).

    b) C1 no cumple con la propiedad de completitud ya que en el caso de dar la lista vacica [] (posible valor del parametro),
    no entraria por ningun bloque haciendo que ese posible valor del parametro no se evalue. Si se considera que la lista es null
    segun la implementacion del metodo, pero faltaria el de lista vacia.

    c) Nuevo modelo para que se cumpla C1 el no solapamiento y la completitud:

    C1 = Cantidad de elementos en la lista.

    Bloque 1: Lista sin elementos. (cumple completitud)
    Bloque 2: Lista con al menos un elemento.
    Bloque 3: Lista con mas de un elemento.

    C2 = Posicion del elemento en la lista.

    Bloque 1: element está en la primera posición de la lista.
    Bloque 2: element está en la última posición de la lista.
    Bloque 3: element está en alguna posición de la lista que no es la primera ni la última.


    Osea cuando haya problemas de solapamiento, en la mayoria de los casos deberia armar otra caracteristica 
    para que encapsule ese problema?

    Cuando aparece solapamiento entre bloques dentro de una característica,
    muchas veces el problema no es que los bloques estén “mal escritos”,
    sino que la característica está mezclando dos aspectos distintos del dominio.

    Entonces, la solución no es “forzar” los bloques para que no se pisen,
    sino dividir la característica en dos (o más) que representen esos aspectos por separado.

 */

public class Testejercicio2 {

    @Test
    public void testElemFirst(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(0, Ejercicio2.search(list, 1));
    }

    @Test
    public void testElemMid(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, Ejercicio2.search(list, 2));
    }

    @Test
    public void testElemLast(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, Ejercicio2.search(list, 3));
    }

    @Test
    public void testNullList(){
        assertThrows(NullPointerException.class, () -> {
            Ejercicio2.search(null, 1);
        });
        
    }

    @Test
    public void testNullElem(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertThrows(NullPointerException.class, () -> {
            Ejercicio2.search(list, null);
        });
    }



}