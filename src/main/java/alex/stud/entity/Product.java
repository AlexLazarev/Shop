package alex.stud.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "JpaProduct")
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int price;

    @OneToMany(mappedBy = "product") //Одна вещь может находиться во многих заказах
    private List<ProductInOrder> productInOrders;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ProductInOrder> getProductInOrders() {
        return productInOrders;
    }

    public void setProductInOrders(List<ProductInOrder> productInOrders) {
        this.productInOrders = productInOrders;
    }
}
