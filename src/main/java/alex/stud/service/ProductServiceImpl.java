package alex.stud.service;

import alex.stud.dao.interfaces.CustomerDao;
import alex.stud.dao.interfaces.ProductDao;
import alex.stud.entity.Customer;
import alex.stud.entity.Product;
import alex.stud.entity.ShoppingCart;
import alex.stud.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

   public List<Product> getAll() {
        return productDao.getAll();
    }

    public void save(Product product) {
        productDao.save(product);
    }

    public Product getById(int id) {
        return productDao.getById(id);
    }

    public void update(Product product) {
        productDao.update(product);
    }

    public void deleteById(int id) {
        productDao.deleteById(id);
    }



}
