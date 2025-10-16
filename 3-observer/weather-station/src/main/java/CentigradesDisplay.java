public class CentigradesDisplay implements Observer, DisplayElement {
    private float temperature;
	private float humidity;

    private WeatherData weatherData;
	
	public CentigradesDisplay() { };
	
	public CentigradesDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
	}
	
	@Override
	public void update() {
        float temperature = weatherData.getTemperature();
		this.temperature = transformFtoC(temperature);		
        this.humidity = weatherData.getHumidity();
		display();
	}
	
	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature 
			+ " Centigrades and " + humidity + "% humidity");
	}

    private float transformFtoC(Float temperature){
        return ((temperature - 30) / 2);
    }

    
}
