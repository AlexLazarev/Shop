package alex.stud.entity;

public class OrderCustomer {
    private int idCustomer;
    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private String delivery;
    private String payment;

    public Order getOrder(){
        Order order = new Order();
        order.setIdCustomer(getIdCustomer());
        order.setCity(city);
        order.setDelivery(delivery);
        order.setPayment(payment);
        return order;
    }


    public Customer getCustomer(){
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setlastName(lastName);
        customer.setEmail(email);
        return customer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
