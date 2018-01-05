package alex.stud.dao;

import alex.stud.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> getAllByIdUser(int id);
}
