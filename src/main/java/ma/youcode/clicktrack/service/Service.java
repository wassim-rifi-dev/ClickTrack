package ma.youcode.clicktrack.service;

import java.util.List;

public interface Service<T> {
    T create(T t);

    List<T> getAll();

    T getById(Long id);
}
