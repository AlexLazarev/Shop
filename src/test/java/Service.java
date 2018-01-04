import alex.stud.config.SpringConfig;
import alex.stud.entity.Product;
import alex.stud.service.interfaces.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class Service {

    @Autowired
    private ProductService productService;

    @Test
    public void productService() {
        List<Product> products = productService.getAll();
        for (Product product : products) {
            System.out.println(product.toString());
        }
        System.out.println("Happy new year");
    }
}
