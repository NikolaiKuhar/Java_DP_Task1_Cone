package lt.esdc.shapes.repository;

import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.specification.Specification;

import java.util.*;
import java.util.stream.Collectors;

public class ConeRepository {

    private static final ConeRepository instance = new ConeRepository();
    private final List<Cone> cones = new ArrayList<>();

    private ConeRepository() {}

    public static ConeRepository getInstance() {
        return instance;
    }

    public void add(Cone cone) {
        cones.add(cone);
    }

    public boolean remove(Cone cone) {
        return cones.remove(cone);
    }

    public boolean removeById(String id) {
        return cones.removeIf(cone -> cone.getName().equals(id));
    }

    public Optional<Cone> findById(String id) {
        return cones.stream()
                .filter(cone -> cone.getName().equals(id))
                .findFirst();
    }

    public List<Cone> findAll() {
        return Collections.unmodifiableList(cones);
    }

    public List<Cone> query(Specification specification) {
        return cones.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
    }

    public static class ByIdComparator implements Comparator<Cone> {
        @Override
        public int compare(Cone c1, Cone c2) {
            return c1.getName().compareTo(c2.getName());
        }
    }

    public static class ByRadiusComparator implements Comparator<Cone> {
        @Override
        public int compare(Cone c1, Cone c2) {
            return Double.compare(c1.getRadius(), c2.getRadius());
        }
    }

    public static class ByHeightComparator implements Comparator<Cone> {
        @Override
        public int compare(Cone c1, Cone c2) {
            return Double.compare(c1.getHeight(), c2.getHeight());
        }
    }

    public static class ByXCoordinateComparator implements Comparator<Cone> {
        @Override
        public int compare(Cone c1, Cone c2) {
            return Double.compare(c1.getBaseCenter().getX(), c2.getBaseCenter().getX());
        }
    }
}
