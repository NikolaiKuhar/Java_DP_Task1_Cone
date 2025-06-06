package lt.esdc.shapes.service.impl;

import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.service.ConeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConeServiceImpl implements ConeService {
    private static final Logger logger = LoggerFactory.getLogger(ConeServiceImpl.class);

    @Override
    public double calculateSurfaceArea(Cone cone) {
        double r = cone.getRadius();
        double h = cone.getHeight();
        double l = Math.sqrt(h * h + r * r);
        double result = Math.PI * r * (r + l);
        logger.debug("Surface area calculated: {}", result);
        return result;
    }

    @Override
    public double calculateVolume(Cone cone) {
        double r = cone.getRadius();
        double h = cone.getHeight();
        double result = (1.0 / 3.0) * Math.PI * r * r * h;
        logger.debug("Volume calculated: {}", result);
        return result;
    }

    @Override
    public double calculateVolumeRatioAfterCut(Cone cone) {
        double h = cone.getHeight();
        double newHeight = h / 2;
        double r = cone.getRadius() * (newHeight / h);

        double upperVolume = (1.0 / 3.0) * Math.PI * r * r * newHeight;
        double totalVolume = calculateVolume(cone);
        double lowerVolume = totalVolume - upperVolume;
        double result = upperVolume / lowerVolume;

        logger.debug("Volume ratio calculated: {}", result);
        return result;
    }

    @Override
    public boolean isValid(Cone cone) {
        boolean valid = cone != null && cone.getRadius() > 0 && cone.getHeight() > 0 && cone.getBaseCenter() != null;
        logger.debug("Cone is valid: {}", valid);
        return valid;
    }

    @Override
    public boolean isBaseOnCoordinatePlane(Cone cone) {
        double x = cone.getBaseCenter().getX();
        double y = cone.getBaseCenter().getY();
        double z = cone.getBaseCenter().getZ();
        boolean result = x == 0 || y == 0 || z == 0;
        logger.debug("Base on coordinate plane: {}", result);
        return result;
    }
}
