package alex.stud.service.interfaces;


import alex.stud.entity.Customer;

import java.util.List;


public interface CustomerService {
    List<Customer> getAll();
    void save(Customer customer);
    Customer getById(int id);
    void update(Customer customer);
    void deleteById(int id);

}
