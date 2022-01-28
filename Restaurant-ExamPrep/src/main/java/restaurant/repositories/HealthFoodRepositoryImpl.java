package restaurant.repositories;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.repositories.interfaces.HealthFoodRepository;

import java.util.ArrayList;
import java.util.Collection;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood> {
    private Collection<HealthyFood> models;

    public HealthFoodRepositoryImpl() {
        models = new ArrayList<>();
    }

    @Override
    public HealthyFood foodByName(String name) {
        return models.stream().filter((food) -> food.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return this.models;
    }

    @Override
    public void add(HealthyFood entity) {
        models.add(entity);
    }
}
