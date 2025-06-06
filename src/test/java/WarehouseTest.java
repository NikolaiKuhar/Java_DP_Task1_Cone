import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.entity.Point;
import lt.esdc.shapes.service.impl.ConeServiceImpl;
import lt.esdc.shapes.warehouse.ConeParameters;
import lt.esdc.shapes.warehouse.Warehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class WarehouseTest {

    private Warehouse warehouse;
    private Cone testCone;

    @BeforeEach
    void setUp() {
        warehouse = Warehouse.getInstance();
        testCone = new Cone("TEST_ID", new Point(0, 0, 0), 3.0, 4.0);
        warehouse.update(testCone);
    }

    @Test
    void shouldStoreParametersAfterUpdate() {
        ConeParameters params = warehouse.get("TEST_ID");
        assertNotNull(params);

        double expectedVolume = new ConeServiceImpl().calculateVolume(testCone);
        double expectedArea = new ConeServiceImpl().calculateSurfaceArea(testCone);

        assertEquals(expectedVolume, params.getVolume(), 0.0001);
        assertEquals(expectedArea, params.getSurfaceArea(), 0.0001);
    }

    @Test
    void shouldReturnAllAsUnmodifiableMap() {
        Map<String, ConeParameters> all = warehouse.getAll();
        assertThrows(UnsupportedOperationException.class, () -> all.put("X", new ConeParameters(1, 1)));
    }

    @Test
    void shouldRemoveParametersById() {
        warehouse.remove("TEST_ID");
        assertNull(warehouse.get("TEST_ID"));
    }
}
