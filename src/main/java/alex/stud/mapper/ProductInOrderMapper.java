package alex.stud.mapper;

import alex.stud.entity.ProductInOrder;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductInOrderMapper implements RowMapper<ProductInOrder> {

        public ProductInOrder mapRow(ResultSet resultSet, int i)throws SQLException {
        ProductInOrder productInOrder=new ProductInOrder();

        return productInOrder;
        }
}