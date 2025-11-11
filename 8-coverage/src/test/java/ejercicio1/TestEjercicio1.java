package ejercicio1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestEjercicio1 {

   //Test 1: month1 = 12, day1= 10, month2 = 12, day2 = 20, year = 2025. (dias mismo mes).
    @Test
    public void test1Sentencia(){
        int month1 = 12;
        int day1= 10;
        int month2 = 12;
        int day2 = 20;
        int year = 2025;

        int result = Cal.cal(month1, day1, month2, day2, year);

        assertEquals(10, result);
    }

    //Test 2: month1 = 3, day1= 10, month2 = 8, day2 = 20, year = 2025. (año no bisiesto).
    @Test
    public void test2Sentencia(){
        int month1 = 3;
        int day1= 10;
        int month2 = 8;
        int day2 = 20;
        int year = 2025;

        int result = Cal.cal(month1, day1, month2, day2, year);

        assertEquals(163, result);
    }

    //Test 2: month1 = 2, day1= 13, month2 = 10, day2 = 25, year = 2012. (año bisiesto).
    @Test
    public void test3Sentencia(){
        int month1 = 2;
        int day1= 13;
        int month2 = 10;
        int day2 = 25;
        int year = 2012;

        int result = Cal.cal(month1, day1, month2, day2, year);

        assertEquals(255, result);
    }

    //Test1: Primer if (true). (meses iguales).
    @Test
    public void test1Decision(){
        int month1 = 12;
        int day1= 10;
        int month2 = 12;
        int day2 = 20;
        int year = 2025;

        int result = Cal.cal(month1, day1, month2, day2, year);

        assertEquals(10, result);
    }

    //Test2: Primer if (false), Segundo if(true), For(true). (Año no bisiesto y meses con separacion de al menos 2).
    @Test
    public void test2Decision(){
        int month1 = 3;
        int day1= 10;
        int month2 = 8;
        int day2 = 20;
        int year = 2025;

        int result = Cal.cal(month1, day1, month2, day2, year);

        assertEquals(163, result);
    }

    //Test3: Primer if (false) , Segundo if(false), For(false). (Año bisiesto y meses con separacion de 1).
    @Test
    public void test3Decision(){
        int month1 = 1;
        int day1= 13;
        int month2 = 2;
        int day2 = 25;
        int year = 2012;

        int result = Cal.cal(month1, day1, month2, day2, year);

        assertEquals(43, result);
    }

}