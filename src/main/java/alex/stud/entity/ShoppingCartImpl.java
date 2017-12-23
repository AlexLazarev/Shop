package alex.stud.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ShoppingCartImpl implements ShoppingCart {
    private int idUser;

    private Map products = new HashMap<Product,Integer>();


    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Map<Product,Integer> getAllProducts(){
        return products;
    }

    public void addProduct(Product product,int quanity){
        products.put(product,quanity);
    }

}
