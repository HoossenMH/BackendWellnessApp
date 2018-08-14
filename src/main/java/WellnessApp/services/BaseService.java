package WellnessApp.services;

import java.util.List;
import java.util.Set;

/**
 * Created by caniksea on 8/14/17.
 */
public interface BaseService<E, ID> {
    E create(E entity);

    E readById(ID id);

    Set<E> readAll();

    Iterable<E> readAllList();

    E update(E entity);

    void delete(E entity);
}
