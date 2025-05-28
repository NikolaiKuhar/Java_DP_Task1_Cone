package lt.esdc.shape.entity;

public class Cone {
    private String name;
    private Point baseCenter;
    private double radius;
    private double height;

    public Cone(String name, Point baseCenter, double radius, double height) {
        this.name = name;
        this.baseCenter = baseCenter;
        this.radius = radius;
        this.height = height;
    }

    // Getters, Setters, toString, equals, hashCode
}
