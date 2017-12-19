package alex.stud.service;

import alex.stud.entity.Product;
import alex.stud.entity.ShoppingCart;
import alex.stud.service.interfaces.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("session")
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCart shoppingCart;

    public void addProduct(Product product) {
        shoppingCart.addProduct(product);
    }


    public List<Product> getAllProducts() {
        return shoppingCart.getAllProducts();
    }
}
