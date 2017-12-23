package alex.stud.service.interfaces;

import alex.stud.entity.Order;
import alex.stud.entity.Product;

import java.util.List;

public interface OrderService {
    void save(Order order);
    void deleteById(int id);
    boolean completeOrder(Order order);
}
