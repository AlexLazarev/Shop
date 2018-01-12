package alex.stud.service;

import alex.stud.dao.ProductRepository;
import alex.stud.dao.RatingRepository;
import alex.stud.dao.UserRepository;
import alex.stud.entity.Product;
import alex.stud.entity.Rating;
import alex.stud.service.interfaces.ProductService;
import alex.stud.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;





@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private UserRepository userRepository;

   public List<Product> getAll() {
        return productRepository.findAll();
    }
    public void save(Product product) {
        productRepository.save(product);
    }

    public Product getProduct(int id) {
        return productRepository.findOne(id);
    }

    public void update(Product product) {
        //productRepository.(product);
    }

    public void delete(int id) {
        productRepository.delete(id);
    }

    public void rate(Product product, int mark) {
       Rating rating = new Rating();
       rating.setMark(mark);
       rating.setUser(userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
       rating.setProduct(product);
       ratingRepository.save(rating);
    }

    @Override
    public float getRating(int id) {
        List<Rating> ratings = ratingRepository.findAllByProduct(productRepository.findOne(id));
        if (ratings.size() == 0) {
            return 0;
        }

        float sum = 0;
        for (Rating rating : ratings) {
            sum += rating.getMark();
        }
        System.out.println(sum);
        return sum/ratings.size();
    }


}
