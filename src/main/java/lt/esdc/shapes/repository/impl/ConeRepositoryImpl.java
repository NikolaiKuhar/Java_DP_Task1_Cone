package lt.esdc.shapes.repository.impl;

import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.repository.ConeRepository;
import lt.esdc.shapes.specification.Specification;

import java.util.*;
import java.util.stream.Collectors;

public class ConeRepositoryImpl implements ConeRepository {

    private final List<Cone> cones = new ArrayList<>();

    @Override
    public void add(Cone cone) {
        cones.add(cone);
    }

    @Override
    public boolean remove(Cone cone) {
        return cones.remove(cone);
    }

    @Override
    public boolean removeById(String id) {
        return cones.removeIf(cone -> cone.getId().equals(id));
    }

    @Override
    public Optional<Cone> findById(String id) {
        return cones.stream()
                .filter(cone -> cone.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Cone> findAll() {
        return Collections.unmodifiableList(cones);
    }

    @Override
    public List<Cone> query(Specification specification) {
        return cones.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
    }

    @Override
    public void clear() {
        cones.clear();
    }
}
