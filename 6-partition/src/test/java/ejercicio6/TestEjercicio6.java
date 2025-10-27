package ejercicio6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import testing.partition.practico.ejercicio6.*;

public class TestEjercicio6 {
    
    /**
     *  Ejercicio 6. Considere el problema de buscar un patrón en un String. Una posible
        implementación (con su correspondiente especificación) se encuentra en la clase
        partition.practico.ejercicio6.PatternIndex.java. Usando la técnica de
        particionado del espacio de entradas y el criterio Pair-Wise Coverage derive tests para la

        implementación de PatternIndex. Implemente los tests en JUnit. 

        ¿Descubrieron sus tests fallas en la implementación?
     */

     /**
      * Metodo public static int patternIndex (String subject, String pattern):
            Caracteristicas:
                C1: String para buscar (s1).
                Bloques:
                    -Bloque 1: Null
                    -Bloque 2: Vacio
                    -Bloque 3: No vacio.
                
                C2: String a encontrar (s2).
                Bloques:
                    -Bloque 1: Null
                    -Bloque 2: Vacio
                    -Bloque 3: Patron de un caracter.
                    -Bloque 4; Patron de mas de un caracter.
                
                C3: Relacion entre s1 y s2.
                Bloques:
                        Bloque 1: pattern está al inicio de subject
                        Bloque 2: pattern está al final de subject
                        Bloque 3: pattern está en medio de subject
                        Bloque 4: pattern NO está en subject
                        Bloque 5: pattern es más largo que subject

        Como necesitamos aplicar el criterio PWC (Pair-Wise Coverage), necesitamos:
            -Con acts generar el pair-Wise:

            +----+----------+---------------------------+-------------------------+
            | T  | s1       | s2                        | relacion_s1_s2          |
            +----+----------+---------------------------+-------------------------+
            | T1 | Vacío    | Null                      | Pattern inicio          |
            | T2 | No vacío | Vacío                     | Pattern inicio          |
            | T3 | Null     | Patrón de un caracter     | Pattern inicio          |
            | T4 | Vacío    | Patrón de más de 1 carácter | Pattern inicio        |
            | T5 | No vacío | Null                      | Pattern final           |
            | T6 | Null     | Vacío                     | Pattern final           |
            | T7 | Vacío    | Patrón de un caracter     | Pattern final           |
            | T8 | No vacío | Patrón de más de 1 carácter | Pattern final         |
            | T9 | Null     | Null                      | Pattern medio           |
            | T10| Vacío    | Vacío                     | Pattern medio           |
            | T11| No vacío | Patrón de un caracter     | Pattern medio           |
            | T12| Null     | Patrón de más de 1 carácter | Pattern medio         |
            | T13| Vacío    | Null                      | Pattern no está         |
            | T14| No vacío | Vacío                     | Pattern no está         |
            | T15| Null     | Patrón de un caracter     | Pattern no está         |
            | T16| Vacío    | Patrón de más de 1 carácter | Pattern más largo     |
            | T17| No vacío | Null                      | Pattern más largo       |
            | T18| Null     | Patrón de un caracter     | Pattern más largo       |
            | T19| Vacío    | Patrón de más de 1 carácter | Pattern más largo     |
            | T20| Null     | Patrón de más de 1 carácter | Pattern más largo     |
            +----+----------+---------------------------+-------------------------+
        
        De esta tabla, borraria los que son inviables o redundantes, y quedaria asi:

            +----+----------+---------------------------+-------------------------+
            | T  | s1       | s2                        | relacion_s1_s2          |
            +----+----------+---------------------------+-------------------------+
            | T8 | No vacío | Patrón de más de 1 carácter | Pattern final         |
            | T11| No vacío | Patrón de un caracter     | Pattern medio           |
            | T14| No vacío | Vacío                     | Pattern no está         |
            +----+----------+---------------------------+-------------------------+

        
      */
    
    @Test
    public void testMetodoPatternIndexT8(){
        String s1 = "ABCD";
        String s2 = "CD";

        int result = PatternIndex.patternIndex(s1,s2);

        assertEquals(2, result);
    }

    @Test
    public void testMetodoPatternIndexT11(){
        String s1 = "ABCD";
        String s2 = "BC";

        int result = PatternIndex.patternIndex(s1,s2);

        assertEquals(1, result);
    }

    @Test
    public void testMetodoPatternIndexT14(){
        String s1 = "ABCD";
        String s2 = "";

        int result = PatternIndex.patternIndex(s1,s2);

        assertEquals(-1, result);
    }

    /**
     * En este caso, si descubri con los test errores en la implementacion:
     * El caso donde el subject es vacio devolvia un error de indexOutOfBounds, por la linea 27 del metodo.
     * Entonces le agregue un chequeo de si subject era 0, que devuelva -1.
     */

}
