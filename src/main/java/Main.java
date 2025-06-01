import lt.esdc.shape.coneReader.ConeFileReader;
import lt.esdc.shape.entity.Cone;
import lt.esdc.shape.validator.ConeValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Path filePath = Paths.get("resources/cones.txt");

        ConeFileReader reader = new ConeFileReader();
        ConeValidator validator = new ConeValidator();

        try {
            List<Cone> cones = reader.readConesFromFile(filePath).stream()
                    .filter(validator::isValid)
                    .collect(Collectors.toList());

            logger.info("Загруженные конусы:");
            for (Cone cone : cones) {
                logger.info(cone.toString());
            }
        } catch (Exception e) {
            logger.error("Ошибка при чтении файла", e);
        }
    }
}

