package lt.esdc.shapes.warehouse;

import lt.esdc.shapes.entity.Cone;
import lt.esdc.shapes.observer.ConeObserver;
import lt.esdc.shapes.service.ConeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Warehouse implements ConeObserver {
    private static final Logger logger = LoggerFactory.getLogger(Warehouse.class);
    private static final Warehouse instance = new Warehouse();

    private final Map<String, ConeParameters> parametersMap = new HashMap<>();
    private final ConeService service = new ConeService();

    private Warehouse() {}

    public static Warehouse getInstance() {
        return instance;
    }

    public void update(String id, Cone cone) {
        double volume = service.calculateVolume(cone);
        double surfaceArea = service.calculateSurfaceArea(cone);
        ConeParameters parameters = new ConeParameters(volume, surfaceArea);
        parametersMap.put(id, parameters);
        logger.info("Warehouse обновлён: {} -> {}", id, parameters);
    }

    public ConeParameters get(String id) {
        return parametersMap.get(id);
    }

    public Map<String, ConeParameters> getAll() {
        return Collections.unmodifiableMap(parametersMap);
    }

    public void remove(String id) {
        parametersMap.remove(id);
        logger.info("Удалены параметры конуса из Warehouse: {}", id);
    }


    @Override
    public void onConeChanged(Cone cone) {
        update(cone.getId(), cone);
        logger.info("Обновлены параметры конуса после изменения: {}", cone.getId());
    }
}
