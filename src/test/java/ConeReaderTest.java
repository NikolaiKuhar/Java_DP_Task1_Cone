import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.reader.ConeReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConeReaderTest {

    private ConeReader reader;

    @BeforeEach
    void setUp() {
        reader = new ConeReader();
    }

    @Test
    void shouldReadOnlyValidConesFromFile() throws IOException {
        Path path = Path.of("src/test/resources/test_cones.txt");

        List<Cone> cones = reader.read(path);
        assertEquals(2, cones.size());

        Cone first = cones.get(0);
        assertEquals(2.0, first.getRadius());
        assertEquals(5.0, first.getHeight());

        assertNotNull(first.getId());
        assertTrue(first.getId().startsWith("CONE_"));
    }
}
