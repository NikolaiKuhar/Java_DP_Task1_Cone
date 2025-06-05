package lt.esdc.shapes.service;

import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.observer.ConeObserver;
import lt.esdc.shapes.repository.ConeRepository;
import lt.esdc.shapes.warehouse.Warehouse;

public class ConeLifecycleService {

    private final ConeRepository repository;
    private final ConeObserver warehouse = Warehouse.getInstance();

    public ConeLifecycleService(ConeRepository repository) {
        this.repository = repository;
    }

    public void register(Cone cone) {
        cone.addObserver(warehouse);
        Warehouse.getInstance().update(cone.getId(), cone);
        repository.add(cone);
    }

    public void unregister(Cone cone) {
        cone.removeObserver(warehouse);
        repository.remove(cone);
        Warehouse.getInstance().remove(cone.getId());
    }
}
