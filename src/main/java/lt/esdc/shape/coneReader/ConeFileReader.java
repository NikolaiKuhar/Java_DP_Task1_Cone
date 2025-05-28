package lt.esdc.shape.coneReader;

import lt.esdc.shape.entity.Cone;
import lt.esdc.shape.factory.ConeFactory;
import lt.esdc.shape.validator.LineValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ConeFileReader {

    private final LineValidator lineValidator = new LineValidator();
    private final ConeFactory coneFactory = new ConeFactory();

    public List<Cone> readConesFromFile(Path filePath) throws IOException {
        List<Cone> cones = new ArrayList<>();

        try (Stream<String> lines = Files.lines(filePath)) {
            lines.filter(lineValidator::isValid)
                    .map(coneFactory::createFromLine)
                    .filter(cone -> cone != null)
                    .forEach(cones::add);
        }

        return cones;
    }
}
