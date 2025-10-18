package ejercicio2;

import ejercicio2.*;
import testing.partition.practico.ejercicio2.Ejercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

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