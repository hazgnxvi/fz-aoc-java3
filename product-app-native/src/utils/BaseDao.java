package utils;

import java.util.List;

public interface BaseDao<T, K> {
    // add
    void add(T data);

    // list
    List<T> findAll();

    // get data by id
    T findById(K id);

    // update data by id
    void updataById(K id, T data);

    // delete data by id
    void deleteById(K id);

    // size
    Integer size();
}
