package alex.stud.service;

import alex.stud.dao.interfaces.CustomerDao;
import alex.stud.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    public CustomerDao customerDao;

    public List<Customer> getAll() {
        return customerDao.getAll();
    }

    public void save(Customer customer) {
        if (customer.getFirstName().length() < 2) {
            //TODO exeception
        }

        customerDao.save(customer);
    }

    public Customer getById(int id) {
        return customerDao.getById(id);
    }

    public void update(Customer customer) {
        customerDao.update(customer);
    }

    public void deleteById(int id) {
        customerDao.deleteById(id);
    }

}
