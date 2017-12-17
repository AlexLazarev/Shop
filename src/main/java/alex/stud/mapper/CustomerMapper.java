package alex.stud.mapper;

import alex.stud.entity.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {

    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
        Customer customer = new Customer();
        customer.setId(resultSet.getInt("id"));
        customer.setFirstName(resultSet.getString("firstName"));
        customer.setEmail(resultSet.getString("email"));
        return customer;
    }
}
