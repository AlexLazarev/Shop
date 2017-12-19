package alex.stud.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("session")
public class ShoppingCartImpl implements ShoppingCart {
    private int idUser;
    private List<Product> products = new ArrayList<>();

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public void addProduct(Product product){
        products.add(product);
    }

}
