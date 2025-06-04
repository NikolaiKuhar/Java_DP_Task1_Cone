import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.entity.Point;
import lt.esdc.shapes.repository.ConeRepository;
import lt.esdc.shapes.specification.impl.VolumeRangeSpecification;
import lt.esdc.shapes.warehouse.Warehouse;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ConeIntegrationTest {

    @Test
    public void testObserverUpdatesWarehouse() {
        // given
        Cone cone = new Cone("OBS_1", new Point(0, 0, 0), 2.0, 3.0);
        Warehouse warehouse = Warehouse.getInstance();
        cone.addObserver(warehouse);
        warehouse.put(cone.getName(), cone);

        double originalVolume = warehouse.get(cone.getName()).getVolume();

        // when
        cone.setHeight(6.0);
        double updatedVolume = warehouse.get(cone.getName()).getVolume();

        // then
        assertTrue(updatedVolume > originalVolume);
    }

    @Test
    public void testRepositoryQueryWithSpecification() {
        // given
        Cone cone = new Cone("REP_1", new Point(1, 1, 1), 2.0, 5.0);
        Warehouse.getInstance().put(cone.getName(), cone);
        ConeRepository repository = ConeRepository.getInstance();
        repository.add(cone);

        VolumeRangeSpecification spec = new VolumeRangeSpecification(10, 100);

        // when
        boolean contains = repository.query(spec).contains(cone);

        // then
        assertTrue(contains);
    }
}

