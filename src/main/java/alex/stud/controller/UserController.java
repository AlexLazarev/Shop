package alex.stud.controller;

import alex.stud.entity.Order;
import alex.stud.entity.User;
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
    public String addUser(@ModelAttribute("user") User user, BindingResult bindingResult){
        userValidator.validate(user,bindingResult);
        if(bindingResult.hasErrors()){
            return "register";
        }
        userService.save(user);
        securityService.autoLogin(user.getUsername(),user.getConfirmPassword());

        return "redirect:main";
    }

    @GetMapping("/login")
    public String login(Model model,String error){
        if(error != null){
            model.addAttribute("error", "Username or password is incorrect.");
        }
        return "login";
    }


    @GetMapping(value = {"/","/main"})
    public String start(Model model){
        model.addAttribute("shoppingCart", shoppingCart.getProductsWithQuantity());
        model.addAttribute("sum",shoppingCart.getResultPrice());
        return "user/main";
    }

    @GetMapping("/error_page")
    public String error(){
        return "errorPage";
    }


    @GetMapping("/selected/{id}")
    public String selectedID(@PathVariable("id") int id, Model model){
        model.addAttribute("product",productService.getProduct(id));
        model.addAttribute("shoppingCart", shoppingCart.getProductsWithQuantity());
        model.addAttribute("sum",shoppingCart.getResultPrice());
        return "user/selected";
    }

    @PostMapping("/addToShoppingCart/{id}")
    public String addToShoppingCart(@PathVariable("id")int id,@RequestParam("quantity") int quantity){
        shoppingCart.addProduct(productService.getProduct(id),quantity);
        return "redirect:/shop";
    }

    @PostMapping("/addMark/{id}")
    public String addMark(@PathVariable("id")int id, @RequestParam("mark")int mark){
        productService.rate(productService.getProduct(id), mark);
        return "redirect:/shop";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("products", productService.getAll());
        model.addAttribute("shoppingCart", shoppingCart.getProductsWithQuantity());
        model.addAttribute("sum",shoppingCart.getResultPrice());
        return "user/shop";
    }


    @GetMapping("/checkout")
    public String checkout(Model model){
        model.addAttribute("shoppingCart", shoppingCart.getProductsWithQuantity());
        model.addAttribute("sum",shoppingCart.getResultPrice());
        model.addAttribute("user",userService.getCurrentUser());

        return "user/checkout";
    }

    @PostMapping("/makeOrder")
    public String makeOrder(@ModelAttribute("")Order order){
        orderService.completeOrder(order);
        return "redirect:/main"; //кидаем url
    }

    //TODO: удаление с корзины
    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id")int id){
        System.out.println(id);
        shoppingCart.deleteProduct(id);
        return "redirect:/checkout";
    }
}
