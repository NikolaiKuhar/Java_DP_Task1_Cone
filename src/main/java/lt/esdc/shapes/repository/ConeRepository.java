package lt.esdc.shapes.repository;

import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.specification.Specification;

import java.util.List;
import java.util.Optional;

public interface ConeRepository {
    void add(Cone cone);
    boolean remove(Cone cone);
    boolean removeById(String id);
    Optional<Cone> findById(String id);
    List<Cone> findAll();
    List<Cone> query(Specification specification);
    void clear();
}
