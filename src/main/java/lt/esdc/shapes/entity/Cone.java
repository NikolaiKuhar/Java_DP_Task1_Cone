package lt.esdc.shapes.entity;

import lt.esdc.shapes.observer.ConeObserver;

import java.util.ArrayList;
import java.util.List;

public class Cone {
    private String name;
    private Point baseCenter;
    private double radius;
    private double height;
    private final List<ConeObserver> observers = new ArrayList<>();

    public Cone(String name, Point baseCenter, double radius, double height) {
        this.name = name;
        this.baseCenter = baseCenter;
        this.radius = radius;
        this.height = height;
    }

    public String getName() {
        return name;
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

    public void addObserver(ConeObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ConeObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (ConeObserver observer : observers) {
            observer.onConeChanged(this);
        }
    }

    @Override
    public String toString() {
        return "Cone{" +
                "name='" + name + '\'' +
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
                name.equals(cone.name) &&
                baseCenter.equals(cone.baseCenter);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + baseCenter.hashCode();
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
