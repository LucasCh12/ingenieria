package ejercicio4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import testing.partition.practico.ejercicio4.*;

public class TestEjercicio4 {
    
    /**
        Ejercicio 4. Asuma un método bajo test m con tres parámetros p1, p2 y p3. Asuma que las
        características en la tabla a continuación particionan el espacio de entradas de m de la siguiente
        manera: Value 1 particiona el dominio de v1, Value 2 particiona el dominio de v2, y Operation
        particiona el dominio de p3.

       +---------------------------------------------------------------------+
        | Característica | Descripción               | Bloques                |
        +----------------+---------------------------+------------------------+
        | C1: Valor1     | Valor del primer número   | < 0 | = 0 | > 0 | null |
        | C2: Valor2     | Valor del segundo número  | < 0 | = 0 | > 0 | null |
        | C3: Operación  | Operación a realizar      | +   | -   | ×   | ÷    |
        +---------------------------------------------------------------------+

        a) Provea tests para satisfacer el criterio Each Choice Coverage.
        b) Provea tests para satisfacer el criterio Base Choice Coverage. Asuma como base
        Value 1 > 0, Value 2 > 0 y Operation = +.
        c) ¿Cuántos tests se necesitan para satisfacer All Combinations Coverage? (No hace
        falta listar los tests).
        d) Escriba tests para satisfacer el criterio Pair-Wise Coverage.

        a) Para satisfacer el criterio Each Choice Coverage se necesita: 
            +Cada bloque de cada característica debe estar representado al menos una vez en un test.
            +No importa la combinación o el orden entre características.
            +La cantidad minima de test viene dada por:
                -Nro mınimo de tests = max(numero de bloques por caracterıstica).
            +Si las características tienen distinto número de bloques (tabla desbalanceada),
            el minimo se determina igualmente por la característica con mas bloques.
            +Combinacion libre: se pueden mezclar los bloques como sea entre tests, lo importante
            es que todos los bloques esten presentes.

        Test para satisfacer dicho criterio:

        Formula cant minima test: 4.

        T1: Valor1: <0, Valor2: <0, Operacion: +.
        T2: Valor1: =0, Valor2: =0, Operacion: -.
        T3: Valor1: >0, Valor2: >0, Operacion: x.
        T4: Valor1: <0, Valor2: <0, Operacion: ÷.

        En el caso de T4, al tener bloques en null las caracteristicas, no importa que se repita
        Valor1: <0, Valor2: <0 como en T1, con tal de que aparezca si o si la operacion ÷ para cubrir
        el ecc es suficiente y con cualquier valor para v1 y v2 bastaba.
        (ecc no importa orden y repeticion de bloques en test, solo que aparezcan al menos una vez).

        b) Para satisfacer el criterio Base Choice Coverage se necesita:
            +Este caso se construye eligiendo un bloque base para cada característica, es decir
            os valores que representen la situación más “normal” o “común” (o la dada por el ej).
            +Despues se generan test adicionales, donde para cada caracteristica, se cambia solo uno 
            de los bloques, mientras los otros se quedan en el base, hasta cubrir todos los bloques restantes.

            | Test | Value1 | Value2 | Operation | Descripción           |
            | ---- | ------ | ------ | --------- | --------------------- |
            | Base | a1     | a2     | as        | Caso base             |
            | T2   | **b1** | a2     | as        | Cambia solo Value1    |
            | T3   | a1     | **b2** | as        | Cambia solo Value2    |
            | T4   | a1     | a2     | **bs**    | Cambia solo Operation |

            +En este caso se cambiarian los bloques como en diagonal hasta cubrir con todos los bloques restantes.

            +Cantidad de tests:
                -N° tests = 1 + ∑(numero de bloques por caracterıstica − 1)
                (1 por el caso base + uno por cada variación individual de cada bloque restante)

            En este caso, necesitaria: 1 + ∑(numero de bloques por caracterıstica − 1), osea:
            1 + ∑ i = 1 , n = 3 (4 − 1) == 1 + 9 = 10.
            Necesitaria 10 test, dados asi:

            T0 (Caso base):  Value1: > 0, Value2: > 0 y Operation: +
            
            (empiezo cambiando los valores de Value1)
            T1: Value1: =0, Value2: >0, Operation: +.
            T2: Value1: <0, Value2: >0, Operation: +.
            (ahora cambiando los valores de Value2)
            T3: Value1: >0, Value2: =0, Operation: +.
            T4: Value1: >0, Value2: <0, Operation: +.
            (ahora cambiando los valores de Operation)
            T5: Value1: >0, Value2: >0, Operation: -.
            T6: Value1: >0, Value2: >0, Operation: x.
            T7: Value1: >0, Value2: >0, Operation: ÷.

            En este caso, como esta desbalanceada la tabla, al tener valores null como cualquiera de las
            anteriores, se generan 8 test contando al caso base, porque no tendria sentido cambiar null por null
            para cubrir el BCC.

        c) Para cubrir el criterio All Combinations Coverage harian falta:

        Formula de test minimos para ACC: Multiplicatoria i = 0, n bi, donde bi es la cantidad de bloques 
        de cada caracteristica, donde n es el numero de caracteristicas.
        
        En este caso, como toda las caracteristicas tienen la misma cantidad de bloques, la cuenta seria:

        Cantidad test ACC: 4*4*4 = 64 test para cubrir el criterio ACC.
        
        d) Usando acts obtuve:
            +----+-----------+-----------+-------------+
            | T  | Valor1    | Valor2    | Operation   |
            +----+-----------+-----------+-------------+
            | T1 | negative  | negative  | resta       |
            | T2 | negative  | cero      | multiplicat |
            | T3 | negative  | positive  | division    |
            | T4 | negative  | nulo      | suma        |
            | T5 | cero      | negative  | multiplicat |
            | T6 | cero      | cero      | division    |
            | T7 | cero      | positive  | suma        |
            | T8 | cero      | nulo      | resta       |
            | T9 | positive  | negative  | division    |
            | T10| positive  | cero      | suma        |
            | T11| positive  | positive  | resta       |
            | T12| positive  | nulo      | multiplicat |
            | T13| nulo      | negative  | suma        |
            | T14| nulo      | cero      | resta       |
            | T15| nulo      | positive  | multiplicat |
            | T16| nulo      | nulo      | division    |
            +----+-----------+-----------+-------------+
     */

    @Test
    public void testT1EjercicioD(){
        int n1 = (-1);
        int n2 = (-3);
        char operation = '-';

        int result = Calculator.calculator(n1, n2, operation);

        assertEquals(2, result);
    }

    @Test
    public void testT2EjercicioD(){
        int n1 = (-1);
        int n2 = (0);
        char operation = '*';

        int result = Calculator.calculator(n1, n2, operation);

        assertEquals(0, result);
    }

    @Test
    public void testT3EjercicioD(){
        int n1 = (-3);
        int n2 = (3);
        char operation = '/';

        int result = Calculator.calculator(n1, n2, operation);

        assertEquals((-1), result);
    }

    @Test
    public void testT4EjercicioD(){
        int n1 = (-8);
        int n2 = (3);
        char operation = '+';

        int result = Calculator.calculator(n1, n2, operation);

        assertEquals((-5), result);
    }

    @Test
    public void testT5EjercicioD(){
        int n1 = (0);
        int n2 = (-15);
        char operation = '*';

        int result = Calculator.calculator(n1, n2, operation);

        assertEquals(0, result);
    }
}
