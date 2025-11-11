package ejercicio2;

// Authors: Paul Ammann & Jeff Offutt
// Programmable Thermostat
// Chapter 8
// See ThermostatTest.java for JUnit tests


// Programmable Thermostat
public class Thermostat
{
   private int curTemp;          // current temperature reading
   private int thresholdDiff;    // temp difference until we turn heater on
   private int timeSinceLastRun; // time since heater stopped
   private int minLag;           // how long I need to wait
   private boolean override;     // has user overridden the program
   private int overTemp;         // overriding temperature
   private int runTime;          // output of turnHeaterOn - how long to run
   private boolean heaterOn;     // output of turnHeaterOn - whether to run
   private Period period;        // morning, day, evening, or night
   private DayType day;          // week day or weekend day

   // Decide whether to turn the heater on, and for how long.
   public boolean turnHeaterOn (ProgrammedSettings pSet)
   {
      int dTemp = pSet.getSetting(period, day);

      if (((curTemp < dTemp - thresholdDiff) ||
           (override && curTemp < overTemp - thresholdDiff)) &&
           (timeSinceLastRun > minLag))
      {  // Turn on the heater
         // How long? Assume 1 minute per degree (Fahrenheit)
         int timeNeeded = Math.abs(dTemp - curTemp); // abs() added May 2020
         if (override)
            timeNeeded = Math.abs(overTemp - curTemp); // abs() added May 2020
         setRunTime(timeNeeded);
         setHeaterOn(true);
         return(true);
      }
      else
      {
         setHeaterOn(false);
         return(false);
      }
   } // End turnHeaterOn

   /*
      En este caso para hacer que se cumpla el criterio de test de cobertura es ejecutar al menos una vez cada linea del codigo,
      las lineas que son criticas y no siempre se van a ejecutar del programa dadas las entradas que sean son:

         +int timeNeeded = Math.abs(dTemp - curTemp); entrando unicamente a: if (((curTemp < dTemp - thresholdDiff) ||
           (override && curTemp < overTemp - thresholdDiff)) &&
           (timeSinceLastRun > minLag))
         
         +timeNeeded = Math.abs(overTemp - curTemp); entrando a if (override).

         +setHeaterOn(false); return(false); entrando al else del primer if.

      En este caso, para cubrir el criterio cobertura de sentencias necesitariamos:

         +Test1: Entrar al else.
         +Test2: Entrar al if, y entrar al if override.

      En este caso para hacer que se cumpla el criterio de test de cobertura de decision es hacer que todas las decisiones 
      o predicados logicos del codigo sean ejecutados por true y false al menos una vez.

      En este caso tendriamos:
         +Mismos dos test anteriores:  +primer if(falso).
                                       +primer if(true), segundo if(true).
         y agregarle el ultimo,        +primer if(true), segundo if(false).

   */
   public void setCurrentTemp(int temperature)  { curTemp = temperature; }
   public void setThresholdDiff(int delta)      { thresholdDiff = delta; }
   public void setTimeSinceLastRun(int minutes) { timeSinceLastRun = minutes; }
   public void setMinLag(int minutes)           { minLag = minutes; }
   public void setOverride(boolean value)       { override = value; }
   public void setOverTemp(int temperature)     { overTemp = temperature; }

   // for the ProgrammedSettings
   public void setDay(DayType curDay)      { day = curDay; }
   public void setPeriod(Period curPeriod) { period = curPeriod; }

   // outputs from turnHeaterOn
   void    setRunTime(int minutes)    { runTime = minutes; }
   int     getRunTime()               { return runTime; }
   void    setHeaterOn(boolean value) { heaterOn = value; }
   boolean getHeaterOn()              { return heaterOn; }
} // End Thermostat class
