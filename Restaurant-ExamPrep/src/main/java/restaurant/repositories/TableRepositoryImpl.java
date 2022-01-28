package restaurant.repositories;

import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;

public class TableRepositoryImpl implements TableRepository<Table> {
    private Collection<Table> models;

    public TableRepositoryImpl() {
        models = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAllEntities() {
        return this.models;
    }

    @Override
    public void add(Table entity) {
        models.add(entity);
    }

    @Override
    public Table byNumber(int number) {
        return models.stream().filter((table) -> table.getTableNumber() == number).findFirst().orElse(null);
    }
}
