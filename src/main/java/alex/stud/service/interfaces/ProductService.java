package alex.stud.service.interfaces;

import alex.stud.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    void save(Product product);
    Product getProduct(int id);
    void update(Product product);
    void delete(int id);
    void rate(Product product, int mark);
    float getRating(int id);

}
