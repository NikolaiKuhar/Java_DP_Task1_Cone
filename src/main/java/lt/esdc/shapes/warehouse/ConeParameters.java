package lt.esdc.shapes.warehouse;

public class ConeParameters {
    private final double volume;
    private final double surfaceArea;

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

    @Override
    public String toString() {
        return "ConeParameters{" +
                "volume=" + volume +
                ", surfaceArea=" + surfaceArea +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConeParameters)) return false;

        ConeParameters that = (ConeParameters) o;

        return Double.compare(that.volume, volume) == 0 &&
                Double.compare(that.surfaceArea, surfaceArea) == 0;
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(volume);
        result = 31 * result + Double.hashCode(surfaceArea);
        return result;
    }
}
