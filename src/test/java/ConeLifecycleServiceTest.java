package lt.esdc.shapes;

import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.entity.Point;
import lt.esdc.shapes.repository.ConeRepository;
import lt.esdc.shapes.repository.impl.ConeRepositoryImpl;
import lt.esdc.shapes.service.ConeLifecycleService;
import lt.esdc.shapes.warehouse.Warehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ConeLifecycleServiceTest {

    private ConeRepository repository;
    private ConeLifecycleService lifecycleService;
    private Cone testCone;

    @BeforeEach
    void setUp() {
        repository = new ConeRepositoryImpl();
        lifecycleService = new ConeLifecycleService(repository);
        testCone = new Cone("TEST_CONE", new Point(0, 0, 0), 2.0, 3.0);
    }

    @Test
    void shouldRegisterCone() {
        lifecycleService.register(testCone);

        Optional<Cone> found = repository.findById("TEST_CONE");
        assertTrue(found.isPresent());

        assertNotNull(Warehouse.getInstance().get("TEST_CONE"));
    }

    @Test
    void shouldUnregisterCone() {
        lifecycleService.register(testCone);
        lifecycleService.unregister(testCone);

        Optional<Cone> found = repository.findById("TEST_CONE");
        assertFalse(found.isPresent());

        assertNull(Warehouse.getInstance().get("TEST_CONE"));
    }
}
