package com.gurinov.hrapp.service;

import java.util.List;

public interface EntityService<I, E> {
    List<E> findAll();
    E findById(int id);
    void create(I obj);
    void delete(int id);
    E update(I obj);
}
