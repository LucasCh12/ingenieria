package ejercicio3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import testing.partition.practico.ejercicio3.IntersectionSet;

/** 
    Ejercicio 3. Responda las siguientes preguntas para el método intersection() a continuación:
    Si s1 o s2 son null, lanzar una NullPointerException.
    Sino retornar un Set igual a la intersección de s1 y s2.

    public Set intersection (Set s1, Set s2)

    Característica: C1 = Validez de s1
    Bloque 1: s1 = null
    Bloque 2: s1 = {}
    Bloque 3: s1 tiene al menos un elemento

    Característica: C2 = Relación entre s1 y s2

    Bloque 1: s1 y s2 representan el mismo conjunto
    Bloque 2: s1 es un subconjunto de s2
    Bloque 3: s2 es un subconjunto de s1
    Bloque 4: s1 y s2 no tienen elementos en común

    a) ¿La partición para C1 satisface la propiedad de completitud? Si la respuesta es negativa dar un
    contraejemplo.

    b) ¿La partición para C1 satisface la propiedad de no solapamiento? Si la respuesta es negativa dar
    un contraejemplo.

    c) ¿La partición para C2 satisface la propiedad de completitud? Si la respuesta es negativa dar un
    contraejemplo.

    d) ¿La partición para C2 satisface la propiedad de no solapamiento? Si la respuesta es negativa dar
    un contraejemplo.

    e) Revise las características para eliminar cualquier problema que encuentre.

    a) En este caso, C1 no cumple la propiedad de completitud, ya que no se contempla que el parametro s1
    entre siendo un conjunto con solo 1 elemento.

    Contraejemplo: s1 = {a}. 
        
    faltaria agregar un bloque 4 a C1 que capture esto mismo.

    b) En este caso, C1 si cumple con la propiedad de no solapamiento, se dividio bien los bloques, no hay ejemplo que entre
    simultaneamente por ambos bloques.

    c) En este caso, C2 no cumple la propiedad de completitud, ya que no se validan los casos donde:
        *s2 sea null.
        *s2 sea vacio {}.
        *s2 tenga un elemento.
        *s2 tenga al menos un elemento.

        Contraejemplo : 1) s2 = null, s1 = ...
                        1) s2 = {}, s1 = ...
                        1) s2 = {2}, s1 = ...
                        1) s2 = {1,2}, s1 = ...
        
    d) En este caso, C2 no cumple con la propiedad de no solapamiento, ya que si dos conjuntos son iguales, ambos son
    subconjuntos de si mismos, ya que cualquier conjunto es subconjunto de si mismo.

    Contraejemplo: s1 = {1,2,3}, s2 = {1,2,3}.

    En este caso, con este s1 y este s2, entraria por los bloques 1 2 y 3 de C2, haciendo que haya solapamiento.

    e) Modelo de prueba corregido:

    Característica: C1 = Validez de s1
        
    Bloque 1: s1 = null.
    Bloque 2: s1 = {}.
    Bloque 3: s1 tiene  un elemento.
    Bloque 4: s1 tiene mas de un elemento.

    Característica: C2 = Validez de s2
        
    Bloque 1: s2 = null.
    Bloque 2: s2 = {}.
    Bloque 3: s2 tiene  un elemento.
    Bloque 4: s2 tiene mas de un elemento.

    Característica: C3 = Relación entre s1 y s2

    Bloque 1: s1 y s2 representan el mismo conjunto.
    Bloque 2: s1 es un subconjunto de s2 (con s1 y s2 no identicos).
    Bloque 3: s1 y s2 no tienen elementos en común.
**/

public class TestEjercicio3 {
    
    @Test
    void testIntersection_bothNull_shouldThrow() {
        assertThrows(NullPointerException.class, () -> IntersectionSet.intersection(null, null));
    }

    @Test
    void testIntersection_s1Null_shouldThrow() {
        Set<Object> s2 = new HashSet<>();
        assertThrows(NullPointerException.class, () -> IntersectionSet.intersection(null, s2));
    }

    @Test
    void testIntersection_s2Null_shouldThrow() {
        Set<Object> s1 = new HashSet<>();
        assertThrows(NullPointerException.class, () -> IntersectionSet.intersection(s1, null));
    }

    @Test
    void testIntersection_bothEmpty_shouldReturnEmpty() {
        Set<Object> s1 = new HashSet<>();
        Set<Object> s2 = new HashSet<>();
        Set<Object> result = IntersectionSet.intersection(s1, s2);
        assertEquals("[]", IntersectionSet.toStringSet(result));
    }

    @Test
    void testIntersection_s1OneElement_s2Empty_shouldReturnEmpty() {
        Set<Object> s1 = new HashSet<>();
        s1.add(1);
        Set<Object> s2 = new HashSet<>();
        Set<Object> result = IntersectionSet.intersection(s1, s2);
        assertEquals("[]", IntersectionSet.toStringSet(result));
    }

    @Test
    void testIntersection_s1OneElement_s2OneElement_same_shouldReturnElement() {
        Set<Object> s1 = new HashSet<>();
        s1.add(1);
        Set<Object> s2 = new HashSet<>();
        s2.add(1);
        Set<Object> result = IntersectionSet.intersection(s1, s2);
        assertEquals("[1]", IntersectionSet.toStringSet(result));
    }

    @Test
    void testIntersection_s1OneElement_s2OneElement_different_shouldReturnEmpty() {
        Set<Object> s1 = new HashSet<>();
        s1.add(1);
        Set<Object> s2 = new HashSet<>();
        s2.add(2);
        Set<Object> result = IntersectionSet.intersection(s1, s2);
        assertEquals("[]", IntersectionSet.toStringSet(result));
    }

    @Test
    void testIntersection_multipleElements_overlap() {
        Set<Object> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);

        Set<Object> s2 = new HashSet<>();
        s2.add(2);
        s2.add(3);
        s2.add(4);

        Set<Object> result = IntersectionSet.intersection(s1, s2);
        String res = IntersectionSet.toStringSet(result);
        assertTrue(res.equals("[2,3]") || res.equals("[3,2]"));
    }

    @Test
    void testIntersection_multipleElements_noOverlap() {
        Set<Object> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);

        Set<Object> s2 = new HashSet<>();
        s2.add(3);
        s2.add(4);

        Set<Object> result = IntersectionSet.intersection(s1, s2);
        assertEquals("[]", IntersectionSet.toStringSet(result));
    }
}

