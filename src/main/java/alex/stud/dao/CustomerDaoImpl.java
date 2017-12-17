package alex.stud.dao;

import alex.stud.entity.Customer;
import alex.stud.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired //объект описан ранее
    public JdbcTemplate jdbcTemplate;


    public List<Customer> findAll() {
        String sql = "Select* From Customer";

        return jdbcTemplate.query(sql,new CustomerMapper());
    }

    public void save(Customer customer) {
        String sql = "INSERT INTO Customer (id,firstName,email) VALUE (?,?,?)";
        jdbcTemplate.update(sql,customer.getId(),customer.getFirstName(),customer.getEmail());
    }

    public Customer getById(int id){
        String sql = "SELECT* FROM Customer WHERE id=?";
        return jdbcTemplate.queryForObject(sql,new CustomerMapper(), id);
    }

    public void update(Customer customer) {
        String sql = ("UPDATE Customer SET firstName=?, email=? WHERE id=?");
        jdbcTemplate.update(sql,customer.getFirstName(),customer.getEmail(),customer.getId());
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM Customer WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }
}
