package alex.stud.dao;

import alex.stud.dao.interfaces.ProductDao;
import alex.stud.entity.Product;
import alex.stud.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{

    @Autowired //объект описан ранее
    public JdbcTemplate jdbcTemplate;


    public void save(Product entity) {
        String sql = "INSERT INTO Product (name,price) VALUES (?,?)";
        jdbcTemplate.update(sql,entity.getName(),entity.getPrice());
    }

    public Product getById(int id) {
        String sql = "SELECT* FROM Product WHERE id=?";
        return jdbcTemplate.queryForObject(sql,new ProductMapper(), id);
    }

    public List<Product> getAll() {
        String sql = "Select* From Product";
        return jdbcTemplate.query(sql,new ProductMapper());
    }


    public void update(Product entity) {
        String sql = ("UPDATE Product SET name=?, price=? WHERE id=?");
        jdbcTemplate.update(sql,entity.getName(),entity.getPrice(),entity.getId());
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM Product WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }


    public List<Product> getProductByIdOrder(int id) {
        String sql = "Select* From Product INNER JOIN (SELECT id_product From ShoppingCart WHERE id_order=?)AS T ON Product.id = id_product";
        return jdbcTemplate.query(sql,new ProductMapper(),id);
    }

}
