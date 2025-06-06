import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.entity.Point;
import lt.esdc.shapes.service.ConeService;
import lt.esdc.shapes.service.impl.ConeServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConeServiceTest {

    private final ConeService service = new ConeServiceImpl();

    private final Cone validCone = new Cone(
            "CONE_1",
            new Point(0.0, 0.0, 0.0),
            3.0,
            4.0
    );

    @Test
    void shouldCalculateVolumeCorrectly() {
        double actual = service.calculateVolume(validCone);
        double expected = (1.0 / 3.0) * Math.PI * 3 * 3 * 4;
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    void shouldCalculateSurfaceAreaCorrectly() {
        double r = validCone.getRadius();
        double h = validCone.getHeight();
        double l = Math.sqrt(h * h + r * r);
        double expected = Math.PI * r * (r + l);
        double actual = service.calculateSurfaceArea(validCone);
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    void shouldCalculateVolumeRatioCorrectly() {
        double ratio = service.calculateVolumeRatioAfterCut(validCone);
        assertTrue(ratio > 0 && ratio < 1);
    }

    @Test
    void shouldValidateCorrectCone() {
        assertTrue(service.isValid(validCone));
    }

    @Test
    void shouldDetectBaseOnCoordinatePlane() {
        assertTrue(service.isBaseOnCoordinatePlane(validCone));
    }

    @Test
    void shouldInvalidateConeWithNegativeValues() {
        Cone invalid = new Cone("X", new Point(1, 1, 1), -2, 0);
        assertFalse(service.isValid(invalid));
    }

    @Test
    void shouldInvalidateNullCone() {
        assertFalse(service.isValid(null));
    }
}
