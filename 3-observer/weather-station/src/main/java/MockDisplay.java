class MockDisplay implements Observer {
    private boolean updateCalled = false;
    private Float lastTemp;
    private Float lastHumidity;
    private Float lastPressure;

    private WeatherData weatherData;

    public MockDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
    }
    @Override
    public void update() {
        updateCalled = true;
        this.lastTemp = weatherData.getTemperature();
        this.lastHumidity = weatherData.getHumidity();
        this.lastPressure = weatherData.getPressure();
    }

    public boolean wasUpdateCalled() { return updateCalled; }
    public Float getLastTemp() { return lastTemp; }
    public Float getLastHumidity() { return lastHumidity; }
    public Float getLastPressure() { return lastPressure; }
}