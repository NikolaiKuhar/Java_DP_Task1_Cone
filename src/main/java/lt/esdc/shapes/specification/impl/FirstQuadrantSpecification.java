package lt.esdc.shapes.specification.impl;

import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.entity.Point;
import lt.esdc.shapes.specification.Specification;

public class FirstQuadrantSpecification implements Specification {

    @Override
    public boolean specify(Cone cone) {
        Point p = cone.getBaseCenter();
        return p.getX() > 0 && p.getY() > 0 && p.getZ() > 0;
    }
}
