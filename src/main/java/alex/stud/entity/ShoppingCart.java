package alex.stud.entity;

import java.util.List;
import java.util.Map;

public interface ShoppingCart {

    public int getIdUser();

    public void setIdUser(int idUser);

    public Map<Product,Integer> getAllProducts();

    public void addProduct(Product product,int quantity);
}
