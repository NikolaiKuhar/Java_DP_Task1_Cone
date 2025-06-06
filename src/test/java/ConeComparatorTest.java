import lt.esdc.shapes.comparator.ConeHeightComparator;
import lt.esdc.shapes.comparator.ConeIdComparator;
import lt.esdc.shapes.comparator.ConeRadiusComparator;
import lt.esdc.shapes.comparator.ConeXCoordinateComparator;
import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.entity.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConeComparatorTest {

    private Cone coneA;
    private Cone coneB;

    @BeforeEach
    void setUp() {
        coneA = new Cone("A", new Point(1.0, 2.0, 3.0), 3.0, 4.0);
        coneB = new Cone("B", new Point(5.0, 6.0, 7.0), 2.0, 6.0);
    }

    @Test
    void shouldSortById() {
        List<Cone> list = Arrays.asList(coneB, coneA);
        list.sort(new ConeIdComparator());
        assertEquals("A", list.get(0).getId());
        assertEquals("B", list.get(1).getId());
    }

    @Test
    void shouldSortByRadius() {
        List<Cone> list = Arrays.asList(coneA, coneB);
        list.sort(new ConeRadiusComparator());
        assertEquals("B", list.get(0).getId());
        assertEquals("A", list.get(1).getId());
    }

    @Test
    void shouldSortByHeight() {
        List<Cone> list = Arrays.asList(coneA, coneB);
        list.sort(new ConeHeightComparator());
        assertEquals("A", list.get(0).getId()); // 4.0 < 6.0
    }

    @Test
    void shouldSortByXCoordinateOfBase() {
        List<Cone> list = Arrays.asList(coneB, coneA);
        list.sort(new ConeXCoordinateComparator());
        assertEquals("A", list.get(0).getId()); // 1.0 < 5.0
    }
}
