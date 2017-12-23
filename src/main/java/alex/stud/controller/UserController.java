package alex.stud.controller;

import alex.stud.daoTest.ProductRepository;
import alex.stud.entity.Customer;
import alex.stud.entity.Order;
import alex.stud.entity.OrderCustomer;
import alex.stud.entity.Product;
import alex.stud.service.interfaces.CustomerService;
import alex.stud.service.interfaces.OrderService;
import alex.stud.service.interfaces.ProductService;
import alex.stud.service.interfaces.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ShoppingCartService shoppingCart;


    @PostMapping("/register")
    public String addCustomer(@ModelAttribute Customer customer){ //@ModelAttribute("customer")
        customerService.save(customer);
        return "redirect:/main";
    }

    @GetMapping("/")
    public String start(){
        return "main";
    }

    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("shoppingCart", shoppingCart.getProducts());
        return "main";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin-panel";
    }

    @GetMapping("/selected/{id}")
    public String selectedID(@PathVariable("id") int id, Model model){
        model.addAttribute("product",productService.getById(id));
        model.addAttribute("shoppingCart", shoppingCart.getProducts());
        model.addAttribute("sum",shoppingCart.getResultPrice());
        return "selected";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("")Product product){ //@ModelAttribute("customer")
        productService.save(product);
        return "redirect:/admin";
    }

    @GetMapping("shop/{id}")
    public String getProductById(@PathVariable("id")int id, Model model){
        model.addAttribute("product",productService.getById(id));
        return "selected";
    }

    @PostMapping("/addToShoppingCart/{id}")
    public String addToShoppingCart(@PathVariable("id")int id){
        //TODO quantity without additional model
        shoppingCart.addProduct(productService.getById(id),2);
        return "redirect:/shop";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("products", productService.getAll());
        model.addAttribute("shoppingCart", shoppingCart.getProducts());
        model.addAttribute("sum",shoppingCart.getResultPrice());
        return "shop";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("shoppingCart", shoppingCart.getProducts());
        return "register";
    }

    @GetMapping("/checkout")
    public String checkout(Model model){
        model.addAttribute("shoppingCart", shoppingCart.getProductsWithQuantity());
        model.addAttribute("sum",shoppingCart.getResultPrice());
        return  "checkout";
    }

    @PostMapping("/makeOrder")
    public String makeOrder(@ModelAttribute("")OrderCustomer orderCustomer){
        customerService.save(orderCustomer.getCustomer());
        //orderService.save(orderCustomer.getOrder());
        orderService.completeOrder(orderCustomer.getOrder());
        return "redirect:/main";
    }
}
