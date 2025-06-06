package lt.esdc.shapes.entity;

import lt.esdc.shapes.observer.ConeObserver;
import lt.esdc.shapes.observer.Observable;

import java.util.ArrayList;
import java.util.List;

public class Cone implements Observable {
    private final String id;
    private Point baseCenter;
    private double radius;
    private double height;
    private final List<ConeObserver> observers = new ArrayList<>();

    public Cone(String id, Point baseCenter, double radius, double height) {
        this.id = id;
        this.baseCenter = baseCenter;
        this.radius = radius;
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public Point getBaseCenter() {
        return baseCenter;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        notifyObservers();
    }

    public void setHeight(double height) {
        this.height = height;
        notifyObservers();
    }

    @Override
    public void addObserver(ConeObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ConeObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ConeObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        return "Cone{" +
                "id='" + id + '\'' +
                ", baseCenter=" + baseCenter +
                ", radius=" + radius +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cone cone = (Cone) o;
        return Double.compare(cone.radius, radius) == 0 &&
                Double.compare(cone.height, height) == 0 &&
                id.equals(cone.id) &&
                baseCenter.equals(cone.baseCenter);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        long temp = Double.doubleToLongBits(radius);
        result = 31 * result + baseCenter.hashCode();
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
