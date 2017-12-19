package alex.stud.dao.interfaces;

import alex.stud.entity.Product;

import java.util.List;

public interface ProductDao extends IDAO<Product> {
    List<Product> getProductByIdOrder(int id);
}
