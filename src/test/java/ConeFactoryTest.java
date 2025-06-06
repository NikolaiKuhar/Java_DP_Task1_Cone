import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.entity.Point;
import lt.esdc.shapes.exception.ConeException;
import lt.esdc.shapes.factory.ConeFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConeFactoryTest {

    private ConeFactory factory;

    @BeforeEach
    void setUp() {
        factory = new ConeFactory();
    }

    @Test
    void shouldCreateConeFromValidArray() throws ConeException {
        double[] values = {1.0, 2.0, 3.0, 3.0, 5.0};
        Cone cone = factory.createFrom(values);

        assertNotNull(cone);
        assertEquals(3.0, cone.getRadius());
        assertEquals(5.0, cone.getHeight());

        Point base = cone.getBaseCenter();
        assertEquals(1.0, base.getX());
        assertEquals(2.0, base.getY());
        assertEquals(3.0, base.getZ());
    }

    @Test
    void shouldThrowExceptionIfArrayIsTooShort() {
        double[] values = {1.0, 2.0, 3.0};
        ConeException e = assertThrows(ConeException.class, () -> factory.createFrom(values));
        assertTrue(e.getMessage().contains("5 чисел"));
    }

    @Test
    void shouldThrowExceptionIfRadiusOrHeightNegative() {
        double[] values = {0.0, 0.0, 0.0, -1.0, 5.0};
        assertThrows(ConeException.class, () -> factory.createFrom(values));

        double[] values2 = {0.0, 0.0, 0.0, 2.0, -4.0};
        assertThrows(ConeException.class, () -> factory.createFrom(values2));
    }
}
