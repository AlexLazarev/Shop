package alex.stud.dao.interfaces;

import alex.stud.entity.Product;
import alex.stud.entity.ProductInOrder;

import java.util.List;

public interface ProductInOrderDao extends IDAO<ProductInOrder> {
    List<Product> getProductByIdOrder(int id);
}
