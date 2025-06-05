package lt.esdc.shapes;

import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.reader.ConeFileReader;
import lt.esdc.shapes.repository.ConeRepository;
import lt.esdc.shapes.repository.impl.ConeRepositoryImpl;
import lt.esdc.shapes.service.ConeLifecycleService;
import lt.esdc.shapes.validator.ConeValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
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
        ConeRepository repository = new ConeRepositoryImpl();
        ConeLifecycleService lifecycle = new ConeLifecycleService(repository);

        try {
            List<Cone> cones = reader.readConesFromFile(filePath).stream()
                    .filter(validator::isValid)
                    .collect(Collectors.toList());

            for (Cone cone : cones) {
                lifecycle.register(cone);
                logger.info("Зарегистрирован конус: {}", cone);
            }

        } catch (IOException e) {
            logger.error("Ошибка при чтении файла", e);
        }
    }
}
