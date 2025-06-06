package lt.esdc.shapes.specification.impl;

import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.specification.Specification;

public class RadiusGreaterThanSpecification implements Specification {

    private final double threshold;

    public RadiusGreaterThanSpecification(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean specify(Cone cone) {
        return cone.getRadius() > threshold;
    }
}
