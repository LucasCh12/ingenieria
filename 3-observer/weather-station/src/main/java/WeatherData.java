import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    @SuppressWarnings("FieldMayBeFinal")
	private List<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		observers = new ArrayList<>();
	}
	
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	
	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}
	
	public void measurementsChanged() {
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

	public float getTemperature() {
		return temperature;
	}
	
	public float getHumidity() {
		return humidity;
	}
	
	public float getPressure() {
		return pressure;
	}

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();

        Observer currentWithHeatDisplay = new CurrentConditionsWithHeatDisplay(weatherData);
        Observer currentDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.registerObserver(currentWithHeatDisplay);
        weatherData.registerObserver(currentDisplay);

        weatherData.setMeasurements(80, 65, 30.4f);

	}

}
