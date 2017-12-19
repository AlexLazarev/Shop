package alex.stud.dao;

import alex.stud.dao.interfaces.OrderDao;
import alex.stud.entity.Order;
import alex.stud.entity.Product;
import alex.stud.mapper.OrderMapper;
import alex.stud.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired //объект описан ранее
    public JdbcTemplate jdbcTemplate;

    public List<Order> getAll() {
        return null;
    }

    public void save(Order order) {
        String sql = "INSERT INTO Orders (id_customer) VALUES (?)";
        jdbcTemplate.update(sql, order.getIdCustomer());
    }

    public Order getById(int id){
        String sql = "SELECT* FROM Orders WHERE id=?";
        return jdbcTemplate.queryForObject(sql,new OrderMapper(), id);
    }

    public void update(Order customer) {

    }



    public void deleteById(int id) {
        String sql = "DELETE FROM Orders WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }
}
