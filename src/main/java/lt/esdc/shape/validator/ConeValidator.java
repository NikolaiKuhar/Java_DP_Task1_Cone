package lt.esdc.shape.validator;

import lt.esdc.shape.entity.Cone;

public class ConeValidator {
    public boolean isValid(Cone cone) {
        if (cone == null) {
            return false;
        }

        if (cone.getBaseCenter() == null) {
            return false;
        }

        if (cone.getRadius() <= 0 || cone.getHeight() <= 0) {
            return false;
        }

        if (cone.getName() == null || cone.getName().isBlank()) {
            return false;
        }

        return true;
    }
}
