package alex.stud.session;

import alex.stud.entity.Product;

import java.util.Map;

public interface ShoppingCart {

    public int getIdUser();

    public void setIdUser(int idUser);

    public Map<Product,Integer> getAllProducts();

    public void addProduct(Product product,int quantity);
    public void deleteProduct(int id);
}
