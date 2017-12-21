package alex.stud.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope("session")
public class ShoppingCartImpl implements ShoppingCart {
    private int idUser;
    private List<Product> products = new ArrayList<>();

    private Map prod = new HashMap<Product,Integer>();


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

    @Override
    public Map<Product, Integer> getProducts() {
        return prod;
    }


}
