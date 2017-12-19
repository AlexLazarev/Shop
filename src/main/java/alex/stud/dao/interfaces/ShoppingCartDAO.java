package alex.stud.dao.interfaces;

import alex.stud.entity.Product;

import java.util.List;

public interface ShoppingCartDAO {
    public List<Product> getAllProducts();
    public void addProduct(Product product);
}
