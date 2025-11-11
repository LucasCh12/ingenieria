package ejercicio1;

// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapters 8, 9; pages 226, 257
// Can be run from command line
// No JUnit tests at this time.


public class Cal
{
   public static int cal (int month1, int day1, int month2,
                          int day2, int year)
   {
   //***********************************************************
   // Calculate the number of Days between the two given days in
   // the same year.
   // preconditions : day1 and day2 must be in same year
   //               1 <= month1, month2 <= 12
   //               1 <= day1, day2 <= 31
   //               month1 <= month2
   //               The range for year: 1 ... 10000
   //***********************************************************
      int numDays;

      if (month2 == month1) // in the same month
         numDays  = day2 - day1;
      else
      {
         // Skip month 0.
         int daysIn[] = {0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
         // Are we in a leap year?
         int m4 = year % 4;
         int m100 = year % 100;
         int m400 = year % 400;
         if ((m4 != 0) || ((m100 == 0) && (m400 != 0)))
            daysIn[2] = 28;
         else
            daysIn[2] = 29;

         // start with days in the two months
         numDays = day2 + (daysIn[month1] - day1);

         // add the days in the intervening months
         for (int i = month1 + 1; i <= month2-1; i++)
            numDays = daysIn[i] + numDays;
      }
      return (numDays);
   }


/*
      En este caso para hacer que se cumpla el criterio de test de cobertura es ejecutar al menos una vez cada linea del codigo,
      las lineas que son criticas y no siempre se van a ejecutar del programa dadas las entradas que sean son:
         +numDays  = day2 - day1; esta linea se ejecuta unicamente si entramos al if (month2 == month1).
         
         +daysIn[2] = 28; esta linea se ejecuta unicamente si entramos al if ((m4 != 0) || ((m100 == 0) && (m400 != 0))).
         
         +daysIn[2] = 29; esta linea se ejecuta unicamente si entramos por la rama del 
         else del if ((m4 != 0) || ((m100 == 0) && (m400 != 0))).
         
         +numDays = daysIn[i] + numDays; esta linea se ejecuta unicamente si entramos al for (int i = month1 + 1; i <= month2-1; i++).

         En este caso, para cubrir el criterio cobertura de sentencias necesitariamos tres test como minimo:
            +Entrar al primer if. (dias de un mismo mes).
            +No entrar al primer if, entrar al segundo if. (año no bisiesto).
            +No entrar al primer if, entrar al else del segundo if (año bisiesto).

            Con esos datos seria: 
               Test 1: month1 = 12, day1= 10, month2 = 12, day2 = 20, year = 2025. (dias mismo mes).
               Test 2: month1 = 3, day1= 10, month2 = 8, day2 = 20, year = 2025.
               Test 3: month1 = 2, day1= 13, month2 = 10, day2 = 25, year = 2012.
      
      En este caso para hacer que se cumpla el criterio de test de cobertura de decision es hacer que todas las decisiones 
      o predicados logicos del codigo sean ejecutados por true y false al menos una vez.

      En este caso tendriamos:
         Test1: Primer if (true). (meses iguales).
         Test2: Primer if (false), Segundo if(true), For(true). (Año no bisiesto y meses con separacion de al menos 2).
         Test3: Primer if (false) , Segundo if(false), For(false). (Año bisiesto y meses con separacion de 1).
 */   

}

