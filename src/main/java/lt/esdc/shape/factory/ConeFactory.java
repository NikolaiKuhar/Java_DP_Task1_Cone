package lt.esdc.shape.factory;

import lt.esdc.shape.entity.Cone;
import lt.esdc.shape.entity.Point;
import lt.esdc.shape.exception.ConeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConeFactory {
    private static final Logger logger = LoggerFactory.getLogger(ConeFactory.class);
    private static int counter = 1;

    public Cone createFromLine(String line) throws ConeException {
        if (line == null || line.isBlank()) {
            logger.warn("Пустая или null строка при создании Cone");
            throw new ConeException("Строка для создания Cone пуста или отсутствует");
        }

        String[] tokens = line.trim().split("\\s+");
        if (tokens.length != 5) {
            logger.warn("Неверное количество параметров: {}", line);
            throw new ConeException("Неверное количество параметров в строке: " + line);
        }

        try {
            double x = Double.parseDouble(tokens[0]);
            double y = Double.parseDouble(tokens[1]);
            double z = Double.parseDouble(tokens[2]);
            double radius = Double.parseDouble(tokens[3]);
            double height = Double.parseDouble(tokens[4]);

            Point baseCenter = new Point(x, y, z);
            String name = "CONE_" + counter++;
            Cone cone = new Cone(name, baseCenter, radius, height);
            logger.info("Успешно создан Cone: {}", cone);
            return cone;
        } catch (NumberFormatException e) {
            logger.error("Ошибка парсинга строки: {}", line, e);
            throw new ConeException("Ошибка парсинга строки: " + line, e);
        }
    }
}
