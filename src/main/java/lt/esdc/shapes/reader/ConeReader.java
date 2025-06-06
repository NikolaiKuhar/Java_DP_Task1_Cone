package lt.esdc.shapes.reader;

import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.exception.ConeException;
import lt.esdc.shapes.factory.ConeFactory;
import lt.esdc.shapes.parser.ConeDataParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ConeReader {
    private static final Logger logger = LoggerFactory.getLogger(ConeReader.class);
    private final ConeDataParser parser = new ConeDataParser();
    private final ConeFactory factory = new ConeFactory();

    public List<Cone> read(Path path) throws IOException {
        List<Cone> cones = new ArrayList<>();

        for (String line : Files.readAllLines(path)) {
            try {
                double[] values = parser.parse(line);
                Cone cone = factory.createFrom(values);
                cones.add(cone);
            } catch (ConeException e) {
                logger.warn("Пропущена строка из-за ошибки: {}", e.getMessage());
            }
        }

        return cones;
    }
}
