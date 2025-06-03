package lt.esdc.shapes.warehouse;

public class ConeParameters {
    private double volume;
    private double surfaceArea;

    public ConeParameters(double volume, double surfaceArea) {
        this.volume = volume;
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    @Override
    public String toString() {
        return "ConeParameters{" +
                "volume=" + volume +
                ", surfaceArea=" + surfaceArea +
                '}';
    }
}
