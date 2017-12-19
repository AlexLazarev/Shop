package alex.stud.service;

import alex.stud.dao.interfaces.OrderDao;
import alex.stud.dao.interfaces.ProductDao;
import alex.stud.entity.Order;
import alex.stud.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import alex.stud.service.interfaces.OrderService;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    //Productservice
    @Autowired
    private ProductDao product;

    @Autowired
    private OrderDao orderDao;

    public void save(Order order) {
        orderDao.save(order);
    }

    public void deleteById(int id) {
        orderDao.deleteById(id);
    }

    public List<Product> getProductsInOrder(int id){
        return product.getProductByIdOrder(id);
    }
}
