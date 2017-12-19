package alex.stud.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

public interface ShoppingCart {

    public int getIdUser();

    public void setIdUser(int idUser);

    public List<Product> getAllProducts();

    public void addProduct(Product product);
}
