package alex.stud.controller;

import alex.stud.entity.Producer;
import alex.stud.entity.Product;
import alex.stud.entity.Supply;
import alex.stud.service.interfaces.OrderService;
import alex.stud.service.interfaces.SupplyService;
import alex.stud.service.interfaces.ProductService;
import alex.stud.service.interfaces.UserService;
import alex.stud.validator.ProducerValidator;
import alex.stud.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @Autowired
    private ProducerValidator producerValidator;

    @Autowired
    private ProductValidator productValidator;

    @GetMapping("")
    public String admin() {
        return "redirect:/admin/checkOrders";
    }

    @GetMapping("/main")
    public String main(){
        return "redirect:/main";
    }

    //Product

    @GetMapping("/addProduct")
    public  String createProduct(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("supplies", supplyService.getAllSupply());
        return "admin/createProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("product") Product product,BindingResult bindingResult, Model model){
        model.addAttribute("supplies",supplyService.getAllSupply()); //TODO:норма это или нет, но костыли еще никто не отменял
        productValidator.validate(product,bindingResult);

        if(bindingResult.hasErrors()){

            return "admin/createProduct";
        }

        productService.save(product);
        return "redirect:/admin/addProduct";
    }

    //ProducER

    @GetMapping("/addProducer")
    public String createProducer(Model model){
        model.addAttribute("producer", new Producer());
        return "admin/createProducer";
    }

    @PostMapping("/addProducer")
    public String addProducer(@ModelAttribute("producer")Producer producer, BindingResult bindingResult) {
        producerValidator.validate(producer, bindingResult);

        if (bindingResult.hasErrors()) {
            return "admin/createProducer";
        }

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
        //TODO:да это надо делать не в контролере, да это вообще не надо делать. явно есть способ получше

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
