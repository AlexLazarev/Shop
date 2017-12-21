package alex.stud.entity;

import java.util.List;

public class Order {

    private int id;
    private int idCustomer;
    private String city;
    private String delivery;
    private String payment;

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
}
