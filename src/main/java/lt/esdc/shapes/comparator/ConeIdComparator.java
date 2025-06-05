package lt.esdc.shapes.comparator;

import lt.esdc.shapes.entity.Cone;
import java.util.Comparator;

public class ConeIdComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone c1, Cone c2) {
        return c1.getId().compareTo(c2.getId());
    }
}

