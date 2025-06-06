package lt.esdc.shapes.service;

import lt.esdc.shapes.entity.Cone;

public interface ConeService {
    double calculateSurfaceArea(Cone cone);
    double calculateVolume(Cone cone);
    double calculateVolumeRatioAfterCut(Cone cone);
    boolean isValid(Cone cone);
    boolean isBaseOnCoordinatePlane(Cone cone);
}
