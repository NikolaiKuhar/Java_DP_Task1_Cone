package lt.esdc.shape.factory;
import lt.esdc.shape.entity.Cone;
import lt.esdc.shape.entity.Point;

public class ConeFactory {
    private static int counter = 1;

    public Cone createFromLine(String line) {
        if (line == null || line.isBlank()) {
            return null;
        }

        String[] tokens = line.trim().split("\\s+");
        if (tokens.length != 5) {
            return null;
        }

        try {
            double x = Double.parseDouble(tokens[0]);
            double y = Double.parseDouble(tokens[1]);
            double z = Double.parseDouble(tokens[2]);
            double radius = Double.parseDouble(tokens[3]);
            double height = Double.parseDouble(tokens[4]);

            Point baseCenter = new Point(x, y, z);
            String name = "CONE_" + counter++;
            return new Cone(name, baseCenter, radius, height);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
