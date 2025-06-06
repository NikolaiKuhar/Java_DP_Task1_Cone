import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.reader.ConeReader;
import lt.esdc.shapes.repository.ConeRepository;
import lt.esdc.shapes.repository.impl.ConeRepositoryImpl;
import lt.esdc.shapes.service.ConeLifecycleService;
import lt.esdc.shapes.validator.ConeValidator;
import lt.esdc.shapes.warehouse.ConeParameters;
import lt.esdc.shapes.warehouse.Warehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConeIntegrationTest {

    private ConeRepository repository;
    private ConeLifecycleService lifecycle;
    private Warehouse warehouse;

    @BeforeEach
    void setUp() {
        repository = new ConeRepositoryImpl();
        lifecycle = new ConeLifecycleService(repository);
        warehouse = Warehouse.getInstance();
    }

    @Test
    void shouldProcessValidConesFromFileEndToEnd() throws IOException {
        ConeReader reader = new ConeReader();
        ConeValidator validator = new ConeValidator();

        Path path = Path.of("src/test/resources/integration_cones.txt");
        List<Cone> cones = reader.read(path).stream()
                .filter(validator::isValid)
                .toList();

        for (Cone cone : cones) {
            lifecycle.register(cone);
        }

        // Проверка: зарегистрировано 2 конуса
        assertEquals(2, repository.getAll().size());

        for (Cone cone : cones) {
            ConeParameters params = warehouse.get(cone.getId());
            assertNotNull(params);
            assertTrue(params.getVolume() > 0);
            assertTrue(params.getSurfaceArea() > 0);
        }
    }
}
