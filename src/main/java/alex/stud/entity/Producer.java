package alex.stud.entity;

import javax.persistence.*;

@Entity
@Table(name = "Producer")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String number;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


}
