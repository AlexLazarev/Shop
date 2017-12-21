package alex.stud.service;

import alex.stud.dao.interfaces.ProductInOrderDao;
import alex.stud.entity.Product;
import alex.stud.entity.ProductInOrder;
import alex.stud.entity.ShoppingCart;
import alex.stud.service.interfaces.CustomerService;
import alex.stud.service.interfaces.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Scope("session")
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCart shoppingCart;

    @Autowired
    private ProductInOrderDao productInOrderDao;

    public void addProduct(Product product) {
        shoppingCart.addProduct(product);
    }


    public List<Product> getAllProducts() {
        return shoppingCart.getAllProducts();
    }

    public int getResultPrice() {
        int sum = 0;
        for (Product product: shoppingCart.getAllProducts()) {
            sum += product.getPrice();
        }
        return sum;
    }

    public void createProductInOrder() {
        ProductInOrder productInOrder = new ProductInOrder();
        productInOrder.setIdProduct(1); ///TEST
        Map<Product,Integer> map = shoppingCart.getProducts();
        for (Map.Entry<Product,Integer>  entry : map.entrySet()) {
            productInOrder.setIdProduct(entry.getKey().getId());
            productInOrder.setQuantity(entry.getValue());
        }
        productInOrderDao.save(productInOrder);
    }

    public void setCustomerId(){

    }
}
