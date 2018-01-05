package alex.stud.controller;

import alex.stud.entity.User;
import alex.stud.entity.OrderCustomer;
import alex.stud.service.interfaces.*;
import alex.stud.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ShoppingCartService shoppingCart;


    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("shoppingCart", shoppingCart.getProducts());
        model.addAttribute("user",new User());
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute User user, BindingResult bindingResult,Model model){
        userValidator.validate(user,bindingResult);
        if(bindingResult.hasErrors()){
            return "register";
        }
        userService.save(user);
        securityService.autoLogin(user.getUsername(),user.getConfirmPassword());

        return "redirect:/main";
    }

    @GetMapping("/login")
    public String login(Model model,String error, String logout){
        if(error != null){
            model.addAttribute("error", "Incorrect");
        }
        if(logout != null){
            model.addAttribute("message","Successful");
        }
        return "login";
    }


    @GetMapping(value = {"/","/main"})
    public String start(Model model){
        model.addAttribute("shoppingCart", shoppingCart.getProducts());
        return "main";
    }


    @GetMapping("/selected/{id}")
    public String selectedID(@PathVariable("id") int id, Model model){
        model.addAttribute("product",productService.getById(id));
        model.addAttribute("shoppingCart", shoppingCart.getProducts());
        model.addAttribute("sum",shoppingCart.getResultPrice());
        return "selected";
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


    @GetMapping("/checkout")
    public String checkout(Model model){
        model.addAttribute("shoppingCart", shoppingCart.getProductsWithQuantity());
        model.addAttribute("sum",shoppingCart.getResultPrice());
        return  "checkout";
    }

    @PostMapping("/makeOrder")
    public String makeOrder(@ModelAttribute("")OrderCustomer orderCustomer){
        userService.save(orderCustomer.getCustomer());
        //orderService.save(orderCustomer.getOrder());
        orderService.completeOrder(orderCustomer.getOrder());
        return "redirect:/main";
    }
}
