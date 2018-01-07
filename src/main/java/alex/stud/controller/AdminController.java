package alex.stud.controller;

import alex.stud.entity.Product;
import alex.stud.service.interfaces.UserService;
import alex.stud.service.interfaces.OrderService;
import alex.stud.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String admin() {
        return "admin/admin";
    }

    @GetMapping("/checkOrders")
    public String adminCheckOrders(Model model) {
        model.addAttribute("user", userService.getAll());
        model.addAttribute("order",orderService.getAll());
        model.addAttribute("product",productService.getAll());
        model.addAttribute("productInOrder", orderService.getAllProductInOrder());
        return "admin/checkOrders";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("")Product product){ //@ModelAttribute("customer")
        productService.save(product);
        return "redirect:/admin";
    }

    @PostMapping("/setOrderStatus/{id}")
    public String addToShoppingCart(@PathVariable("id")int id,@RequestParam("status") String status){
        System.out.println(id + " Complete " + status);
        orderService.setStatus(id,status);
        return "redirect:/admin/checkOrders";
    }


}
