package lt.esdc.shapes.factory;

import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.entity.Point;
import lt.esdc.shapes.exception.ConeException;

import java.util.concurrent.atomic.AtomicInteger;

public class ConeFactory {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    public Cone createFrom(double[] values) throws ConeException {
        if (values.length != 5) {
            throw new ConeException("Ожидалось 5 чисел: x y z radius height");
        }

        double x = values[0];
        double y = values[1];
        double z = values[2];
        double radius = values[3];
        double height = values[4];

        if (radius <= 0 || height <= 0) {
            throw new ConeException("Радиус и высота должны быть положительными");
        }

        String id = "CONE_" + ID_GENERATOR.getAndIncrement();
        Point baseCenter = new Point(x, y, z);
        return new Cone(id, baseCenter, radius, height);
    }
}
