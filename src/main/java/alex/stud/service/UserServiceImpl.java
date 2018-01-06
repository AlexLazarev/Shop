package alex.stud.service;

import alex.stud.dao.RoleRepository;
import alex.stud.dao.UserRepository;
import alex.stud.entity.Role;
import alex.stud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import alex.stud.service.interfaces.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;


    //@Transactional
    // Перед исполнением метода помеченного данной аннотацией начинается транзакция,
    // после выполнения метода транзакция коммитится, при выбрасывании RuntimeException откатывается.

    @Transactional
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.getOne(2));
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Transactional
    @Override
    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Transactional
    public User getById(int id) {
        return userRepository.getOne(id);
    }

    public void update(User user) {
        //userRepository.update(user);
    }

    @Transactional
    public void deleteById(int id) {
        userRepository.delete(id);
    }

    @Transactional
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
