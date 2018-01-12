package alex.stud.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Supply")
public class Supply {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Producer producer;

    @Temporal(TemporalType.DATE)
    private Date date;

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Supply{" +
                "id=" + id +
                ", producer=" + producer +
                ", date=" + date +
                '}';

    }

    public void setDate(Date date) {
        this.date = date;
    }
}
