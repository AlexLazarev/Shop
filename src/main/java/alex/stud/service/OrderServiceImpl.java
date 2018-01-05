package alex.stud.service;

import alex.stud.dao.OrderRepository;
import alex.stud.dao.ProductInOrderRepository;
import alex.stud.entity.Order;
import alex.stud.entity.Product;
import alex.stud.entity.ProductInOrder;
import alex.stud.entity.ShoppingCart;
import alex.stud.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductInOrderRepository productInOrderRepository;

    @Autowired
    private ShoppingCart shoppingCart;

    public void save(Order order) {
        orderRepository.save(order);
    }

    public void deleteById(int id) {
        orderRepository.delete(id);
    }

    public boolean completeOrder(Order order) {
        orderRepository.save(order);

        for (Map.Entry<Product, Integer> entry : shoppingCart.getAllProducts().entrySet()) {
            ProductInOrder productInOrder = new ProductInOrder();
            productInOrder.setProduct(entry.getKey());
            productInOrder.setOrder(order);
            productInOrder.setQuantity(entry.getValue());
            productInOrderRepository.save(productInOrder);
        }
        return true;
    }

    @Override
    public List<Order> getAllByIdUser(int id) {
       return orderRepository.getAllByIdUser(id);
    }

    @Override
    public List<Order> getAll() {
        return  orderRepository.findAll();
    }

}
