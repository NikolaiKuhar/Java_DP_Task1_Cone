package lt.esdc.shapes.validator;

import lt.esdc.shapes.entity.Cone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConeValidator {
    private static final Logger logger = LoggerFactory.getLogger(ConeValidator.class);

    /**
     * Проверка валидности объекта Cone.
     */
    public boolean isValid(Cone cone) {
        if (cone == null) {
            logger.warn("Валидатор: Конус null");
            return false;
        }

        if (cone.getBaseCenter() == null) {
            logger.warn("Валидатор: Точка основания null");
            return false;
        }

        if (cone.getRadius() <= 0 || cone.getHeight() <= 0) {
            logger.warn("Валидатор: Радиус и/или высота <= 0");
            return false;
        }

        if (cone.getId() == null || cone.getId().isBlank()) {
            logger.warn("Валидатор: ID пустой или null");
            return false;
        }

        return true;
    }
}
