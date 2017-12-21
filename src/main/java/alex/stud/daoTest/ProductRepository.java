package alex.stud.daoTest;

import alex.stud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    Product findById(int id);

    List<Product> findByNameLike(String name);

}