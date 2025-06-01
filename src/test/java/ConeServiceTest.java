import lt.esdc.shape.entity.Cone;
import lt.esdc.shape.entity.Point;
import lt.esdc.shape.service.ConeService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ConeServiceTest {

    private static final double DELTA = 1e-6;

    @Test
    public void testCalculateVolume() {
        // given
        Cone cone = new Cone("TestCone", new Point(0, 0, 0), 3.0, 4.0);
        ConeService service = new ConeService();

        // when
        double actualVolume = service.calculateVolume(cone);

        // then
        double expectedVolume = (1.0 / 3.0) * Math.PI * 3.0 * 3.0 * 4.0;
        assertEquals(actualVolume, expectedVolume, DELTA);
    }

    @Test
    public void testCalculateSurfaceArea() {
        // given
        Cone cone = new Cone("TestCone", new Point(0, 0, 0), 3.0, 4.0);
        ConeService service = new ConeService();

        // when
        double actualSurfaceArea = service.calculateSurfaceArea(cone);

        // then
        double slantHeight = Math.sqrt(4.0 * 4.0 + 3.0 * 3.0); // √(h² + r²)
        double expectedSurfaceArea = Math.PI * 3.0 * (3.0 + slantHeight);
        assertEquals(actualSurfaceArea, expectedSurfaceArea, DELTA);
    }

    @Test
    public void testVolumeRatioAfterPlaneCut() {
        // given
        Cone cone = new Cone("TestCone", new Point(0, 0, 0), 3.0, 4.0);
        ConeService service = new ConeService();

        // when
        double ratio = service.volumeRatioAfterPlaneCut(cone);

        // then
        double expectedRatio = 1.0 / 7.0; // верхний объём в 8 раз меньше полного (1/8), нижний = 7/8
        assertEquals(ratio, expectedRatio, DELTA);
    }

    @Test
    public void testIsBaseOnCoordinatePlane() {
        // given
        Cone cone = new Cone("TestCone", new Point(0, 5.0, 2.0), 3.0, 4.0);
        ConeService service = new ConeService();

        // when
        boolean result = service.isBaseOnCoordinatePlane(cone);

        // then
        assertEquals(result, true);
    }

}

