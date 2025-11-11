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
}