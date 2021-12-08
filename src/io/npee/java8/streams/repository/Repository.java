package io.npee.java8.streams.repository;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();
    T findById(Long id);
    T save(T entity);
    int deleteById(Long id);
}
