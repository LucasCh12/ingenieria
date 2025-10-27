package ejercicio5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import testing.partition.practico.ejercicio5.*;

public class TestEjercicio5 {
    
    /**
     *  Ejercicio 5. Derive tests para la clase
        BoundedQueue.java usando la técnica de particionado del espacio de entradas. 
        
        Considere los siguientes métodos de BoundedQueue:

        public BoundedQueue (int capacity);
        public void enqueue (Object X);
        public Object dequeue ();
        public boolean isEmpty ();
        public boolean isFull ();

        Provea tests para satisfacer el criterio Base Choice Coverage. Implemente los tests resultantes en
        JUnit.
     */

    /**
     *  Metodo public BoundedQueue(int capacity) (constructor):
            Caracteristicas:
                -C1: Capacidad de la Cola.
                
            Bloques:
                -Bloque 1: >0.
                -Bloque 2: 0.
                -Bloque 3: <0.
     */
    @Test
    public void testMetodoBoundedQueueT1(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BoundedQueue(-1);
        });
        
        assertEquals("BoundedQueue.constructor", exception.getMessage());
    }

    @Test
    public void testMetodoBoundedQueueT2(){
        BoundedQueue cola = new BoundedQueue(0);

        assertTrue(cola.isEmpty());
        assertEquals("[]", cola.toString());
    }

    @Test
    public void testMetodoBoundedQueueT3(){
        BoundedQueue cola = new BoundedQueue(1);
        cola.enQueue(1);

        assertFalse(cola.isEmpty());
        assertEquals("[1]", cola.toString());
    }

    /**
     *  Metodo public void enQueue (Object o) (encolar):
            Caracteristicas:
                -C1: Objeto a encolar:
                Bloques:
                    -Bloque 1: Null.
                    -Bloque 2: No null.
                
                -C2: Capacidad cola:
                Bloques:
                    -Bloque 1: Cola llena.
                    -Bloque 2: Cola no llena.
        
        Como hay que cubrir el BCC (Base Choice Coverage), defino como caso base el:

            Objeto a encolar: No null, Capacidad cola: Cola no llena.

        En este caso, necesitaria: 1 + ∑(numero de bloques por caracterıstica − 1), osea:
            1 + ∑ i = 1 , n = 2 (2 − 1) == 1 + 2 = 3.
        
        Que quedarian: 
             T0 (Caso base): Objeto a encolar: No null, Capacidad cola: Cola no llena.

             (empiezo cambiando los valores de Objeto a encolar)
             T1: Objeto a encolar: Null, Capacidad cola: Cola no llena.

             (ahora cambio los valores de Capacidad cola)
             T2: Objeto a encolar: No null, Capacidad cola: Cola llena.
    */

    @Test
    public void testMetodoEnqueueT0(){
        BoundedQueue cola = new BoundedQueue(3);
        int aux1 = 1;
        
        cola.enQueue(aux1);

        assertFalse(cola.isEmpty());
        assertFalse(cola.isFull());
        assertEquals("[1]",cola.toString());
    }

    @Test
    public void testMetodoEnqueueT1(){
        BoundedQueue cola = new BoundedQueue(3);
        String aux1 = "1";
        String aux2 = null;
        cola.enQueue(aux1);

        Exception exception = assertThrows(NullPointerException.class, () -> {
            cola.enQueue(aux2);;
        });
        
        assertEquals("BoundedQueue.enQueue", exception.getMessage());
        assertEquals("[1]",cola.toString());
    }

    @Test
    public void testMetodoEnqueueT2(){
        BoundedQueue cola = new BoundedQueue(3);
        int aux1 = 1;
        int aux2 = 2;
        int aux3 = 3;
        int aux4 = 4;
        cola.enQueue(aux1);
        cola.enQueue(aux2);
        cola.enQueue(aux3);

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            cola.enQueue(aux4);;
        });
        
        assertEquals("BoundedQueue.enQueue", exception.getMessage());

        assertEquals("[1, 2, 3]",cola.toString());
    }

    /**
     * Metodo public Object deQueue () (desencolar):
            Caracteristicas:
                -C1: Capacidad cola:
                Bloques:
                    -Bloque 1: Cola vacia.
                    -Bloque 2: Cola con un elemento.
                    -Bloque 3: Cola con mas de un elemento.
     */

    @Test
    public void testMetodoDeQueueT1(){
        BoundedQueue cola = new BoundedQueue(0);

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            cola.deQueue();;
        });

        assertEquals("BoundedQueue.deQueue", exception.getMessage());
    }

    @Test
    public void testMetodoDeQueueT2(){
        BoundedQueue cola = new BoundedQueue(1);
        int aux1 = 1;

        cola.enQueue(aux1);
        
        assertEquals(1, cola.deQueue());
    }

    @Test
    public void testMetodoDeQueueT3(){
        BoundedQueue cola = new BoundedQueue(2);
        int aux1 = 1;
        int aux2 = 2;

        cola.enQueue(aux1);
        cola.enQueue(aux2);
        
        assertEquals(1, cola.deQueue());
    }

    /**
     *  Metodo public boolean isEmpty() (esta vacia):
            Caracteristicas:
                -C1: Capacidad cola.
                Bloques:
                    -Bloque 1: Cola vacia.
                    -Bloque 2: Cola con un elemento.
                    -Bloque 3: Cola con mas de un elemento.
     */

    @Test
    public void testMetodoIsEmptyT1(){
        BoundedQueue cola = new BoundedQueue(0);

        assertTrue(cola.isEmpty());
    }

    @Test
    public void testMetodoIsEmptyT2(){
        BoundedQueue cola = new BoundedQueue(1);
        int aux1 = 1;

        cola.enQueue(aux1);

        assertFalse(cola.isEmpty());
    }

    @Test
    public void testMetodoIsEmptyT3(){
        BoundedQueue cola = new BoundedQueue(2);
        int aux1 = 1;
        int aux2 = 2;

        cola.enQueue(aux1);
        cola.enQueue(aux2);

        assertFalse(cola.isEmpty());
    }

    /*
     * Metodo public boolean isFull() (esta llena):
            Caracteristicas:
                -C1: Capacidad cola.
                Bloques:
                    -Bloque 1: Cola llena.
                    -Bloque 2: Cola no llena.
     */

     @Test
     public void testMetodoIsFullT1(){
        BoundedQueue cola = new BoundedQueue(2);
        int aux1 = 1;
        int aux2 = 2;

        cola.enQueue(aux1);
        cola.enQueue(aux2);

        assertTrue(cola.isFull());
     }

     @Test
     public void testMetodoIsFullT2(){
        BoundedQueue cola = new BoundedQueue(2);
        int aux1 = 1;

        cola.enQueue(aux1);

        assertFalse(cola.isFull());
     }


    
}
