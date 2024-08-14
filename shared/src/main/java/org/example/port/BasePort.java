package org.example.port;


import java.util.List;

public interface BasePort<T, ID> {
    List<T> getAll();
    T getById(ID id);
    T save(T entity);
    T update(ID id, T entity);
    void delete(ID id);
}