package lt.esdc.shape.service;

import lt.esdc.shape.entity.Cone;

public class ConeService {

    public double calculateSurfaceArea(Cone cone) {
        double r = cone.getRadius();
        double h = cone.getHeight();
        double l = Math.sqrt(h * h + r * r); // образующая (slant height)
        return Math.PI * r * (r + l);
    }

    public double calculateVolume(Cone cone) {
        double r = cone.getRadius();
        double h = cone.getHeight();
        return (1.0 / 3.0) * Math.PI * r * r * h;
    }

    public double volumeRatioAfterPlaneCut(Cone cone) {
        // Допустим, сечение делит конус пополам по высоте
        double h = cone.getHeight();
        double newHeight = h / 2;
        double r = cone.getRadius() * (newHeight / h); // пропорционально высоте

        double upperVolume = (1.0 / 3.0) * Math.PI * r * r * newHeight;
        double totalVolume = calculateVolume(cone);

        double lowerVolume = totalVolume - upperVolume;
        return upperVolume / lowerVolume;
    }

    public boolean isValidCone(Cone cone) {
        return cone != null && cone.getRadius() > 0 && cone.getHeight() > 0 && cone.getBaseCenter() != null;
    }

    public boolean isBaseOnCoordinatePlane(Cone cone) {
        double x = cone.getBaseCenter().getX();
        double y = cone.getBaseCenter().getY();
        double z = cone.getBaseCenter().getZ();

        return x == 0 || y == 0 || z == 0;
    }
}

