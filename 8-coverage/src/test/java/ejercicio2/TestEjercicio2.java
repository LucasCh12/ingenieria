package ejercicio2;

import ejercicio2.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestEjercicio2 {

    /*   
        Test1: Entrar al else, osea no entrar al if haciendo falso:
            +curTemp < dTemp - thresholdDiff.
            +(override && curTemp < overTemp - thresholdDiff)).
            +(timeSinceLastRun > minLag)).

            Para hacer falso lo primero: curTemp >= dTemp - thresholdDiff.
            Para hacer falso lo segundo: (override && curTemp >= overTemp - thresholdDiff).
            Para hacer falso lo tercero: (timeSinceLastRun <= minLag).

            1)_ curTemp = 100, dTemp = 50, thresholdDiff = 20.
                100 >= 50 - 20, osea:
                100 >= 30.

            2)_ override = falso

            3)_ Con el 2) se hace falso todo.
    */
    @Test
    public void test1Sentencia(){
        Thermostat thermostat = new Thermostat();
        ProgrammedSettings settings = new ProgrammedSettings();
        thermostat.setCurrentTemp(100);
        thermostat.setThresholdDiff(20);
        thermostat.setOverride(false);
        thermostat.setDay(DayType.WEEKDAY);
        thermostat.setPeriod(Period.EVENING);
        settings.setSetting(Period.MORNING, DayType.WEEKDAY, 50);

        assertFalse(thermostat.turnHeaterOn(settings));
        assertFalse(thermostat.getHeaterOn());

    }

    /*
     *  Test2: Entrar al if, y entrar al if override, osea hacer verdadero:
            +curTemp < dTemp - thresholdDiff.
            +(override && curTemp < overTemp - thresholdDiff).
            +(timeSinceLastRun > minLag).
            +override.
            
            1)_ curTemp = 50, dTemp = 200, thresholdDiff = 100.
                50 < 200 - 100.
                50 < 100.
            
            2)_ override = true, curTemp = 50, overTemp = 300, thresholdDiff = 100.

            3)_ timeSinceLastRun = 50, minLag = 20.
     */
    @Test
    public void test2Sentencia(){
        Thermostat thermostat = new Thermostat();
        ProgrammedSettings settings = new ProgrammedSettings();
        thermostat.setCurrentTemp(50);
        thermostat.setThresholdDiff(100);
        thermostat.setOverride(true);
        thermostat.setOverTemp(300);
        thermostat.setTimeSinceLastRun(50);
        thermostat.setMinLag(20);
        thermostat.setDay(DayType.WEEKDAY);
        thermostat.setPeriod(Period.EVENING);
        settings.setSetting(Period.MORNING, DayType.WEEKDAY, 200);

        int runTime = thermostat.getRunTime();

        String string = settings.toString();

        assertTrue(thermostat.turnHeaterOn(settings));
        assertTrue(thermostat.getHeaterOn());
    }

    //Test1: primer if(true), segundo if(false).
    @Test
    public void test1Decision(){
        Thermostat thermostat = new Thermostat();
        ProgrammedSettings settings = new ProgrammedSettings();
        thermostat.setCurrentTemp(50);
        thermostat.setThresholdDiff(100);
        thermostat.setOverride(false);
        thermostat.setOverTemp(300);
        thermostat.setTimeSinceLastRun(50);
        thermostat.setMinLag(20);
        thermostat.setDay(DayType.WEEKDAY);
        thermostat.setPeriod(Period.EVENING);
        settings.setSetting(Period.EVENING, DayType.WEEKDAY, 200);

        assertTrue(thermostat.turnHeaterOn(settings));
        assertTrue(thermostat.getHeaterOn());
    }

    @Test
public void test3Decision_timeTooShort() {
    Thermostat thermostat = new Thermostat();
    ProgrammedSettings settings = new ProgrammedSettings();

    thermostat.setCurrentTemp(50);
    thermostat.setThresholdDiff(100);
    thermostat.setOverride(false); // no override
    thermostat.setTimeSinceLastRun(5);
    thermostat.setMinLag(20); // C = false
    thermostat.setDay(DayType.WEEKDAY);
    thermostat.setPeriod(Period.EVENING);
    settings.setSetting(Period.EVENING, DayType.WEEKDAY, 200); // A = true

    assertFalse(thermostat.turnHeaterOn(settings));
    assertFalse(thermostat.getHeaterOn());
}
@Test
public void test4Decision_tempsTooHigh() {
    Thermostat thermostat = new Thermostat();
    ProgrammedSettings settings = new ProgrammedSettings();

    thermostat.setCurrentTemp(90);
    thermostat.setThresholdDiff(10);
    thermostat.setOverride(false);
    thermostat.setTimeSinceLastRun(50);
    thermostat.setMinLag(20);
    thermostat.setDay(DayType.WEEKDAY);
    thermostat.setPeriod(Period.EVENING);
    settings.setSetting(Period.EVENING, DayType.WEEKDAY, 80); // A = false

    assertFalse(thermostat.turnHeaterOn(settings));
    assertFalse(thermostat.getHeaterOn());
}
@Test
public void testConditionATrueButTimeLagFalse() {
    Thermostat thermostat = new Thermostat();
    ProgrammedSettings settings = new ProgrammedSettings();
    
    // Condición A VERDADERA: curTemp < dTemp - thresholdDiff
    thermostat.setCurrentTemp(50);           // curTemp = 50
    thermostat.setThresholdDiff(10);         // thresholdDiff = 10
    settings.setSetting(Period.MORNING, DayType.WEEKDAY, 70); // dTemp = 70
    // 50 < (70 - 10) = 60 → TRUE
    
    // Condición C FALSA: timeSinceLastRun <= minLag  
    thermostat.setTimeSinceLastRun(5);       // timeSinceLastRun = 5
    thermostat.setMinLag(10);                // minLag = 10
    // 5 > 10 → FALSE
    
    // Condición B irrelevante (cortocircuito)
    thermostat.setOverride(false);
    
    thermostat.setDay(DayType.WEEKDAY);
    thermostat.setPeriod(Period.MORNING);

    assertFalse(thermostat.turnHeaterOn(settings));
    assertFalse(thermostat.getHeaterOn());
}
}