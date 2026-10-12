package ma.youcode.clicktrack.repository;

import java.util.List;

public interface Repository<T> {
    boolean save(T t);

    List<T> findAll();

    T findById(Long id);
}
