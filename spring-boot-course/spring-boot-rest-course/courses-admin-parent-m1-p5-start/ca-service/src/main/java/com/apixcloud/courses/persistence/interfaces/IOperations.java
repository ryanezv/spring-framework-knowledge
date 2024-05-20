package com.apixcloud.courses.persistence.interfaces;

import java.io.Serializable;
import java.util.List;

public interface IOperations<T extends Serializable> {

    List<T> findAll();

    T create(final T resource);

    void update(final T resource);

    void delete(final long id);
}
