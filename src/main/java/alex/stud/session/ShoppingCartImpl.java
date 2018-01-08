package alex.stud.session;

import alex.stud.entity.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//ну явно не так)0
@Component
public class ShoppingCartImpl implements ShoppingCart {
    private int idUser; // не нужен

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

    public void deleteProduct(int id) {
        HashMap<Product, Integer> copy = new HashMap<Product, Integer>(products);
        for (Map.Entry<Product, Integer> entry: copy.entrySet())
        {
            if (entry.getKey().getId() == id) {
                products.remove(entry.getKey());
                break;
            }
        }
    }

}
