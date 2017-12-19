package alex.stud.mapper;

import alex.stud.entity.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

    public class OrderMapper implements RowMapper<Order> {

        public Order mapRow(ResultSet resultSet, int i)throws SQLException {
                Order order=new Order();
                order.setId(resultSet.getInt("id"));
                order.setIdCustomer(resultSet.getInt("id_customer"));
                return order;
                }
    }