package alex.stud.controller;

import alex.stud.entity.Customer;
import alex.stud.entity.Product;
import alex.stud.entity.ShoppingCart;
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
@Scope("session")
public class UserController {

    @Autowired
    public CustomerService customerService;

    @Autowired
    public ProductService productService;

    @Autowired
    public OrderService orderService;

    @Autowired
    public ShoppingCartService shoppingCart;

    @GetMapping("/customers")
    public String getAllUsers(Model model){
        model.addAttribute("customers",customerService.getAll());
        return "customers";
    }

    @GetMapping("customer/{id}")
    public String getById(@PathVariable("id")int id, Model model){
        model.addAttribute("customer",customerService.getById(id));
        return "showCustomer";
    }

    //true request
    ///////////


    @PostMapping("/register")
    public String addCustomer(@ModelAttribute("")Customer customer){ //@ModelAttribute("customer")
        customerService.save(customer);
        return "redirect:/main";
    }

    @GetMapping("/")
    public String start(){
        return "main";
    }

    @GetMapping("/main")
    public String main(){
        return "main";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin-panel";
    }

    @GetMapping("/selected/{id}")
    public String selectedID(@PathVariable("id") int id, Model model){
        model.addAttribute("product",productService.getById(id));
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
        shoppingCart.addProduct(productService.getById(id));
        return "redirect:/shop";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("products", productService.getAll());
        model.addAttribute("shoppingCart", shoppingCart.getAllProducts());
        return "shop";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/selected")
    public String selected(){
        return "selected";
    }


    //////////////

    @GetMapping("/addCustomer")
    public String createCustomer(){
        return "createCustomer";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") int id){
        customerService.deleteById(id);
        return "redirect:/customers";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("customer",customerService.getById(id));
        return "editCustomer";
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute("customer")Customer customer){
        customerService.update(customer);
        return "redirect:/customer/" + customer.getId();
    }
}
