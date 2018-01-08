package alex.stud.controller;

import alex.stud.entity.Producer;
import alex.stud.entity.Product;
import alex.stud.entity.Supply;
import alex.stud.service.interfaces.OrderService;
import alex.stud.service.interfaces.SupplyService;
import alex.stud.service.interfaces.ProductService;
import alex.stud.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private SupplyService supplyService;

    @GetMapping("")
    public String admin() {
        return "admin/admin";
    }

    @GetMapping("/addProduct")
    public  String createProduct(Model model){
        model.addAttribute("supply", supplyService.getAllSupply());
        return "admin/createProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("")Product product){ //@ModelAttribute("customer")
        productService.save(product);
        return "redirect:/admin/addProduct";
    }

    @GetMapping("/addProducer")
    public String createProducer(){
        return "admin/createProducer";
    }

    @PostMapping("/addProducer")
    public String addProducer(@ModelAttribute("")Producer producer){
        supplyService.addProducer(producer);
        return "redirect:/admin/addProducer";
    }

    @GetMapping("/addSupply")
    public String createSupply(Model model) {
        model.addAttribute("producers",supplyService.getAllProducer());
        return "admin/createSupply";
    }

    @PostMapping("/addSupply")
    public String addSupply(@ModelAttribute("")Supply supply,@RequestParam("myDate")String date){
        //без парсинга я хз, как получить дату с jsp. о_о
        System.out.println(date);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            supply.setDate(format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //да это надо делать не в контролере, да это вообще не надо делать. явно есть способ получше

        supplyService.save(supply);
        return "redirect:/admin/addSupply";
    }


    @GetMapping("/checkOrders")
    public String adminCheckOrders(Model model) {
        model.addAttribute("user", userService.getAll());
        model.addAttribute("order",orderService.getAll());
        model.addAttribute("product",productService.getAll());
        model.addAttribute("productInOrder", orderService.getAllProductInOrder());
        return "admin/checkOrders";
    }

    @PostMapping("/setOrderStatus/{id}")
    public String addToShoppingCart(@PathVariable("id")int id,@RequestParam("status") String status){
        System.out.println(id + " Complete " + status);
        orderService.setStatus(id,status);
        return "redirect:/admin/checkOrders";
    }


}
