package lt.esdc.shapes.observer;

public interface Observable {
    void addObserver(ConeObserver observer);
    void removeObserver(ConeObserver observer);
    void notifyObservers();
}
