package alex.stud.service;

import alex.stud.entity.Product;
import alex.stud.entity.ShoppingCart;
import alex.stud.service.interfaces.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCart shoppingCart;

    public void addProduct(Product product,int quantity) {
        shoppingCart.addProduct(product,quantity);
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        for (Map.Entry<Product,Integer> entry : shoppingCart.getAllProducts().entrySet()) {
            products.add(entry.getKey());
        }
        return products;
    }

    public int getResultPrice() {
        int sum = 0;
        for (Map.Entry<Product,Integer> entry : shoppingCart.getAllProducts().entrySet()) {
            sum += entry.getKey().getPrice();
        }
        return sum;
    }

    public Map<Product,Integer> getProductsWithQuantity(){
        return shoppingCart.getAllProducts();
    }


}
