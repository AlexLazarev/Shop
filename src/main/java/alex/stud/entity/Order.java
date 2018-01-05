package alex.stud.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MyOrder")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int idUser;
    private String city;
    private String delivery;
    private String payment;


    //fetch - get
    //to load it together with the rest of the fields (i.e. eagerly) or
    //to load it on-demand (i.e. lazily) when you call the product's getProduct() method.
    //DEFAULT - LAZY
    @OneToMany(mappedBy = "order")
    private List<ProductInOrder> productInOrders;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public List<ProductInOrder> getProductInOrders() {
        return productInOrders;
    }

    public void setProductInOrders(List<ProductInOrder> productInOrders) {
        this.productInOrders = productInOrders;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
