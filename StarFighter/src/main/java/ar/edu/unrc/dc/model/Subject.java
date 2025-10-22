package ar.edu.unrc.dc.model;

public interface Subject {
    public void notifyObservers();
    public void attach(Observer o);
    public void detach(Observer o);
}
