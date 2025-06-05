package lt.esdc.shapes.comparator;

import lt.esdc.shapes.entity.Cone;
import java.util.Comparator;

public class ConeRadiusComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone c1, Cone c2) {
        return Double.compare(c1.getRadius(), c2.getRadius());
    }
}
