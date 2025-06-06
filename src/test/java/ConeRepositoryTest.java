import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.entity.Point;
import lt.esdc.shapes.repository.ConeRepository;
import lt.esdc.shapes.repository.impl.ConeRepositoryImpl;
import lt.esdc.shapes.specification.Specification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ConeRepositoryTest {

    private ConeRepository repository;
    private Cone cone1;
    private Cone cone2;

    @BeforeEach
    void setUp() {
        repository = new ConeRepositoryImpl();

        cone1 = new Cone("A", new Point(0, 0, 0), 2.0, 3.0);
        cone2 = new Cone("B", new Point(1, 1, 1), 1.0, 1.0);

        repository.add(cone1);
        repository.add(cone2);
    }

    @Test
    void shouldAddAndFindById() {
        Optional<Cone> result = repository.findById("A");
        assertTrue(result.isPresent());
        assertEquals(cone1, result.get());
    }

    @Test
    void shouldReturnAllCones() {
        List<Cone> all = repository.getAll();
        assertEquals(2, all.size());
        assertTrue(all.contains(cone1));
        assertTrue(all.contains(cone2));
    }

    @Test
    void shouldRemoveByObject() {
        boolean removed = repository.remove(cone2);
        assertTrue(removed);
        assertEquals(1, repository.getAll().size());
    }

    @Test
    void shouldRemoveById() {
        boolean removed = repository.removeById("B");
        assertTrue(removed);
        assertEquals(1, repository.getAll().size());
    }

    @Test
    void shouldQueryBySpecification() {
        Specification spec = c -> c.getRadius() > 1.5;
        List<Cone> result = repository.query(spec);
        assertEquals(1, result.size());
        assertEquals(cone1, result.get(0));
    }

    @Test
    void shouldSortByRadius() {
        List<Cone> sorted = repository.sortBy(Comparator.comparingDouble(Cone::getRadius));
        assertEquals("B", sorted.get(0).getId());
        assertEquals("A", sorted.get(1).getId());
    }

    @Test
    void shouldClearRepository() {
        repository.clear();
        assertEquals(0, repository.getAll().size());
    }
}
