package lt.esdc.shapes.service;

import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.observer.ConeObserver;
import lt.esdc.shapes.repository.ConeRepository;
import lt.esdc.shapes.warehouse.Warehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConeLifecycleService {
    private static final Logger logger = LoggerFactory.getLogger(ConeLifecycleService.class);

    private final ConeRepository repository;
    private final ConeObserver warehouse;

    public ConeLifecycleService(ConeRepository repository) {
        this.repository = repository;
        this.warehouse = Warehouse.getInstance();
    }

    public void register(Cone cone) {
        cone.addObserver(warehouse);
        warehouse.update(cone);
        repository.add(cone);
        logger.info("Cone registered: {}", cone.getId());
    }

    public void unregister(Cone cone) {
        cone.removeObserver(warehouse);
        repository.remove(cone);
        Warehouse.getInstance().remove(cone.getId());
        logger.info("Cone unregistered: {}", cone.getId());
    }
}
