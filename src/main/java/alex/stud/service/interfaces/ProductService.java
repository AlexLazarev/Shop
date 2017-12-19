package alex.stud.service.interfaces;

import alex.stud.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    void save(Product product);
    Product getById(int id);
    void update(Product product);
    void deleteById(int id);

}
