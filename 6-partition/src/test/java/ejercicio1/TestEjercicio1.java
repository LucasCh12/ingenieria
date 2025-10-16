package ejercicio1;

import ejercicio1.*;
import testing.partition.practico.ejercicio1.Ejercicio1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class TestEjercicio1 {

    @Test
    public void testAscTDesT(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        assertTrue(Ejercicio1.listIsAscendent(list));
        assertTrue(Ejercicio1.listIsDescendent(list));
    }

    @Test
    public void testAscTDesF(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertTrue(Ejercicio1.listIsAscendent(list));
        assertFalse(Ejercicio1.listIsDescendent(list));
    }

    @Test
    public void testAscFDesT(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        assertFalse(Ejercicio1.listIsAscendent(list));
        assertTrue(Ejercicio1.listIsDescendent(list));
    }

    @Test
    public void testAscFDesF(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(4);
        assertFalse(Ejercicio1.listIsAscendent(list));
        assertFalse(Ejercicio1.listIsDescendent(list));
    }



}