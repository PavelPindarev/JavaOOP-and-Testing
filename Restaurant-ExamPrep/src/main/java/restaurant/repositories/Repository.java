package restaurant.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Repository<T> implements restaurant.repositories.interfaces.Repository {
    private Collection<T> entities;

    public Repository() {
        this.entities = new ArrayList<>();
    }

    @Override
    public Collection getAllEntities() {
        return Collections.unmodifiableCollection(this.entities);
    }

    @Override
    public void add(Object entity) {
        this.entities.add((T) entity);
    }
}
