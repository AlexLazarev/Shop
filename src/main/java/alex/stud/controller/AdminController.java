package alex.stud.controller;

import alex.stud.entity.Product;
import alex.stud.service.interfaces.UserService;
import alex.stud.service.interfaces.OrderService;
import alex.stud.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "admin/checkOrders";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("")Product product){ //@ModelAttribute("customer")
        productService.save(product);
        return "redirect:/admin";
    }

}
