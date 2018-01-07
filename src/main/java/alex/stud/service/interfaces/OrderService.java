package alex.stud.service.interfaces;

import alex.stud.entity.Order;
import alex.stud.entity.Product;
import alex.stud.entity.ProductInOrder;

import java.util.List;

public interface OrderService {

    void save(Order order);
    void deleteById(int id);
    void setStatus(int id, String status);
    boolean completeOrder(Order order);
    List<Order> getAllByIdUser(int id);
    List<Order> getAll();
    List<ProductInOrder> getAllProductInOrder();
}
