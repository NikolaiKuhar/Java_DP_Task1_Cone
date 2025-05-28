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
}

