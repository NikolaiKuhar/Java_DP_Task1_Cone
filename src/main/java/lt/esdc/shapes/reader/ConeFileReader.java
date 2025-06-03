package lt.esdc.shapes.reader;

import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.exception.ConeException;
import lt.esdc.shapes.factory.ConeFactory;
import lt.esdc.shapes.validator.LineValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ConeFileReader {

    private static final Logger logger = LoggerFactory.getLogger(ConeFileReader.class);
    private final LineValidator lineValidator = new LineValidator();
    private final ConeFactory coneFactory = new ConeFactory();

    public List<Cone> readConesFromFile(Path filePath) throws IOException {
        List<Cone> cones = new ArrayList<>();

        try (Stream<String> lines = Files.lines(filePath)) {
            lines.filter(lineValidator::isValid)
                    .forEach(line -> {
                        try {
                            Cone cone = coneFactory.createFromLine(line);
                            cones.add(cone);
                        } catch (ConeException e) {
                            logger.warn("Пропущена строка из-за ошибки создания Cone: {}", e.getMessage());
                        }
                    });
        }
        return cones;
    }
}
