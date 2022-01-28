package restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.repositories.interfaces.BeverageRepository;

import java.util.ArrayList;
import java.util.Collection;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {
    private Collection<Beverages> models;

    public BeverageRepositoryImpl() {
        models = new ArrayList<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return models.stream().filter((beverage) -> beverage.getName().equals(drinkName) &&
                beverage.getBrand().equals(drinkBrand)).findFirst().orElse(null);
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return this.models;
    }

    @Override
    public void add(Beverages entity) {
        models.add(entity);
    }
}
