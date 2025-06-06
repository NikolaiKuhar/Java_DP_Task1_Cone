package lt.esdc.shapes.specification.impl;

import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.specification.Specification;

public class IdSpecification implements Specification {

    private final String targetId;

    public IdSpecification(String targetId) {
        this.targetId = targetId;
    }

    @Override
    public boolean specify(Cone cone) {
        return cone.getId().equals(targetId);
    }
}
