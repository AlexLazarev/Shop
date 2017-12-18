package alex.stud.dao.interfaces;

import java.util.List;

public interface IDAO<T> {

    List<T> getAll();
    void save(T entity);
    T getById(int id);
    void update(T entity);
    void deleteById(int id);


}
