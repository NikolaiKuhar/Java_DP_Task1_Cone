import lt.esdc.shape.coneReader.ConeFileReader;
import lt.esdc.shape.entity.Cone;
import lt.esdc.shape.validator.ConeValidator;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Path filePath = Paths.get("resources/cones.txt");

        ConeFileReader reader = new ConeFileReader();
        ConeValidator validator = new ConeValidator();

        try {
            List<Cone> cones = reader.readConesFromFile(filePath).stream()
                    .filter(validator::isValid)
                    .collect(Collectors.toList());

            System.out.println("Загруженные конусы:");
            for (Cone cone : cones) {
                System.out.println(cone);
            }
        } catch (Exception e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
