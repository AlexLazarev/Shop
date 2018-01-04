package alex.stud.daoTest;

import alex.stud.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> getAllByIdCustomer(int id);
}
