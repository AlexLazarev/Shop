package alex.stud.service.interfaces;


import alex.stud.entity.User;

import java.util.List;


public interface UserService {
    List<User> getAll();
    void save(User user);
    User findByUsername(String name);
    User getCurrentUser();
    User getById(int id);
    void update(User user);
    void deleteById(int id);

}
