import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestObservers {

    @Test
    public void testThreeObservers() {
        WeatherData weatherData = new WeatherData();

        Observer currentDisplay =
                new CurrentConditionsDisplay(weatherData);
        Observer statisticsDisplay = new StatisticsDisplay(weatherData);
        Observer forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(statisticsDisplay);
        weatherData.registerObserver(forecastDisplay);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }

    @Test
    public void testRemoveObserver() {
        WeatherData weatherData = new WeatherData();

        Observer currentDisplay = new CurrentConditionsDisplay(weatherData);
        Observer statisticsDisplay = new StatisticsDisplay(weatherData);
        Observer forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(statisticsDisplay);
        weatherData.registerObserver(forecastDisplay);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);

        weatherData.removeObserver(forecastDisplay);
        weatherData.setMeasurements(62, 90, 28.1f);
    }

    @Test
    public void testChangeObserverExecutionTime() {
        WeatherData weatherData = new WeatherData();

        Observer currentDisplay = new CurrentConditionsDisplay(weatherData);
        Observer statisticsDisplay = new StatisticsDisplay(weatherData);

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(statisticsDisplay);

        weatherData.setMeasurements(80, 65, 30.4f);

        weatherData.removeObserver(statisticsDisplay);

        weatherData.setMeasurements(82, 70, 29.2f);

        Observer forecastDisplay = new ForecastDisplay(weatherData);
 
        weatherData.registerObserver(forecastDisplay);

        weatherData.setMeasurements(78, 90, 29.2f);

    }

    @Test
    public void testObserverReceivesUpdate() {
        WeatherData weatherData = new WeatherData();
        MockDisplay mock = new MockDisplay(weatherData);

        weatherData.registerObserver(mock);
        weatherData.setMeasurements(25, 60, 1000);

        assertTrue(mock.wasUpdateCalled());
        assertEquals(25f, mock.getLastTemp());
        assertEquals(60f, mock.getLastHumidity());
        assertEquals(1000f, mock.getLastPressure());
    }

    @Test
    public void testCentigradesDisplay(){
        WeatherData weatherData = new WeatherData();

        Observer centigradesDisplay = new CentigradesDisplay(weatherData);
        Observer currentDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.registerObserver(centigradesDisplay);
        weatherData.registerObserver(currentDisplay);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
    }

    @Test
    public void testCurrentWithHeatDisplay(){
        WeatherData weatherData = new WeatherData();

        Observer currentWithHeatDisplay = new CurrentConditionsWithHeatDisplay(weatherData);
        Observer currentDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.registerObserver(currentWithHeatDisplay);
        weatherData.registerObserver(currentDisplay);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
    }



}
