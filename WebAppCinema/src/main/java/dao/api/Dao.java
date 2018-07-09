package dao.api;




import model.Entity;

import java.util.List;


public interface Dao<K, T extends Entity<K>> {

    List<T> getAll();

    T getById(K key);

    void save(T entity);

    void delete(K key);

    void update(T entity);

    T getBy(String fieldName, String value);
     List<T> getByInt(String fieldName, int value, String className);

}
