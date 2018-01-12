package alex.stud.dao;

import alex.stud.entity.Product;
import alex.stud.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,Integer>{
    List<Rating> findAllByProduct(Product product);
}
