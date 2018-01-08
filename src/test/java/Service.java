import alex.stud.config.SecurityConfig;
import alex.stud.config.SpringConfig;
import alex.stud.entity.Order;
import alex.stud.entity.Product;
import alex.stud.service.interfaces.OrderService;
import alex.stud.service.interfaces.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class, SecurityConfig.class})
public class Service {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Test
    public void testDate(){
        System.out.println(new Date() + "/n");
        System.out.println(Calendar.getInstance(TimeZone.getTimeZone("UTC")));

        Order order = new Order();
        order.setIdUser(1);
        orderService.save(order);
    }

    @Test
    public void testProductService() {
        List<Product> products = productService.getAll();
        for (Product product : products) {
            System.out.println(product.toString());
        }
        System.out.println("Happy new year");
    }

    @Test
    public void testOrderService(){
        orderService.setStatus(3,"LOL");
    }
}
