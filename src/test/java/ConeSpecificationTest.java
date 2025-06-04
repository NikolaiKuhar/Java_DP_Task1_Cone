import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.entity.Point;
import lt.esdc.shapes.specification.*;
import lt.esdc.shapes.specification.impl.FirstQuadrantSpecification;
import lt.esdc.shapes.specification.impl.HeightGreaterThanSpecification;
import lt.esdc.shapes.specification.impl.IdSpecification;
import lt.esdc.shapes.specification.impl.VolumeRangeSpecification;
import lt.esdc.shapes.warehouse.ConeParameters;
import lt.esdc.shapes.warehouse.Warehouse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ConeSpecificationTest {

    private Cone testCone;

    @BeforeClass
    public void setup() {
        testCone = new Cone("CONE_SPEC", new Point(1, 1, 1), 2.0, 5.0);
        Warehouse.getInstance().put(testCone.getName(), testCone);
    }

    @Test
    public void testIdSpecification() {
        // given
        IdSpecification spec = new IdSpecification("CONE_SPEC");

        // when
        boolean result = spec.specify(testCone);

        // then
        assertTrue(result);
    }

    @Test
    public void testHeightGreaterThanSpecification() {
        // given
        HeightGreaterThanSpecification spec = new HeightGreaterThanSpecification(4.0);

        // when
        boolean result = spec.specify(testCone);

        // then
        assertTrue(result);
    }

    @Test
    public void testFirstQuadrantSpecification() {
        // given
        FirstQuadrantSpecification spec = new FirstQuadrantSpecification();

        // when
        boolean result = spec.specify(testCone);

        // then
        assertTrue(result);
    }

    @Test
    public void testVolumeRangeSpecification() {
        // given
        double volume = Warehouse.getInstance().get(testCone.getName()).getVolume();
        VolumeRangeSpecification spec = new VolumeRangeSpecification(volume - 1, volume + 1);

        // when
        boolean result = spec.specify(testCone);

        // then
        assertTrue(result);
    }
}
