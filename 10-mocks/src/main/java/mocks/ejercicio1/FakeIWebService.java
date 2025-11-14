package mocks.ejercicio1;

public class FakeIWebService implements IWebService {
    
    @Override
    public void logError(String error){
        throw new IllegalArgumentException(".");
    }
}
