import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.entity.Point;
import lt.esdc.shapes.validator.ConeValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConeValidatorTest {

    private ConeValidator validator;

    @BeforeEach
    void setUp() {
        validator = new ConeValidator();
    }

    @Test
    void shouldReturnTrueForValidCone() {
        Cone cone = new Cone("CONE_1", new Point(1, 2, 3), 3.0, 5.0);
        assertTrue(validator.isValid(cone));
    }

    @Test
    void shouldReturnFalseIfConeIsNull() {
        assertFalse(validator.isValid(null));
    }

    @Test
    void shouldReturnFalseIfBaseCenterIsNull() {
        Cone cone = new Cone("CONE_X", null, 2.0, 2.0);
        assertFalse(validator.isValid(cone));
    }

    @Test
    void shouldReturnFalseIfRadiusOrHeightIsZeroOrNegative() {
        Cone zeroRadius = new Cone("C1", new Point(0, 0, 0), 0.0, 5.0);
        Cone negativeHeight = new Cone("C2", new Point(0, 0, 0), 2.0, -3.0);
        assertFalse(validator.isValid(zeroRadius));
        assertFalse(validator.isValid(negativeHeight));
    }

    @Test
    void shouldReturnFalseIfIdIsNullOrBlank() {
        Cone nullId = new Cone(null, new Point(1, 1, 1), 2.0, 3.0);
        Cone blankId = new Cone("   ", new Point(1, 1, 1), 2.0, 3.0);
        assertFalse(validator.isValid(nullId));
        assertFalse(validator.isValid(blankId));
    }
}
