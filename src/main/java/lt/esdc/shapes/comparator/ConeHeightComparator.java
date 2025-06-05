package lt.esdc.shapes.comparator;

import lt.esdc.shapes.entity.Cone;
import java.util.Comparator;

public class ConeHeightComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone c1, Cone c2) {
        return Double.compare(c1.getHeight(), c2.getHeight());
    }
}

