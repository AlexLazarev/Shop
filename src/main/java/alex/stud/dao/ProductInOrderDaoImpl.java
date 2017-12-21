package alex.stud.dao;

import alex.stud.dao.interfaces.ProductInOrderDao;
import alex.stud.entity.Product;
import alex.stud.entity.ProductInOrder;
import alex.stud.mapper.ProductInOrderMapper;
import alex.stud.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductInOrderDaoImpl implements ProductInOrderDao{

    @Autowired //объект описан ранее
    public JdbcTemplate jdbcTemplate;

    public List<ProductInOrder> getAll() {
        String sql = "Select* From ProductInOrder";
        return jdbcTemplate.query(sql,new ProductInOrderMapper());
    }


    public List<Product> getProductByIdOrder(int id) {
        String sql = "Select* From Product INNER JOIN (SELECT id_product From ShoppingCart WHERE id_order=?)AS T ON Product.id = id_product";
        return jdbcTemplate.query(sql,new ProductMapper(),id);
    }

    public void save(ProductInOrder entity) {
        String sql = "INSERT INTO Product (name,price) VALUES (?,?)";
        jdbcTemplate.update(sql,entity.getIdOrder(),entity.getIdProduct(),entity.getQuantity());
    }

    public ProductInOrder getById(int id) {
        return null;
    }

    public void update(ProductInOrder entity) {

    }

    public void deleteById(int id) {

    }
}
