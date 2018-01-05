package alex.stud.service;

import alex.stud.dao.ProductRepository;
import alex.stud.entity.Product;
import alex.stud.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;





@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


   public List<Product> getAll() {
        return productRepository.findAll();
    }
    public void save(Product product) {
        productRepository.save(product);
    }

    public Product getById(int id) {
        return productRepository.findOne(id);
    }

    public void update(Product product) {
        //productRepository.(product);
    }

    public void deleteById(int id) {
        productRepository.delete(id);
    }



}
