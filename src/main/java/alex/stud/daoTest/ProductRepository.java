package alex.stud.daoTest;

import alex.stud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByNameLike(String name);


}

// @Query(name = "SELECT * FROM Product p where p.name Like :xyz",nativeQuery = true)
// List<Product> findMyProducts(@Param("xyz") String name);