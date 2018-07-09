package service.api;

import java.util.List;

public interface Service<K, T>{

    List<T> getAll();

    T getById(K id);

    void save(T entity);

    void delete(K key);

    void update(T entity);

}
