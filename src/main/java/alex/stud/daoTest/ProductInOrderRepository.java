package alex.stud.daoTest;

import alex.stud.entity.ProductInOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInOrderRepository extends JpaRepository<ProductInOrder,Integer> {

}
