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

    public void put(String id, Cone cone) {
        double volume = service.calculateVolume(cone);
        double surfaceArea = service.calculateSurfaceArea(cone);
        parametersMap.put(id, new ConeParameters(volume, surfaceArea));
        logger.info("Warehouse обновлён: {} -> {}", id, parametersMap.get(id));
    }

    public ConeParameters get(String id) {
        return parametersMap.get(id);
    }

    public Map<String, ConeParameters> getAll() {
        return Collections.unmodifiableMap(parametersMap);
    }

    @Override
    public void onConeChanged(Cone cone) {
        put(cone.getName(), cone);
        logger.info("Обновлены параметры конуса после изменения: {}", cone.getName());
    }
} 
