package lt.esdc.shapes.specification.impl;

import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.specification.Specification;
import lt.esdc.shapes.warehouse.ConeParameters;
import lt.esdc.shapes.warehouse.Warehouse;

public class VolumeRangeSpecification implements Specification {

    private final double minVolume;
    private final double maxVolume;
    private final Warehouse warehouse = Warehouse.getInstance();

    public VolumeRangeSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specify(Cone cone) {
        ConeParameters params = warehouse.get(cone.getName());
        if (params == null) {
            return false;
        }
        double volume = params.getVolume();
        return volume >= minVolume && volume <= maxVolume;
    }
}
