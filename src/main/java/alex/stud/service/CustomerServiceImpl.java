package alex.stud.service;

import alex.stud.daoTest.CustomerRepository;
import alex.stud.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import alex.stud.service.interfaces.CustomerService;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public void save(Customer customer) {
        if (customer.getFirstName().length() < 2) {
            //TODO exeception
        }

        customerRepository.save(customer);
    }

    public Customer getById(int id) {
        return customerRepository.getOne(id);
    }

    public void update(Customer customer) {
        //customerRepository.update(customer);
    }

    public void deleteById(int id) {
        customerRepository.delete(id);
    }

}
