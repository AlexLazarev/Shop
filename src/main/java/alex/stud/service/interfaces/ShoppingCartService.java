package alex.stud.service.interfaces;

import alex.stud.entity.Product;

import java.util.List;

public interface ShoppingCartService {
    void addProduct(Product product);
    List<Product> getAllProducts();
}
