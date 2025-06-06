package lt.esdc.shapes.parser;

import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.exception.ConeException;

public class ConeDataParser implements ConeParser<double[]> {

    @Override
    public double[] parse(String line) throws ConeException {
        if (line == null || line.isBlank()) {
            throw new ConeException("Пустая строка не может быть обработана");
        }

        String[] tokens = line.trim().split("\\s+");
        if (tokens.length != 5) {
            throw new ConeException("Ожидалось 5 чисел, получено: " + tokens.length);
        }

        try {
            double[] values = new double[5];
            for (int i = 0; i < 5; i++) {
                values[i] = Double.parseDouble(tokens[i]);
            }
            return values;
        } catch (NumberFormatException e) {
            throw new ConeException("Ошибка разбора строки: " + line, e);
        }
    }
}
