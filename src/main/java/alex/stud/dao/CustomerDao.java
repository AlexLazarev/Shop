package alex.stud.dao;

import alex.stud.entity.Customer;

import java.util.List;

//dataAcessObject
public interface CustomerDao {
    List<Customer> findAll();
    void save(Customer customer);
    Customer getById(int id);
    void update(Customer customer);
    void deleteById(int id);
}
