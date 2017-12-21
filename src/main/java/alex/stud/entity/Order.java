package alex.stud.entity;

import javax.persistence.*;
import java.util.List;


public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int idCustomer;
    private String city;
    private String delivery;
    private String payment;

    //fetch - get
    //to load it together with the rest of the fields (i.e. eagerly) or
    //to load it on-demand (i.e. lazily) when you call the product's getProduct() method.
    //DEFAULT - LAZY
    @OneToMany(fetch = FetchType.LAZY)
    private List<ProductInOrder> productInOrders;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
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
}
