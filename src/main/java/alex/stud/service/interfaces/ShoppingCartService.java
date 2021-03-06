package alex.stud.service.interfaces;

import alex.stud.entity.Product;

import java.util.List;
import java.util.Map;

public interface ShoppingCartService {
    void addProduct(Product product,int quantity);
    void deleteProduct(int id);
    List<Product> getProducts();
    Map<Product,Integer> getProductsWithQuantity();
    int getResultPrice();
}
