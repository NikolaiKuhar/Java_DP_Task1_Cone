import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.entity.Point;
import lt.esdc.shapes.service.impl.ConeServiceImpl;
import lt.esdc.shapes.specification.Specification;
import lt.esdc.shapes.specification.impl.*;
import lt.esdc.shapes.warehouse.Warehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConeSpecificationTest {

    private Cone cone1;
    private Cone cone2;

    @BeforeEach
    void setUp() {
        cone1 = new Cone("CONE_A", new Point(1, 1, 1), 3.0, 4.0);
        cone2 = new Cone("CONE_B", new Point(-1, -1, -1), 1.0, 2.0);

        Warehouse warehouse = Warehouse.getInstance();
        warehouse.update(cone1);
        warehouse.update(cone2);
    }

    @Test
    void shouldMatchIdSpecification() {
        Specification idSpec = new IdSpecification("CONE_A");
        assertTrue(idSpec.specify(cone1));
        assertFalse(idSpec.specify(cone2));
    }

    @Test
    void shouldMatchHeightGreaterThanSpecification() {
        Specification heightSpec = new HeightGreaterThanSpecification(3.0);
        assertTrue(heightSpec.specify(cone1));
        assertFalse(heightSpec.specify(cone2));
    }

    @Test
    void shouldMatchFirstQuadrantSpecification() {
        Specification quadrantSpec = new FirstQuadrantSpecification();
        assertTrue(quadrantSpec.specify(cone1));
        assertFalse(quadrantSpec.specify(cone2));
    }

    @Test
    void shouldMatchRadiusGreaterThanSpecification() {
        Specification radiusSpec = new RadiusGreaterThanSpecification(2.5);
        assertTrue(radiusSpec.specify(cone1));
        assertFalse(radiusSpec.specify(cone2));
    }

    @Test
    void shouldMatchVolumeRangeSpecification() {
        double volume1 = new ConeServiceImpl().calculateVolume(cone1);
        Specification volumeSpec = new VolumeRangeSpecification(volume1 - 1, volume1 + 1);
        assertTrue(volumeSpec.specify(cone1));
        assertFalse(volumeSpec.specify(cone2));
    }
}
